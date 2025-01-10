package com.example.androidnewsapp

import kotlinx.serialization.Serializable

@Serializable
object HomePageScreen

@Serializable
data class NewsArticleScreen(
    val url: String?
)