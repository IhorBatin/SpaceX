package com.example.spacex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spacex.R
import com.example.spacex.view.viewmodel.SpacexViewModel
import kotlinx.android.synthetic.main.activity_main.*

// TODO: Make possibe coming back frm info fragment
// TODO: Create layouts for phone for now

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log("MainActivity onCreate()")
    }

    fun log(string: String){
        println("debugger: $string")
    }
}
