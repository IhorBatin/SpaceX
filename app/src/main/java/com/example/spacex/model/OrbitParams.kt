package com.example.spacex.model

import com.squareup.moshi.Json

data class OrbitParams(

	@Json(name="periapsis_km")
	val periapsisKm: Int? = null,

	@Json(name="mean_anomaly")
	val meanAnomaly: Any? = null,

	@Json(name="inclination_deg")
	val inclinationDeg: Int? = null,

	@Json(name="regime")
	val regime: String? = null,

	@Json(name="arg_of_pericenter")
	val argOfPericenter: Any? = null,

	@Json(name="eccentricity")
	val eccentricity: Any? = null,

	@Json(name="apoapsis_km")
	val apoapsisKm: Int? = null,

	@Json(name="semi_major_axis_km")
	val semiMajorAxisKm: Any? = null,

	@Json(name="raan")
	val raan: Any? = null,

	@Json(name="epoch")
	val epoch: Any? = null,

	@Json(name="lifespan_years")
	val lifespanYears: Any? = null,

	@Json(name="reference_system")
	val referenceSystem: String? = null,

	@Json(name="period_min")
	val periodMin: Any? = null,

	@Json(name="mean_motion")
	val meanMotion: Any? = null,

	@Json(name="longitude")
	val longitude: Any? = null
)