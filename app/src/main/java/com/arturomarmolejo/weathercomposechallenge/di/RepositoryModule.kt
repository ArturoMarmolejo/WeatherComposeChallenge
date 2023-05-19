package com.arturomarmolejo.weathercomposechallenge.di

import com.arturomarmolejo.weathercomposechallenge.data.rest.NetworkRepository
import com.arturomarmolejo.weathercomposechallenge.data.rest.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesNetworkRepository(
        networkRepositoryImpl: NetworkRepositoryImpl
    ): NetworkRepository

}