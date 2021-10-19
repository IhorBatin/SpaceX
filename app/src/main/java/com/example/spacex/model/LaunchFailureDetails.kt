package com.example.spacex.model

import com.squareup.moshi.Json

data class LaunchFailureDetails(

	@Json(name="altitude")
	val altitude: Int? = null,

	@Json(name="reason")
	val reason: String? = null,

	@Json(name="time")
	val time: Int? = null
)