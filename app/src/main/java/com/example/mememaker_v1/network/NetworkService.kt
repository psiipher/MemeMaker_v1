package com.example.mememaker_v1.network

import com.example.mememaker_v1.MemeResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {

    @GET("{page}")
    suspend fun getMemes(@Path("page") page: Int = 1): MemeResponse

    companion object {
        private const val BASE_URL = "http://alpha-meme-maker.herokuapp.com/"

        fun getService(): NetworkService {
            val client = OkHttpClient.Builder()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }
    }
}