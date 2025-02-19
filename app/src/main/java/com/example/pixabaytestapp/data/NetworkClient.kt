package com.example.pixabaytestapp.data

import com.example.pixabaytestapp.data.dto.PixabayResponse
import retrofit2.Response

interface NetworkClient<T> {

    suspend fun doRequest(dto: T): Response<PixabayResponse>

}