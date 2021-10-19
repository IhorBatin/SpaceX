package com.example.spacex.model

import com.squareup.moshi.Json

data class PayloadsItem(

	@Json(name="payload_type")
	val payloadType: String? = null,

	@Json(name="payload_mass_kg")
	val payloadMassKg: Int? = null,

	@Json(name="payload_id")
	val payloadId: String? = null,

	@Json(name="nationality")
	val nationality: String? = null,

	@Json(name="norad_id")
	val noradId: List<Any?>? = null,

	@Json(name="customers")
	val customers: List<String>? = null,

	@Json(name="orbit")
	val orbit: String? = null,

	@Json(name="orbit_params")
	val orbitParams: OrbitParams? = null,

	@Json(name="payload_mass_lbs")
	val payloadMassLbs: Int? = null,

	@Json(name="reused")
	val reused: Boolean? = null,

	@Json(name="manufacturer")
	val manufacturer: String? = null,

	@Json(name="cargo_manifest")
	val cargoManifest: Any? = null,

	@Json(name="cap_serial")
	val capSerial: String? = null,

	@Json(name="mass_returned_lbs")
	val massReturnedLbs: Any? = null,

	@Json(name="flight_time_sec")
	val flightTimeSec: Int? = null,

	@Json(name="mass_returned_kg")
	val massReturnedKg: Any? = null,

	@Json(name="uid")
	val uid: String? = null
)