package com.example.pixabaytestapp.domain.models

data class VideoEntity(
    val duration: Int,
    val id: Int,
    val thumbnail: String,
    val type: String,
    val tags: String,
    val large: VideoFormat,
    val medium: VideoFormat,
    val small: VideoFormat,
    val tiny: VideoFormat
)

data class VideoFormat(
    val height: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)