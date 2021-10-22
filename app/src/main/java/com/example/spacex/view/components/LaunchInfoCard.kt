package com.example.spacex.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import androidx.compose.ui.unit.dp
import com.example.spacex.R
import com.example.spacex.model.LaunchItem
import com.example.spacex.util.loadImage


@Composable
fun LaunchInfoCard(
    launch: LaunchItem,
    onClick: (LaunchItem) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(top = 4.dp, bottom = 4.dp, start = 4.dp, end = 4.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, colorResource(id = R.color.card_border_color)),
        backgroundColor = colorResource(id = R.color.card_background_color)
        //onClick = { onClick() } Not working currently
    ) {
        Row(
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
        ) {
            val image = loadImage(
                url = launch.links?.missionPatchSmall,
                defaultImage = R.drawable.rocket_default_image
            ).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "Image of a Patch",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(100.dp)
                        .padding(6.dp)
                        .align(Alignment.CenterVertically),
                    //.clickable { onClick() }, // Using this for now as whole card has issues with onClick,,
                    contentScale = ContentScale.Fit
                )
            }
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                launch.missionName?.let { missionName ->
                    Text(
                        text = missionName,
                        modifier = Modifier
                            .fillMaxWidth(),
                        //.clickable { onClick() }, // Using this for now as whole card has issues with onClick,
                        style = MaterialTheme.typography.h5,
                        color = colorResource(id = R.color.text_color)
                    )
                }
                launch.rocket?.rocketName?.let { rocket ->
                    Text(
                        text = rocket,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h6,
                        color = colorResource(id = R.color.text_color)
                    )
                }
                launch.launchYear?.let { year ->
                    Text(
                        text = year,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h6,
                        color = colorResource(id = R.color.text_color)
                    )
                }
                Button(
                    onClick = { onClick(launch) },
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                        .border(1.dp, Color.Cyan)
                        .background(Color.Magenta)
                ) {

                }
            }
        }
    }
}