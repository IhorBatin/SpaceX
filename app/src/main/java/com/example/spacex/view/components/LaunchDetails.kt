package com.example.spacex.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spacex.R
import com.example.spacex.extentions.toCalendar
import com.example.spacex.extentions.toPrettyText
import com.example.spacex.model.LaunchItem
import com.example.spacex.util.loadImage

@Composable
fun LaunchDetailsScreen(
    launch: LaunchItem?,
    linkClicked: (String?) -> Unit
) {
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
        MediaCard(launch = launch) { linkClicked(it) }
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
                CardKeyAndValueComponent(name = "Flight No", value = it.toString())
            }
            launch?.launchDateUtc.let { date ->
                val calendar = date?.toCalendar()
                val dateText = calendar?.toPrettyText()
                CardKeyAndValueComponent(name = "Launch Date", value = "$dateText UTC")
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
                CardKeyAndValueComponent(name = "Name", value = name.toString())
            }
            launch?.rocket?.rocketType.let { type ->
                CardKeyAndValueComponent(name = "Type", value = type.toString())
            }
            launch?.rocket?.firstStage?.cores?.forEachIndexed { index, cores ->
                if (index > 0) {
                    CustomDivider()
                }
                cores.coreSerial?.let { serial ->
                    CardKeyAndValueComponent(name = "Core Serial", value = serial)
                }
                cores.landingType?.let { landType ->
                    CardKeyAndValueComponent(name = "Landing Type", value = landType)
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
            var payloadItems = 0
            launch?.rocket?.secondStage?.payloads?.forEachIndexed { index, payload ->
                if (index > 0) {
                    CustomDivider()
                }
                CardKeyAndValueComponent(name = "Payload ID", value = payload.payloadId.toString())
                CardKeyAndValueComponent(name = "Manufacturer", value = payload.manufacturer.toString())
                CardKeyAndValueComponent(name = "Type", value = payload.payloadType.toString())
                CardKeyAndValueComponent(name = "Nationality", value = payload.nationality.toString())
                CardKeyAndValueComponent(name = "Mass", value = "${payload.payloadMassKg} kg")
                CardKeyAndValueComponent(name = "Orbit", value = payload.orbit.toString())
                payload.orbitParams?.let { params ->
                    params.referenceSystem?.let {
                        CardKeyAndValueComponent(name = "Reference System", value = it)
                    }
                    params.regime?.let {
                        CardKeyAndValueComponent(name = "Regime", value = it)
                    }
                }
                payloadItems++
            }
        }
    }
}

@Composable
fun MediaCard(launch: LaunchItem?, linkClicked: (String?) -> Unit){
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = colorResource(id = R.color.card_background_color),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),

            contentAlignment = Alignment.Center
        ) {
            TextButton(
                onClick = { linkClicked(launch?.links?.videoLink) },
                modifier = Modifier
                    .padding(4.dp)
                    .padding(start = 22.dp)
                    .align(Alignment.CenterStart)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_television),
                    contentDescription = "",
                    tint = colorResource(id = R.color.text_color),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = " VIDEO",
                    color = colorResource(id = R.color.text_color),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            TextButton(
                onClick = { linkClicked(launch?.links?.pressKit) },
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Center)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_newspaper),
                    contentDescription = "",
                    tint = colorResource(id = R.color.text_color),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = " PRESS",
                    color = colorResource(id = R.color.text_color),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            TextButton(
                onClick = { linkClicked(launch?.links?.wikipedia)},
                modifier = Modifier
                    .padding(4.dp)
                    .padding(end = 22.dp)
                    .align(Alignment.CenterEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_wikipedia),
                    contentDescription = "",
                    tint = colorResource(id = R.color.text_color),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = " WIKI",
                    color = colorResource(id = R.color.text_color),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}