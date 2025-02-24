package com.example.pixabaytestapp.domain

import androidx.media3.exoplayer.ExoPlayer

interface PlayerInteractor {

    fun getPlayer(): ExoPlayer

    fun initPlayer(url: String)

    fun releasePlayer()

    fun play()

}