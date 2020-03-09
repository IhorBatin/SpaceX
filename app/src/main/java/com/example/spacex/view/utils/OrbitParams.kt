package com.example.spacex.view.utils

data class OrbitParams(
    val apoapsis_km: Double?,
    val arg_of_pericenter: Double?,
    val eccentricity: Double?,
    val epoch: String?,
    val inclination_deg: Double?,
    val lifespan_years: Any?,
    val longitude: Any?,
    val mean_anomaly: Double?,
    val mean_motion: Double?,
    val periapsis_km: Double?,
    val period_min: Double?,
    val raan: Double?,
    val reference_system: String?,
    val regime: String?,
    val semi_major_axis_km: Double?
)