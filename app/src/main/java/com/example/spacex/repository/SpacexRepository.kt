package com.example.spacex.repository

import com.example.spacex.network.LaunchesApiInterface

class SpacexRepository(private val apiInterface: LaunchesApiInterface) {

    suspend fun getPastLaunches() = apiInterface.getPastLaunches()
    suspend fun getUpcomingLaunches() = apiInterface.getUpcomingLaunches()
}