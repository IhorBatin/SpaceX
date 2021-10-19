package com.example.spacex.di

import com.example.spacex.network.LaunchesApiInterface
import com.example.spacex.repository.SpacexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        spacexInterface: LaunchesApiInterface
    ) : SpacexRepository {
        return SpacexRepository(spacexInterface)
    }
}