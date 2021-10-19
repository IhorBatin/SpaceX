package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Telemetry(

	@Json(name="flight_club")
	val flightClub: String? = null
) : Parcelable