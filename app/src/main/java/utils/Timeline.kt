package utils


import com.squareup.moshi.Json


data class Timeline(

	@Json(name="webcast_liftoff")
	val webcastLiftoff: Int? = null
)