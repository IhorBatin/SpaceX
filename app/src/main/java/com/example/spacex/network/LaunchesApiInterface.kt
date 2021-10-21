package com.example.spacex.network

import com.example.spacex.model.LaunchItem
import retrofit2.http.GET

interface LaunchesApiInterface {

    @GET("/v3/launches/past")
    suspend fun getPastLaunches() : List<LaunchItem>

    @GET("/v3/launches/upcoming")
    suspend fun getUpcomingLaunches(): List<LaunchItem>
}