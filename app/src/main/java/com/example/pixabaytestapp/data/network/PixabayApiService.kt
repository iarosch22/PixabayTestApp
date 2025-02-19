package com.example.pixabaytestapp.data.network

import com.example.pixabaytestapp.data.dto.PixabayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApiService {

    @GET("/api/videos/")
    suspend fun getVideos(
        @Query("key") key: String = "48935024-a91641626c0ca8e95d52b8637",
        @Query("order") order: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): PixabayResponse

}