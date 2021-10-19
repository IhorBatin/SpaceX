package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Rocket(

	@Json(name="second_stage")
	val secondStage: SecondStage? = null,

	@Json(name="rocket_id")
	val rocketId: String? = null,

	@Json(name="first_stage")
	val firstStage: FirstStage? = null,

	@Json(name="rocket_type")
	val rocketType: String? = null,

	@Json(name="rocket_name")
	val rocketName: String? = null,

	@Json(name="fairings")
	val fairings: Fairings? = null
) : Parcelable