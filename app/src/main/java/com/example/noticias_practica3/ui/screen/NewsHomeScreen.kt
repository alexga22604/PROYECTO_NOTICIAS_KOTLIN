package com.example.noticias_practica3.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.noticias_practica3.data.repository.NewsRepository
import com.example.noticias_practica3.ui.theme.screen.NewsListScreen

@Composable
fun NewsHomeScreen(
    searchText: String = "",
    onNewsClick: (String) -> Unit
) {
    val allNews = remember { NewsRepository.getNews() }
    val filteredNews = remember(searchText) {
        allNews.filter {
            it.title.contains(searchText, ignoreCase = true) ||
                    it.author.name.contains(searchText, ignoreCase = true)
        }
    }

    NewsListScreen(
        newList = filteredNews,
        onNewsClick = { news ->
            onNewsClick(news.id)
        },
        modifier = Modifier.fillMaxSize()
    )
}