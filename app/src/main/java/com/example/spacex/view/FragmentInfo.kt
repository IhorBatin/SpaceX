package com.example.spacex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spacex.R

class FragmentInfo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        log("onCreateView()-Start")
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        log("onCreateView()-End")
        return view
    }

    fun log(string: String){
        println("debugger FragmentInfo: $string")
    }
}