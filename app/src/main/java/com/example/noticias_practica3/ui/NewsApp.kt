package com.example.noticias_practica3.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.noticias_practica3.data.repository.NewsRepository
import com.example.noticias_practica3.ui.component.NewsTopBar
import com.example.noticias_practica3.ui.theme.screen.NewsListScreen

@Composable
fun NewsApp() {
    val newslist = NewsRepository.getNews()
    var isSearchActive by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    val filteredNews = newslist.filter { news ->
        val query = searchText.lowercase()
        news.title.lowercase().contains(query) ||
                news.description.lowercase().contains(query) ||
                news.author.fullName.lowercase().contains(query)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        {
            NewsTopBar(
                isSearchActive = isSearchActive,
                searchText = searchText,
                onSearchToggle = {
                    isSearchActive = !isSearchActive
                    if (!isSearchActive) searchText = ""
                },
                onSearchTextChange = { searchText = it }
            )
        }
    ) { paddingValues ->
        if (filteredNews.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No hay coincidencias",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
            }
        }else
        {
            NewsListScreen(
                newList = filteredNews,
                onNewsClick = { news ->
                    println("Ha pulsado en: --")
                },
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}