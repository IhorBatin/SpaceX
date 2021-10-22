package com.example.spacex.extentions

import com.example.spacex.util.DEFAULT_DATE_PATTERN
import java.text.SimpleDateFormat
import java.util.*

/**
 * Converts server string to Calendar object or null if not possible
 *
 * [inputPattern] is the pattern of the timestamp to be converted
 */
fun String.toCalendar(inputPattern: String = DEFAULT_DATE_PATTERN): Calendar? {
    val sdf = SimpleDateFormat(inputPattern, Locale.getDefault())
    val date = try {
        sdf.parse(this)
    } catch (e: Exception) {
        null
    }
    return when (date) {
        null -> null
        else -> Calendar.getInstance().apply { time = date }
    }
}