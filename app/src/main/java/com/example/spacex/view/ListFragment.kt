package com.example.spacex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.spacex.R
import com.example.spacex.view.components.LaunchInfoCard
import com.example.spacex.viewmodel.LaunchesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    val viewModel: LaunchesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {

            setContent {
                val launches = viewModel.pastLaunches.value

                LazyColumn(
                    modifier = Modifier
                        .background(colorResource(id = R.color.background_color))
                ) {
                    itemsIndexed(items = launches) { index, launch ->
                        LaunchInfoCard(launch = launch, onClick = { onClick() })
                    }
                }
            }
        }
    }

    fun onClick() {
        Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
    }


    @Preview
    @Composable
    fun MessageCard(name: String = "Test") {
        Card(
            modifier = Modifier
                .fillMaxSize()
                //.border(border = BorderStroke(width = 3.dp, Color.Green))
                .background(color = Color.Gray)
                .padding(15.dp),
            elevation = 8.dp,

            ) {
            Column(
                modifier = Modifier
                    .background(Color.Cyan)
            ) {
                Text(
                    text = name,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "text 2",
                )
                Text(
                    text = "text 3",
                )

            }



        }

    }
}