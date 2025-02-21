package com.example.pixabaytestapp.presentation.viewmodels

import com.example.pixabaytestapp.domain.models.VideoEntity
import com.example.pixabaytestapp.utils.ErrorType

sealed  interface VideosState {

    data object Loading: VideosState

    data class Error(val errorType: ErrorType): VideosState

    data class Content(val videos: List<VideoEntity>): VideosState

}