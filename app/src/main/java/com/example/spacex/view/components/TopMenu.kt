package com.example.spacex.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spacex.R

@Composable
fun TopMenu(
    onPreviousClicked: () -> Unit,
    onUpcomingClicked: () -> Unit,
    onSortClicked: () -> Unit)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.card_background_color))
            //.border(BorderStroke(width = 1.dp, Color.Black))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .align(Alignment.CenterVertically)
                //.border(BorderStroke(width = 1.dp, Color.Black))
        ) {
            TextButton(
                onClick = { onPreviousClicked() },
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp, start = 6.dp, end = 6.dp)
                    .align(Alignment.CenterVertically),
                    //.border(BorderStroke(width = 1.dp, Color.Black)),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text(
                    text = stringResource(R.string.previous_txt),
                    color = colorResource(id = R.color.text_color)
                )
            }
            TextButton(
                onClick = { onUpcomingClicked() },
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp, start = 6.dp, end = 6.dp)
                    .align(Alignment.CenterVertically),
                    //.border(BorderStroke(width = 1.dp, Color.Black)),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text(
                    text = stringResource(R.string.upcoming),
                    color = colorResource(id = R.color.text_color)
                )
            }
        }
        IconButton(
            onClick = { onSortClicked() },
            modifier = Modifier
                .padding(top = 4.dp, bottom = 4.dp, start = 4.dp)
                //.border(BorderStroke(width = 1.dp, Color.Black))
                .wrapContentWidth(Alignment.End)
                .align(Alignment.CenterVertically),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter_list),
                contentDescription = stringResource(id = R.string.filter_icon),
                tint = colorResource(id = R.color.text_color)
            )
        }
    }
}