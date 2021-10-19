package com.example.spacex.model

import com.squareup.moshi.Json

data class Fairings(

	@Json(name="recovered")
	val recovered: Boolean? = null,

	@Json(name="recovery_attempt")
	val recoveryAttempt: Boolean? = null,

	@Json(name="ship")
	val ship: String? = null,

	@Json(name="reused")
	val reused: Boolean? = null
)