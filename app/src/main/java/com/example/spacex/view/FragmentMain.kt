package com.example.spacex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex.R
import com.example.spacex.view.utils.LaunchResponse
import com.example.spacex.view.viewmodel.SpacexViewModel
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : Fragment() {
    private val model: SpacexViewModel by lazy { ViewModelProvider(this).get(SpacexViewModel::class.java)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        log("onCreateView()-Start")
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        setupObservers()

        log("onCreateView()-End")
        return view
    }

    private fun setupObservers(){
        log("setupObservers()-Start")
        model.spacexLiveData.observe(viewLifecycleOwner, Observer {launchList ->
            //log("launchList size -> ${launchList.size}")
            //log("Mission Name: ${launchList[10].missionName}")
            printAll(launchList)

            rv_container.adapter = RecyclerViewAdapter(launchList)
            rv_container.layoutManager = LinearLayoutManager(this.context)
        })
        log("setupObservers()-End")
    }

    fun log(string: String){
        println("debugger: $string")
    }

    fun printAll(list: List<LaunchResponse>){
        log("printing ${list.size} elements ...")
        for (element in list) {
            log("ID: ${element.launchYear}")
        }
    }
}