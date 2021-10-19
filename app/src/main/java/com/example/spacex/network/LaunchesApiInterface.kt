package com.example.spacex.network

import com.example.spacex.model.LaunchResponse
import retrofit2.http.GET

interface LaunchesApiInterface {

    @GET("/v3/launches")
    suspend fun getPastLaunches() : LaunchResponse
}