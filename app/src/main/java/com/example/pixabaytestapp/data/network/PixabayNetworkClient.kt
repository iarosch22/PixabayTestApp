package com.example.pixabaytestapp.data.network

import com.example.pixabaytestapp.data.NetworkClient
import com.example.pixabaytestapp.data.dto.BaseRequest
import com.example.pixabaytestapp.data.dto.PixabayRequest
import com.example.pixabaytestapp.data.dto.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PixabayNetworkClient: NetworkClient {

    private val pixabayBaseUrl = "https://pixabay.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(pixabayBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pixabayApiService = retrofit.create(PixabayApiService::class.java)

    override suspend fun doRequest(dto: BaseRequest): Response {
        return try {
            val response = when(dto) {
                is PixabayRequest -> pixabayApiService.getVideos(page = dto.page, perPage =  dto.perPage)
                else -> {
                    return Response().apply { resultCode = 400 }
                }
            }

            response.apply { resultCode = 200 }
        } catch (e: Throwable) {
            Response().apply { resultCode = 500 }
        }
    }

}