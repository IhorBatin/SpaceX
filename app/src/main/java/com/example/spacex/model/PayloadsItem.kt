package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PayloadsItem(

	@Json(name="payload_type")
	val payloadType: String? = null,

	@Json(name="payload_mass_kg")
	val payloadMassKg: Double? = null,

	@Json(name="payload_id")
	val payloadId: String? = null,

	@Json(name="nationality")
	val nationality: String? = null,

	@Json(name="norad_id")
	val noradId: List<Int>? = null,

	@Json(name="customers")
	val customers: List<String>? = null,

	@Json(name="orbit")
	val orbit: String? = null,

	@Json(name="orbit_params")
	val orbitParams: OrbitParams? = null,

	@Json(name="payload_mass_lbs")
	val payloadMassLbs: Double? = null,

	@Json(name="reused")
	val reused: Boolean? = null,

	@Json(name="manufacturer")
	val manufacturer: String? = null,

	@Json(name="cargo_manifest")
	val cargoManifest: String? = null,

	@Json(name="cap_serial")
	val capSerial: String? = null,

	@Json(name="mass_returned_lbs")
	val massReturnedLbs: Double? = null,

	@Json(name="flight_time_sec")
	val flightTimeSec: Int? = null,

	@Json(name="mass_returned_kg")
	val massReturnedKg: Double? = null,

	@Json(name="uid")
	val uid: String? = null
) : Parcelable