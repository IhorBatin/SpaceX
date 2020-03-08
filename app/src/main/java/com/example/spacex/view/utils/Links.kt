package com.example.spacex.view.utils


import com.squareup.moshi.Json


data class Links(

	@Json(name="mission_patch_small")
	val missionPatchSmall: String? = null,

	@Json(name="mission_patch")
	val missionPatch: String? = null,

	@Json(name="video_link")
	val videoLink: String? = null,

	@Json(name="flickr_images")
	val flickrImages: List<Any?>? = null,

	@Json(name="reddit_recovery")
	val redditRecovery: Any? = null,

	@Json(name="reddit_media")
	val redditMedia: Any? = null,

	@Json(name="reddit_campaign")
	val redditCampaign: Any? = null,

	@Json(name="wikipedia")
	val wikipedia: String? = null,

	@Json(name="reddit_launch")
	val redditLaunch: Any? = null,

	@Json(name="youtube_id")
	val youtubeId: String? = null,

	@Json(name="presskit")
	val presskit: Any? = null,

	@Json(name="article_link")
	val articleLink: String? = null
)