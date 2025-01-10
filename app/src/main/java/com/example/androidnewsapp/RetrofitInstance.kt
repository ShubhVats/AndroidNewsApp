package com.example.androidnewsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val baseurl = "https://api.worldnewsapi.com/"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val newsApi: NewsAPI = getInstance().create(NewsAPI::class.java)
}