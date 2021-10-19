package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class SecondStage(

	@Json(name="payloads")
	val payloads: List<PayloadsItem>? = null,

	@Json(name="block")
	val block: Int? = null
) : Parcelable