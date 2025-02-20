package com.example.pixabaytestapp.domain.impl

import com.example.pixabaytestapp.domain.PixabayInteractor
import com.example.pixabaytestapp.domain.PixabayRepository
import com.example.pixabaytestapp.domain.models.SearchResultsEntity
import kotlinx.coroutines.flow.Flow

class PixabayInteractorImpl(private val repository: PixabayRepository): PixabayInteractor {

    override fun getVideos(page: Int, perPage: Int): Flow<SearchResultsEntity> {
        return repository.getVideos(page, perPage)
    }

}