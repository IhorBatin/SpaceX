package com.example.spacex.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex.model.LaunchItem
import com.example.spacex.repository.SpacexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel
@Inject
constructor(
    private val repo: SpacexRepository // Constrictor Injection: when injection inside of class declaration itself
) : ViewModel() {

    val queriedLaunches: MutableState<List<LaunchItem>> = mutableStateOf(listOf())

    init {
        fetchPastLaunches()
    }

    private fun fetchPastLaunches() {
        viewModelScope.launch {
            val list = repo.getPastLaunches()
            queriedLaunches.value = list.reversed()
        }
    }

    private fun fetchUpcomingLaunches() {
        viewModelScope.launch {
            val list = repo.getUpcomingLaunches()
            queriedLaunches.value = list.reversed()
        }
    }

    fun onPreviousClicked() {
        fetchPastLaunches()
    }

    fun onUpcomingClicked() {
        fetchUpcomingLaunches()
    }

    fun onSortClicked() {
        queriedLaunches.value = queriedLaunches.value.reversed()
    }

}