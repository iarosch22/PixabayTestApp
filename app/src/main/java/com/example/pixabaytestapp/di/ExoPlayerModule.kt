package com.example.pixabaytestapp.di

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import com.example.pixabaytestapp.data.PlayerRepositoryImpl
import com.example.pixabaytestapp.domain.PlayerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExoPlayerModule {

    @Provides
    @Singleton
    fun provideExoPlayer(@ApplicationContext context: Context): ExoPlayer {
        return ExoPlayer.Builder(context).build()
    }

    @Provides
    @Singleton
    fun providePlayerRepository(exoPlayer: ExoPlayer): PlayerRepository {
        return PlayerRepositoryImpl(exoPlayer)
    }

}