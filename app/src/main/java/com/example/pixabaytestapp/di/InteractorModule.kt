package com.example.pixabaytestapp.di

import com.example.pixabaytestapp.domain.PixabayInteractor
import com.example.pixabaytestapp.domain.PlayerInteractor
import com.example.pixabaytestapp.domain.impl.PixabayInteractorImpl
import com.example.pixabaytestapp.domain.impl.PlayerInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {

    @Binds
    @Singleton
    abstract fun bindPixabayInteractor(pixabayInteractor: PixabayInteractorImpl): PixabayInteractor

    @Binds
    @Singleton
    abstract fun bindPlayerInteractor(playerInteractorImpl: PlayerInteractorImpl): PlayerInteractor

}