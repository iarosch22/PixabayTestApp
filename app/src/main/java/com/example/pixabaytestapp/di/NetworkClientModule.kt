package com.example.pixabaytestapp.di

import com.example.pixabaytestapp.data.NetworkClient
import com.example.pixabaytestapp.data.network.PixabayNetworkClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkClientModule {

    @Binds
    @Singleton
    abstract fun bindPixabayNetworkClient(networkClient: PixabayNetworkClient): NetworkClient

}