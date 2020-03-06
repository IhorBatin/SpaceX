package network

import retrofit2.http.GET
import utils.LaunchResponse

interface SpacexApiInterface {
    @GET("/v3/launches/past")
    suspend fun fetchPastLaunches() : List<LaunchResponse>
}