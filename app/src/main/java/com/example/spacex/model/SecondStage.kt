package com.example.spacex.model

import com.squareup.moshi.Json

data class SecondStage(

	@Json(name="payloads")
	val payloads: List<PayloadsItem>? = null,

	@Json(name="block")
	val block: Int? = null
)