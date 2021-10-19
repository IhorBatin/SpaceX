package com.example.spacex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spacex.viewmodel.LaunchesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var diTestVar: String  // Field injection: when you inject as a type of field in a class

    val vm: LaunchesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Viewmodel ${vm.toString()}")

        setContent {
            val launches = vm.pastLaunches.value

            launches.forEach {
                println("Launch: ${it.missionName}")
            }
            MessageCard(diTestVar)
        }
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