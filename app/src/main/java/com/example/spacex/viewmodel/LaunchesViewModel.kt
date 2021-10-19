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
    private val testString: String,
    private val repo: SpacexRepository // Constrictor Injection: when injection inside of class declaration itself
) : ViewModel() {

    val pastLaunches: MutableState<List<LaunchItem>> = mutableStateOf(listOf())

    init {
        fetchPastLaunches()
        println("Viewmodel $testString")
        println("Viewmodel: ${repo}")
    }

    fun fetchPastLaunches() {
        viewModelScope.launch {
            val list = repo.getPstLaunches()
            pastLaunches.value = list.reversed()
        }
    }

}