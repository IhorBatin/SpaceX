package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LaunchFailureDetails(

	@Json(name="altitude")
	val altitude: Int? = null,

	@Json(name="reason")
	val reason: String? = null,

	@Json(name="time")
	val time: Int? = null
) : Parcelable