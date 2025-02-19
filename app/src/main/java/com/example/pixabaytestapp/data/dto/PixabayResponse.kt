package com.example.pixabaytestapp.data.dto

data class PixabayResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
): Response()

data class Hit(
    val duration: Int,
    val id: Int,
    val pageURL: String,
    val videos: Videos,
)

data class Videos(
    val large: Large,
    val medium: Medium,
    val small: Small,
    val tiny: Tiny
)

data class Large(
    val height: Int,
    val size: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)

data class Medium(
    val height: Int,
    val size: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)

data class Small(
    val height: Int,
    val size: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)

data class Tiny(
    val height: Int,
    val size: Int,
    val thumbnail: String,
    val url: String,
    val width: Int
)