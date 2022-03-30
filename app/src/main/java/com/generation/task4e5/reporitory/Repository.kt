package com.generation.task4e5.reporitory

import com.generation.task4e5.api.RetrofitInstance
import com.generation.task4e5.model.Post
import com.generation.task4e5.model.Temas
import retrofit2.Response

class Repository {

    suspend fun listTemas(): Response<List<Temas>> {
        return RetrofitInstance.api.listTemas()

    }

    suspend fun addPost(post: Post): Response<Post> {

        return RetrofitInstance.api.addPost(post)

    }


    suspend fun listPost(): Response<List<Post>> {

        return RetrofitInstance.api.listPost()

    }


}