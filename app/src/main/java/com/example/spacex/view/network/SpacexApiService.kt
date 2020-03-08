package com.example.spacex.view.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object SpacexApiService {
    private const val BASE_URL = "https://api.spacexdata.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val spacexAPI: SpacexApiInterface = retrofit.create(SpacexApiInterface::class.java)
}