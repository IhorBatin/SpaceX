package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LaunchItem(

	@Json(name="launch_year")
	val launchYear: String? = null,

	@Json(name="launch_date_utc")
	val launchDateUtc: String? = null,

	@Json(name="last_ll_launch_date")
	val lastLlLaunchDate: String? = null,

	@Json(name="is_tentative")
	val isTentative: Boolean? = null,

	@Json(name="rocket")
	val rocket: Rocket? = null,

	@Json(name="last_wiki_launch_date")
	val lastWikiLaunchDate: String? = null,

	@Json(name="mission_id")
	val missionId: List<String>? = null,

	@Json(name="launch_date_source")
	val launchDateSource: String? = null,

	@Json(name="last_ll_update")
	val lastLlUpdate: String? = null,

	@Json(name="crew")
	val crew: List<String>? = null,

	@Json(name="launch_date_local")
	val launchDateLocal: String? = null,

	@Json(name="tentative_max_precision")
	val tentativeMaxPrecision: String? = null,

	@Json(name="launch_success")
	val launchSuccess: Boolean? = null,

	@Json(name="links")
	val links: Links? = null,

	@Json(name="details")
	val details: String? = null,

	@Json(name="launch_site")
	val launchSite: LaunchSite? = null,

	@Json(name="last_date_update")
	val lastDateUpdate: String? = null,

	@Json(name="last_wiki_revision")
	val lastWikiRevision: String? = null,

	@Json(name="mission_name")
	val missionName: String? = null,

	@Json(name="static_fire_date_utc")
	val staticFireDateUtc: String? = null,

	@Json(name="last_wiki_update")
	val lastWikiUpdate: String? = null,

	@Json(name="flight_number")
	val flightNumber: Int? = null,

	@Json(name="launch_window")
	val launchWindow: Int? = null,

	@Json(name="ships")
	val ships: List<String>? = null,

	@Json(name="launch_date_unix")
	val launchDateUnix: Int? = null,

	@Json(name="static_fire_date_unix")
	val staticFireDateUnix: Int? = null,

	@Json(name="tbd")
	val tbd: Boolean? = null,

	@Json(name="timeline")
	val timeline: Timeline? = null,

	@Json(name="telemetry")
	val telemetry: Telemetry? = null,

	@Json(name="upcoming")
	val upcoming: Boolean? = null,

	@Json(name="launch_failure_details")
	val launchFailureDetails: LaunchFailureDetails? = null
) : Parcelable