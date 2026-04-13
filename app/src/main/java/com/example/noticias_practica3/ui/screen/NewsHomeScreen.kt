package com.example.noticias_practica3.ui.screen

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.noticias_practica3.data.repository.InterestsRepository
import com.example.noticias_practica3.data.repository.NewsRepository
import com.example.noticias_practica3.ui.theme.screen.NewsListScreen

@Composable
fun NewsHomeScreen(
    context: Context = LocalContext.current,
    searchText: String = "",
    onNewsClick: (String) -> Unit
) {
    val repository = remember { InterestsRepository(context) }
    val selectedInterests by repository.selectedInterestsFlow.collectAsState(initial = emptySet())
    val allNews = remember { NewsRepository.getNews() }
    val filteredNews = remember(searchText, selectedInterests) {
        allNews.filter { news ->
            val matchesSearch = news.title.contains(searchText, ignoreCase = true) ||
                    news.author.name.contains(searchText, ignoreCase = true)
            val matchesInterest = if (selectedInterests.isEmpty()) {
                true
            } else {
                selectedInterests.any { interestName ->
                    news.title.contains(interestName, ignoreCase = true)
                }
            }
            matchesSearch && matchesInterest
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