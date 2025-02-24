package com.example.pixabaytestapp.domain.impl

import com.example.pixabaytestapp.domain.PixabayInteractor
import com.example.pixabaytestapp.domain.PixabayRepository
import com.example.pixabaytestapp.domain.models.SearchResultsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PixabayInteractorImpl @Inject constructor(private val repository: PixabayRepository): PixabayInteractor {

    override fun getVideos(page: Int, perPage: Int): Flow<SearchResultsEntity> {
        return repository.getVideos(page, perPage)
    }

}