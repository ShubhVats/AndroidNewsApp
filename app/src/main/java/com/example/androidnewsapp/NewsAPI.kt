package com.example.androidnewsapp

import com.example.androidnewsapp.models.HeadlineModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("search-news?api-key=5b63041691c447089a739dea6af3e97b&language=en")
//    @GET("https://newsapi.org/v2/top-headlines")
    suspend fun getHeadLines(
        @Query("text") categories: String
    ): Response<HeadlineModel>
}