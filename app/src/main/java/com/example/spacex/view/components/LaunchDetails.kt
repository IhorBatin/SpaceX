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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spacex.R
import com.example.spacex.extentions.toCalendar
import com.example.spacex.extentions.toPrettyText
import com.example.spacex.model.LaunchItem
import com.example.spacex.util.loadImage

@Composable
fun NoMissionSelectedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.mission_not_selected),
            style = MaterialTheme.typography.h4,
            color = colorResource(R.color.text_color),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LaunchDetailsScreen(
    launch: LaunchItem?,
    onCloseClick: () -> Unit,
    linkClicked: (String?) -> Unit
) {
    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        IconButton(
            onClick = { onCloseClick() },
            modifier = Modifier
                .padding(top = 4.dp, bottom = 4.dp, start = 4.dp)
                //.border(BorderStroke(width = 1.dp, Color.Black))
                .wrapContentWidth(Alignment.End)
                //.align(Alignment.CenterVertically),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = stringResource(id = R.string.filter_icon),
                tint = colorResource(id = R.color.text_color)
            )
        }
        val image = loadImage(
            url = launch?.links?.missionPatch,
            defaultImage = R.drawable.rocket_default_image
        ).value
        image?.let { img ->
            Image(
                bitmap = img.asImageBitmap(),
                contentDescription = stringResource(R.string.patch_image_large),
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
                text = stringResource(R.string.details),
                color = colorResource(id = R.color.text_color),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            launch?.flightNumber?.let {
                CardKeyAndValueComponent(name = stringResource(R.string.flight_no), value = it.toString())
            }
            launch?.launchDateUtc?.let { date ->
                val calendar = date.toCalendar()
                val dateText = calendar?.toPrettyText()
                CardKeyAndValueComponent(
                    name = stringResource(R.string.launch_date),
                    value = stringResource(id = R.string.time_utc, dateText.toString())
                )
            }
            launch?.launchSite?.let { site ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.launch_site),
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
                CardCheckStatusComponent(
                    name = stringResource(R.string.launch_success),
                    status = successStatus
                )
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
                    text = stringResource(R.string.launch_failure_details,
                        failureDetails.reason.toString(),
                        failureDetails.time.toString(),
                        failureDetails.altitude.toString()
                    ),
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
                text = stringResource(R.string.rocket),
                color = colorResource(id = R.color.text_color),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            launch?.rocket?.rocketName?.let { name ->
                CardKeyAndValueComponent(name = stringResource(R.string.rocket_name), value = name)
            }
            launch?.rocket?.rocketType?.let { type ->
                CardKeyAndValueComponent(name = stringResource(R.string.rocket_type), value = type)
            }
            launch?.rocket?.firstStage?.cores?.forEachIndexed { index, cores ->
                if (index > 0) {
                    CustomDivider()
                }
                cores.coreSerial?.let { serial ->
                    CardKeyAndValueComponent(name = stringResource(R.string.core_serial), value = serial)
                }
                cores.landingType?.let { landType ->
                    CardKeyAndValueComponent(name = stringResource(R.string.landing_type), value = landType)
                }
                cores.landStatus?.let { landed ->
                    CardCheckStatusComponent(name = stringResource(R.string.landing_success), status = landed)
                }
                cores.reused?.let { reused ->
                    CardCheckStatusComponent(name = stringResource(R.string.reused), status = reused)
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
                text = stringResource(R.string.payload),
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
                CardKeyAndValueComponent(name = stringResource(R.string.payload_id), value = payload.payloadId.toString())
                CardKeyAndValueComponent(name = stringResource(R.string.manufacturer), value = payload.manufacturer.toString())
                CardKeyAndValueComponent(name = stringResource(R.string.payload_type), value = payload.payloadType.toString())
                CardKeyAndValueComponent(name = stringResource(R.string.nationality), value = payload.nationality.toString())
                CardKeyAndValueComponent(name = stringResource(R.string.mass),
                    value = stringResource(R.string.mass_kg, payload.payloadMassKg.toString())
                )
                CardKeyAndValueComponent(name = stringResource(R.string.orbit), value = payload.orbit.toString())
                payload.orbitParams?.let { params ->
                    params.referenceSystem?.let {
                        CardKeyAndValueComponent(name = stringResource(R.string.ref_sys), value = it)
                    }
                    params.regime?.let {
                        CardKeyAndValueComponent(name = stringResource(R.string.regine), value = it)
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
                    text = stringResource(R.string.video),
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
                    text = stringResource(R.string.press),
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
                    text = stringResource(R.string.wiki),
                    color = colorResource(id = R.color.text_color),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}