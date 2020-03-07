package com.example.spacex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spacex.R
import com.example.spacex.view.viewmodel.SpacexViewModel
import kotlinx.android.synthetic.main.activity_main.*

// TODO: Create navigation component
// TODO: Setup Retrofit & GSON get API Request result
// TODO: Verify API response and parse it
// TODO: Create UI with Clickable Recycler View
// TODO: Create layouts for phone for now


class MainActivity : AppCompatActivity() {

    private val model: SpacexViewModel by lazy {ViewModelProvider(this).get(SpacexViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservers()
    }

    private fun setupObservers(){
        model.spacexLiveData.observe(this, Observer {
            log("${it[10].flightNumber}")
            var text = it
            tv_test.text = text[10].details
        })
    }

    fun log(string: String){
        println("debugger: $string")
    }
}
