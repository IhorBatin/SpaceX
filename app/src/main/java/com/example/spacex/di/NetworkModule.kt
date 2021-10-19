package com.example.spacex.di

import com.example.spacex.network.LaunchesApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideSpacexService() : LaunchesApiInterface {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(LaunchesApiInterface::class.java)
    }
}