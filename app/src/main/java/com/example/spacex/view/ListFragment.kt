package com.example.spacex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.spacex.R
import com.example.spacex.extentions.isTabletMode
import com.example.spacex.model.LaunchItem
import com.example.spacex.util.LAUNCH_INFO
import com.example.spacex.view.components.LaunchInfoCard
import com.example.spacex.view.components.TopMenu
import com.example.spacex.viewmodel.LaunchesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: LaunchesViewModel by viewModels()
    private val tabletController by lazy { (activity as MainActivity).tabletController }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val launches = viewModel.queriedLaunches.value
                Column {
                    TopMenu(
                        { viewModel.onPreviousClicked() },
                        { viewModel.onUpcomingClicked() },
                        { viewModel.onSortClicked() }
                    )
                    LazyColumn {
                        items(launches) { launch ->
                            LaunchInfoCard(launch = launch) {
                                onCardClick(it)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun onCardClick(launch: LaunchItem) {
        Toast.makeText(
                requireContext(),
                getString(R.string.loading, launch.missionName),
                Toast.LENGTH_SHORT)
            .show()
        navigateToDetailScreen(launch)
    }

    private fun navigateToDetailScreen(launch: LaunchItem) {
        val bundle = Bundle().apply { putParcelable(LAUNCH_INFO, launch) }
        when (isTabletMode()) {
            true -> tabletController.apply {
                navigateUp()
                navigate(R.id.detailFragment, bundle)
            }
            false -> findNavController().navigate(R.id.detailFragment, bundle)
        }
    }

}