package repository

import network.SpacexApiInterface

class SpacexRepository(private val apiInterface: SpacexApiInterface) {
    suspend fun getPastLaunches() = apiInterface.fetchPastLaunches()
}