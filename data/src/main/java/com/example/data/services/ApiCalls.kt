package com.example.data.services

import com.example.data.models.ModelAllMealsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {
    @GET("search.php?")
    suspend fun getMealByName(
        @Query("f") name: Char
    ): ModelAllMealsDTO

}