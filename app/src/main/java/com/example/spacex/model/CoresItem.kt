package com.example.spacex.model

import com.squareup.moshi.Json

data class CoresItem(

	@Json(name="flight")
	val flight: Int? = null,

	@Json(name="landing_type")
	val landingType: Any? = null,

	@Json(name="gridfins")
	val gridfins: Boolean? = null,

	@Json(name="landing_intent")
	val landingIntent: Boolean? = null,

	@Json(name="legs")
	val legs: Boolean? = null,

	@Json(name="land_success")
	val landSuccess: Any? = null,

	@Json(name="landing_vehicle")
	val landingVehicle: Any? = null,

	@Json(name="block")
	val block: Any? = null,

	@Json(name="reused")
	val reused: Boolean? = null,

	@Json(name="core_serial")
	val coreSerial: String? = null
)