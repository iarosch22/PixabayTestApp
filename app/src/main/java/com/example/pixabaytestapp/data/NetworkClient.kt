package com.example.pixabaytestapp.data

import com.example.pixabaytestapp.data.dto.BaseRequest
import com.example.pixabaytestapp.data.dto.Response

interface NetworkClient {

    suspend fun doRequest(dto: BaseRequest): Response

}