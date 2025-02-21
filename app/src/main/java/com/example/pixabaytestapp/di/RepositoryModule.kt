package com.example.pixabaytestapp.di

import com.example.pixabaytestapp.data.network.PixabayRepositoryImpl
import com.example.pixabaytestapp.domain.PixabayRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPixabayRepository(pixabayRepository: PixabayRepositoryImpl): PixabayRepository

}