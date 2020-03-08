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

        val responseList = spacexRepo.getPastLaunches()

        if(responseList.isEmpty()){
            log("Error: response is empty")
        } else {
            log("Success: We have response of ${responseList.size} objects from SpaceX API")

            //printAll(spacexRepo.getPastLaunches())
        }

        //Here we want to send list of LaunchResponse objects to the view
        emit(responseList)
    }

    // Function For Logging to console
    fun log(string: String){
        println("debugger: $string")
    }

    fun printAll(list: List<LaunchResponse>){
        log("printing ${list.size} elements ...")
        for (element in list) {
            log("ID: ${element.details}")
        }
    }

}
