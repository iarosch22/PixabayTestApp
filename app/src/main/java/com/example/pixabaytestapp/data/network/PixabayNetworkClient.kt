package com.example.pixabaytestapp.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.pixabaytestapp.data.NetworkClient
import com.example.pixabaytestapp.data.dto.BaseRequest
import com.example.pixabaytestapp.data.dto.PixabayRequest
import com.example.pixabaytestapp.data.dto.Response
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PixabayNetworkClient @Inject constructor(
    @ApplicationContext private val context: Context
): NetworkClient {

    private val pixabayBaseUrl = "https://pixabay.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(pixabayBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pixabayApiService = retrofit.create(PixabayApiService::class.java)

    override suspend fun doRequest(dto: BaseRequest): Response {
        if (!isConnected()) {
            return Response().apply { resultCode = -1 }
        }

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

    private fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
            }
        }

        return false
    }

}