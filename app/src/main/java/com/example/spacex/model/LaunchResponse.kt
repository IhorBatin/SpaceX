package com.example.spacex.model

import com.squareup.moshi.Json

data class LaunchResponse(

	@Json(name="Response")
	val launches: List<LaunchItem>? = null
)