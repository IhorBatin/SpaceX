package com.example.spacex.model

import com.squareup.moshi.Json

data class LaunchSite(

	@Json(name="site_name")
	val siteName: String? = null,

	@Json(name="site_id")
	val siteId: String? = null,

	@Json(name="site_name_long")
	val siteNameLong: String? = null
)