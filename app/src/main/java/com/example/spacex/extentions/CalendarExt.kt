package com.example.spacex.extentions

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.toPrettyText(pattern: String = "yyyy-MM-dd HH:mm"): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(time)