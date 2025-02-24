package com.example.pixabaytestapp.domain

import androidx.media3.exoplayer.ExoPlayer

interface PlayerRepository {

    fun getPlayer(): ExoPlayer

    fun initPlayer(url: String)

    fun releasePlayer()

    fun play()

}