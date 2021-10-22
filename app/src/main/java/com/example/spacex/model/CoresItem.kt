package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class CoresItem(

	@Json(name="flight")
	val flight: Int? = null,

	@Json(name="landing_type")
	val landingType: String? = null,

	@Json(name="gridfins")
	val gridfins: Boolean? = null,

	@Json(name="landing_intent")
	val landingIntent: Boolean? = null,

	@Json(name="legs")
	val legs: Boolean? = null,

	@Json(name="land_success")
	val landSuccess: Boolean? = null,

	@Json(name="landing_vehicle")
	val landingVehicle: String? = null,

	@Json(name="block")
	val block: Int? = null,

	@Json(name="reused")
	val reused: Boolean? = null,

	@Json(name="core_serial")
	val coreSerial: String? = null
) : Parcelable {

	val landStatus: Boolean? = if(landingIntent == true) landSuccess else null
}