package com.example.androidnewsapp.models

data class HeadlineModel(
    val available: Int?,
    val news: List<News>?,
    val number: Int?,
    val offset: Int?
)