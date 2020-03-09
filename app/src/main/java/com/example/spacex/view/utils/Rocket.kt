package com.example.spacex.view.utils

data class Rocket(
    val fairings: Any,
    val first_stage: FirstStage,
    val rocket_id: String,
    val rocket_name: String,
    val rocket_type: String,
    val second_stage: SecondStage
)