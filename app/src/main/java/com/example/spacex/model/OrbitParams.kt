package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class OrbitParams(

	@Json(name="periapsis_km")
	val periapsisKm: Double? = null,

	@Json(name="mean_anomaly")
	val meanAnomaly: Double? = null,

	@Json(name="inclination_deg")
	val inclinationDeg: Double? = null,

	@Json(name="regime")
	val regime: String? = null,

	@Json(name="arg_of_pericenter")
	val argOfPericenter: Double? = null,

	@Json(name="eccentricity")
	val eccentricity: Float? = null,

	@Json(name="apoapsis_km")
	val apoapsisKm: Double? = null,

	@Json(name="semi_major_axis_km")
	val semiMajorAxisKm: Double? = null,

	@Json(name="raan")
	val raan: Double? = null,

	@Json(name="epoch")
	val epoch: String? = null,

	@Json(name="lifespan_years")
	val lifespanYears: Double? = null,

	@Json(name="reference_system")
	val referenceSystem: String? = null,

	@Json(name="period_min")
	val periodMin: Double? = null,

	@Json(name="mean_motion")
	val meanMotion: Double? = null,

	@Json(name="longitude")
	val longitude: Double? = null
) : Parcelable