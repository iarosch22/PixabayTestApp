package com.example.pixabaytestapp.presentation

import com.example.pixabaytestapp.domain.models.VideoEntity

fun interface OnVideoClickListener {

    fun onVideoClick(video: VideoEntity)

}