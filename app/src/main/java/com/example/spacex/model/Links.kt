package com.example.spacex.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Links(

	@Json(name="mission_patch_small")
    var missionPatchSmall: String? = null,

	@Json(name="mission_patch")
	val missionPatch: String? = null,

	@Json(name="video_link")
	val videoLink: String? = null,

	@Json(name="flickr_images")
	val flickrImages: List<String>? = null,

	@Json(name="reddit_recovery")
	val redditRecovery: String? = null,

	@Json(name="reddit_media")
	val redditMedia: String? = null,

	@Json(name="reddit_campaign")
	val redditCampaign: String? = null,

	@Json(name="wikipedia")
	val wikipedia: String? = null,

	@Json(name="reddit_launch")
	val redditLaunch: String? = null,

	@Json(name="youtube_id")
	val youtubeId: String? = null,

	@Json(name="presskit")
	val pressKit: String? = null,

	@Json(name="article_link")
	val articleLink: String? = null
) : Parcelable