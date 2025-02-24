package com.example.pixabaytestapp.di

import androidx.media3.exoplayer.ExoPlayer
import com.example.pixabaytestapp.data.PlayerRepositoryImpl
import com.example.pixabaytestapp.data.network.PixabayRepositoryImpl
import com.example.pixabaytestapp.domain.PixabayRepository
import com.example.pixabaytestapp.domain.PlayerRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
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