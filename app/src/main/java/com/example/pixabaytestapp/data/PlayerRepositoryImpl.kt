package com.example.pixabaytestapp.data

import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.pixabaytestapp.domain.PlayerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepositoryImpl @Inject constructor(private val player: ExoPlayer): PlayerRepository {

    override fun getPlayer(): ExoPlayer = player

    override fun initPlayer(url: String) {
        val mediaItem = MediaItem.fromUri(url)
        player.setMediaItem(mediaItem)
        player.prepare()
    }

    override fun releasePlayer() {
        player.release()
    }

    override fun play() {
        player.play()
    }

}