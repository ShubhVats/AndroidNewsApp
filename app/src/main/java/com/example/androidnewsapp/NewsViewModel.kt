package com.example.androidnewsapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidnewsapp.models.News
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.NewsApiClient.ArticlesResponseCallback
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse
import kotlinx.coroutines.launch


class NewsViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<News>>()
    val articles: LiveData<List<News>> = _articles
    var newsApi: NewsAPI? = null

    init {
        viewModelScope.launch {
            newsApi = RetrofitInstance.newsApi
            getData(category = "politics")
        }
    }

    suspend fun getData(category: String) {
        try {
            val response = newsApi?.getHeadLines(categories = category)
            if (response?.isSuccessful == true) {
                response.body()?.news?.let {
                    _articles.postValue(it)
                }
            } else {
                Log.i("TAG", "getData:errr")
            }
        } catch (e: Exception) {
            Log.i("TAG", "getData:" + e.toString())
        }
    }
}


