package com.example.spacex.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.spacex.R

@Composable
fun CardNameInfoComponent(name: String, value: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
        //.border(1.dp, Color.Black)
        //.padding(start = 4.dp, end = 4.dp)
    ) {
        Text(
            text = name,
            color = colorResource(id = R.color.text_color),
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Text(
            text = value,
            color = colorResource(id = R.color.text_color),
            modifier = Modifier.align(alignment = Alignment.CenterEnd)
        )
    }
}
