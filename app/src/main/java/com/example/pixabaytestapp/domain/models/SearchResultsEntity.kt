package com.example.pixabaytestapp.domain.models

import com.example.pixabaytestapp.utils.ErrorType

data class SearchResultsEntity(
    val videos: List<VideoEntity>? = null,
    val errorType: ErrorType? = null
)
