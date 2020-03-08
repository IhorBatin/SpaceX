package com.example.spacex.view.utils


import com.squareup.moshi.Json


data class Telemetry(

	@Json(name="flight_club")
	val flightClub: Any? = null
)