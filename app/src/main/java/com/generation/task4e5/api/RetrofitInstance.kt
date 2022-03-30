package com.generation.task4e5.api

import com.generation.task4e5.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)

    }
}