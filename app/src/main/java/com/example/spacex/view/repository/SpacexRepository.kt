package com.example.spacex.view.repository

import com.example.spacex.view.network.SpacexApiInterface

class SpacexRepository(private val apiInterface: SpacexApiInterface) {
    suspend fun getPastLaunches() = apiInterface.fetchPastLaunches()
}