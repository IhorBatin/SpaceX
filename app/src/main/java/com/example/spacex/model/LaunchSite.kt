package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LaunchSite(

	@Json(name="site_name")
	val siteName: String? = null,

	@Json(name="site_id")
	val siteId: String? = null,

	@Json(name="site_name_long")
	val siteNameLong: String? = null
) : Parcelable