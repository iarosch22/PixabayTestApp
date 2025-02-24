package com.example.pixabaytestapp.domain

import com.example.pixabaytestapp.domain.models.SearchResultsEntity
import kotlinx.coroutines.flow.Flow

interface PixabayInteractor {

    fun getVideos(page: Int, perPage: Int): Flow<SearchResultsEntity>

}