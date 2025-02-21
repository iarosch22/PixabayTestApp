package com.example.pixabaytestapp.data.network

import com.example.pixabaytestapp.data.NetworkClient
import com.example.pixabaytestapp.data.converters.VideoResponseConverter
import com.example.pixabaytestapp.data.dto.PixabayRequest
import com.example.pixabaytestapp.data.dto.PixabayResponse
import com.example.pixabaytestapp.domain.PixabayRepository
import com.example.pixabaytestapp.domain.models.SearchResultsEntity
import com.example.pixabaytestapp.utils.ErrorType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PixabayRepositoryImpl @Inject constructor(
    private val networkClient: NetworkClient,
    private val videoResponseConverter: VideoResponseConverter
): PixabayRepository {

    override fun getVideos(page: Int, perPage: Int): Flow<SearchResultsEntity> = flow {
        val response = networkClient.doRequest(PixabayRequest(page, perPage))

        when(response.resultCode) {
            -1 -> emit(SearchResultsEntity(errorType = ErrorType.NETWORK_ERROR))
            200 -> emit(SearchResultsEntity(videos = videoResponseConverter.convert(response as PixabayResponse)))
            400 -> emit(SearchResultsEntity(errorType = ErrorType.REQUEST_ERROR))
            500 -> emit(SearchResultsEntity(errorType = ErrorType.UNKNOWN_ERROR))
        }
    }

}