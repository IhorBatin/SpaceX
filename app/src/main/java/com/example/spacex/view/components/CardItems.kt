package com.example.spacex.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.spacex.R

@Composable
fun CardKeyAndValueComponent(name: String, value: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
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

@Composable
fun CardCheckStatusComponent(name: String, status: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = name,
            color = colorResource(id = R.color.text_color),
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Image(
            painter = when(status) {
                true -> painterResource(id = R.drawable.ic_success)
                else -> painterResource(id = R.drawable.ic_fail)
            },
            contentDescription = "Success icon",
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun CustomDivider() {
    Spacer(modifier = Modifier.height(6.dp))
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .height(2.dp)
                .background(color = colorResource(id = R.color.text_color)),
        )
    }
    Spacer(modifier = Modifier.height(6.dp))
}