package com.example.spacex.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.spacex.view.network.SpacexApiService
import com.example.spacex.view.repository.SpacexRepository
import com.example.spacex.view.utils.LaunchResponse

class SpacexViewModel : ViewModel() {
    private val spacexRepo: SpacexRepository = SpacexRepository(SpacexApiService.spacexAPI)

    val spacexLiveData = liveData(Dispatchers.IO) {
        log("Starting SpacexViwModel")

        // getting list of responses and saving it in reversed order: newest to oldest
        val responseList = spacexRepo.getPastLaunches().reversed()

        if(responseList.isEmpty()){
            log("Error: response is empty")
        } else {
            log("Success: We have response of ${responseList.size} objects from SpaceX API")
            //printAllMissions(spacexRepo.getPastLaunches())
        }

        //Here we want to send list of LaunchResponse objects to the view
        emit(responseList)
    }

    // Function For Logging to console
    private fun log(string: String){
        println("debugger: $string")
    }

    private fun printAllMissions(list: List<LaunchResponse>){
        log("\n\n=====================================")
        for (element in list) {
            log("Mission #${element.flight_number} -> ${element.mission_name}")
        }
        log("=====================================\n\n")
    }
}
