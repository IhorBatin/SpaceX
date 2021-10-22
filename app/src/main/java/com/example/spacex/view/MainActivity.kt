package com.example.spacex.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.spacex.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var diTestVar: String  // Field injection: when you inject as a type of field in a class
    lateinit var tabletController: NavController

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainView = layoutInflater.inflate(R.layout.activity_main, null)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.frag_detail_container) as NavHostFragment
        val tabletController = navHostFragment.navController
        supportActionBar?.hide()
        setContentView(mainView)
    }
}