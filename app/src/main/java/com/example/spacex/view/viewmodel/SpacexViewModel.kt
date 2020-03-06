package com.example.spacex.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import network.SpacexApiService
import repository.SpacexRepository
import utils.LaunchResponse

class SpacexViewModel : ViewModel() {
    private val spacexRepo: SpacexRepository = SpacexRepository(SpacexApiService.spacexAPI)

    val spacexLiveData = liveData {
        val responseList = listOf<LaunchResponse>()

        if(responseList.size < 0){
            log("Error: response is empty")
        } else {
            log("Success: We have response of ${responseList.size} objects")
        }

        //Here we want to send list of LaunchResponse objects to the view
        emit(responseList)
    }

    // Function For Logging to console
    fun log(string: String){
        println("debugger: $string")
    }
}