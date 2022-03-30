package com.generation.task4e5.api

import com.generation.task4e5.model.Post
import com.generation.task4e5.model.Temas
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("temas")
    suspend fun listTemas(): Response<List<Temas>>

    @GET("postagens")
    suspend fun listPost(): Response<List<Post>>


    @POST("postagens")
    suspend fun addPost(
        @Body post: Post
    ): Response<Post>


}