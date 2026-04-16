package com.example.noticias_practica3.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noticias_practica3.data.repository.NewsRepository
import com.example.noticias_practica3.ui.theme.screen.NewsListScreen
import com.example.noticias_practica3.ui.viewmodel.NewsViewModel

@Composable
fun NewsHomeScreen(
    viewModel: NewsViewModel = viewModel(),
    onNewsClick: (String) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    NewsListScreen(
        newList = uiState.newsList,
        onNewsClick = { news ->
            onNewsClick(news.id)
        },
        modifier = Modifier.fillMaxSize()
    )
}