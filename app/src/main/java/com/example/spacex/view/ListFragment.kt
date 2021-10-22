package com.example.spacex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.navigateUp
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

    val viewModel: LaunchesViewModel by viewModels()
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
                            LaunchInfoCard(
                                launch = launch,
                                onClick = { onCardClick(launch) }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun onCardClick(launch: LaunchItem) {
        Toast.makeText(requireContext(), "Loading: ${launch.missionName}", Toast.LENGTH_SHORT).show()
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