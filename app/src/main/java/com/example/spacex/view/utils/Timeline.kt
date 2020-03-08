package com.example.spacex.view.utils


import com.squareup.moshi.Json


data class Timeline(

	@Json(name="webcast_liftoff")
	val webcastLiftoff: Int? = null
)