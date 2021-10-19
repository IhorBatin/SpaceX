package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Fairings(

	@Json(name="recovered")
	val recovered: Boolean? = null,

	@Json(name="recovery_attempt")
	val recoveryAttempt: Boolean? = null,

	@Json(name="ship")
	val ship: String? = null,

	@Json(name="reused")
	val reused: Boolean? = null
) : Parcelable