package com.example.spacex.view.network

import com.example.spacex.view.utils.LaunchResponse
import retrofit2.http.GET

interface SpacexApiInterface {
    @GET("/v3/launches/past")
    suspend fun fetchPastLaunches() : List<LaunchResponse>
}