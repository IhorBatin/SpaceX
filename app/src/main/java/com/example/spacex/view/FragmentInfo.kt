package com.example.spacex.view

import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.spacex.R
import com.example.spacex.databinding.FragmentInfoBinding
import com.example.spacex.view.utils.LaunchResponse

class FragmentInfo : Fragment() {

    lateinit var binding: FragmentInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        log("onCreateView()-Start")

        // Getting Data from MainFragment through Bundle()
        val launch: LaunchResponse = arguments?.getSerializable("launchDetails") as LaunchResponse
        log(launch.mission_name)

        // Binding data to fragment_info fragment, allowing it to return back to previous Frag on back button press
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info,
                container, false)
        binding.launchDetails = launch

        log("onCreateView()-End")
        return binding.root
    }

/*
    fun TextView.showDate(date: String?){
        this.text  = "Some Random Date ..."
    }
*/

    fun log(string: String){
        println("debugger FragmentInfo: $string")
    }
}