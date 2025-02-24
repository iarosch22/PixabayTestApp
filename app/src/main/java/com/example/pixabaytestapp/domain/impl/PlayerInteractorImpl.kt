package com.example.pixabaytestapp.domain.impl

import androidx.media3.exoplayer.ExoPlayer
import com.example.pixabaytestapp.domain.PlayerInteractor
import com.example.pixabaytestapp.domain.PlayerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerInteractorImpl @Inject constructor(private val repository: PlayerRepository): PlayerInteractor {

    override fun getPlayer(): ExoPlayer {
        return repository.getPlayer()
    }

    override fun initPlayer(url: String) {
        repository.initPlayer(url)
    }

    override fun releasePlayer() {
        repository.releasePlayer()
    }

    override fun play() {
        repository.play()
    }

}