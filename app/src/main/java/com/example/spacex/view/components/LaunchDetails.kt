package com.example.spacex.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())
    ){
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
        RocketStatsCard(launch)
        PayloadStatsCard(launch)
    }
}

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
            launch?.flightNumber?.let {
                CardNameInfoComponent(name = "Flight No", value = it.toString())
            }
            launch?.launchDateUtc.let { date ->
                val calendar = date?.toCalendar()
                val dateText = calendar?.toPrettyText()
                CardNameInfoComponent(name = "Launch Date", value = "$dateText UTC")
            }
            launch?.launchSite?.let { site ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Launch Site",
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier.align(Alignment.TopStart)
                    )
                    Text(
                        text = site.siteNameLong.toString(),
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier
                            .fillMaxWidth(0.70f)
                            .align(alignment = Alignment.CenterEnd),
                        textAlign = TextAlign.End
                    )
                }
            }
            launch?.launchSuccess?.let { successStatus ->
                CardCheckStatusComponent(name = "Launch Success", status = successStatus)
            }
            launch?.details?.let {
                Text(
                    text = it,
                    color = colorResource(id = R.color.text_color),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 4.dp, start = 4.dp, end = 4.dp),
                    textAlign = TextAlign.Center
                )
            }
            launch?.launchFailureDetails?.let { failureDetails ->
                Text(
                    text = "${failureDetails.reason}. Time: ${failureDetails.time} sec. Altitude: ${failureDetails.altitude} km",
                    color = colorResource(id = R.color.text_color),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 4.dp, start = 4.dp, end = 4.dp),
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Composable
fun RocketStatsCard(launch: LaunchItem?) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = colorResource(id = R.color.card_background_color)
    ) {
        Column {
            Text(
                text = "ROCKET",
                color = colorResource(id = R.color.text_color),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            launch?.rocket?.rocketName.let { name ->
                CardNameInfoComponent(name = "Name", value = name.toString())
            }
            launch?.rocket?.rocketType.let { type ->
                CardNameInfoComponent(name = "Type", value = type.toString())
            }
            launch?.rocket?.firstStage?.cores?.forEach { cores ->
                Spacer(modifier = Modifier.height(8.dp))
                cores.coreSerial?.let { serial ->
                    CardNameInfoComponent(name = "Core Serial", value = serial)
                }
                cores.landingType?.let { landType ->
                    CardNameInfoComponent(name = "Landing Type", value = landType)
                }
                cores.landStatus?.let { landed ->
                    CardCheckStatusComponent(name = "Landing Success", status = landed)
                }
                cores.reused?.let { reused ->
                    CardCheckStatusComponent(name = "Reused", status = reused)
                }
            }

        }
    }
}

@Composable
fun PayloadStatsCard(launch: LaunchItem?) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = colorResource(id = R.color.card_background_color)
    ) {
        Column {
            Text(
                text = "PAYLOAD",
                color = colorResource(id = R.color.text_color),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            launch?.rocket?.secondStage?.payloads?.forEach { payload ->
                Spacer(modifier = Modifier.height(8.dp))
                CardNameInfoComponent(name = "Payload ID", value = payload.payloadId.toString())
                CardNameInfoComponent(name = "Manufacturer", value = payload.manufacturer.toString())
                CardNameInfoComponent(name = "Type", value = payload.payloadType.toString())
                CardNameInfoComponent(name = "Nationality", value = payload.nationality.toString())
                CardNameInfoComponent(name = "Mass", value = "${payload.payloadMassKg} kg")
                CardNameInfoComponent(name = "Orbit", value = payload.orbit.toString())
                payload.orbitParams?.let { params ->
                    params.referenceSystem?.let {
                        CardNameInfoComponent(name = "Reference System", value = it)
                    }
                    params.regime?.let {
                        CardNameInfoComponent(name = "Regime", value = it)
                    }
                }
            }
        }
    }
}