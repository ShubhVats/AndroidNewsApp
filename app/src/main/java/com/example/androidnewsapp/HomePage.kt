package com.example.androidnewsapp

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.androidnewsapp.models.News
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun HomePage(newsViewModel: NewsViewModel, navController: NavHostController) {

    val articles by newsViewModel.articles.observeAsState(emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        CategoriesBar(newsViewModel)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(articles) { article ->
                ArticleItem(
                    article,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun CategoriesBar(newsViewModel: NewsViewModel) {
    val categoriesList = listOf(
        "politics",
        "sports",
        "business",
        "technology",
        "entertainment",
        "health",
        "science",
        "lifestyle",
        "travel",
        "culture",
        "education",
        "environment"
    )

    var isSearching by remember {
        mutableStateOf(false)
    }

    var searchQuery by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (isSearching) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .height(48.dp)
                    .border(1.dp, Color.Gray, CircleShape)
                    .clip(CircleShape),
                value = searchQuery,
                onValueChange = { searchQuery = it },
                trailingIcon = {
                    IconButton(onClick = {
                        isSearching = false
                        if(searchQuery.isNotEmpty()){
                            GlobalScope.launch {
                                newsViewModel.getData(category = searchQuery.lowercase())
                            }
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "search Image"
                        )
                    }
                })
        } else {
            IconButton(onClick = { isSearching = true }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search Image")
            }
        }

        categoriesList.forEach { category ->
            Button(
                onClick = {
                    GlobalScope.launch {
                        newsViewModel.getData(category = category.lowercase())
                    }
                },
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = category.uppercase())
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ArticleItem(article: News,navController: NavHostController) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        , onClick = {
            navController.navigate(NewsArticleScreen(article.url))
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                model = article.image ?: "https://thumbs.dreamstime.com/b/web-324671699.jpg",
                contentDescription = article.title.toString(),
                modifier = Modifier
                    .size(80.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp)
            ) {
                article?.title?.let { Text(text = it, fontWeight = FontWeight.Bold, maxLines = 3) }
                article?.author?.let { Text(text = it, maxLines = 1, fontSize = 14.sp) }
            }
        }
    }
}