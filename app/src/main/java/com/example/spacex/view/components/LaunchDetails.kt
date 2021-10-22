package com.example.spacex.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spacex.R
import com.example.spacex.extentions.toCalendar
import com.example.spacex.extentions.toPrettyText
import com.example.spacex.model.LaunchItem
import com.example.spacex.util.loadImage


@Composable
fun LaunchDetailsScreen(launch: LaunchItem?) {
    Column {
        val image = loadImage(
            url = launch?.links?.missionPatch,
            defaultImage = R.drawable.rocket_default_image
        ).value
        image?.let { img ->
            Image(
                bitmap = img.asImageBitmap(),
                contentDescription = "Image of a Patch, large",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 4.dp, start = 4.dp, end = 4.dp)
                    .align(Alignment.CenterHorizontally),
                //.clickable { onClick() }, // Using this for now as whole card has issues with onClick,,
                contentScale = ContentScale.Fit
            )
        }
        launch?.missionName?.let {
            Text(
                text = it,
                color = colorResource(id = R.color.text_color),
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
        }
        DetailsCard(launch)

    }
}
/**
***In Details Card
Flight Number
Date
Launch Site
Launch Success
Details

 */

@Composable
fun DetailsCard(launch: LaunchItem?) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = colorResource(id = R.color.card_background_color)
    ) {
        Column {
            Text(
                text = "DETAILS",
                color = colorResource(id = R.color.text_color),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            launch?.flightNumber?.let { // Have to use Box in order to use .align() on text children
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        //.border(1.dp, Color.Black)
                    //.padding(start = 4.dp, end = 4.dp)
                ) {
                    Text(
                        text = "Flight No",
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                    Text(
                        text = it.toString(),
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier.align(alignment = Alignment.CenterEnd)
                    )
                }
            }
            launch?.launchDateUtc.let { date ->
                val calendar = date?.toCalendar()
                val dateTex = calendar?.toPrettyText()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        //.border(1.dp, Color.Black)
                        //.padding(start = 4.dp, end = 4.dp)
                ) {
                    Text(
                        text = "Launch Date",
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                    Text(
                        text = "$dateTex UTC",
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier.align(alignment = Alignment.CenterEnd)
                    )
                }
            }

        }
    }
}