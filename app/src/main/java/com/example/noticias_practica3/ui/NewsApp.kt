package com.example.noticias_practica3.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noticias_practica3.R
import com.example.noticias_practica3.ui.component.NewsTopBar
import com.example.noticias_practica3.ui.viewmodel.NewsViewModel
import com.example.noticias_practica3.ui.theme.screen.NewsListScreen

@Composable
fun NewsApp(
    viewModel: NewsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NewsTopBar(
                isSearchActive = uiState.isSearchActive,
                searchText = uiState.searchText,
                onSearchToggle = { viewModel.toggleSearch() },
                onSearchTextChange = { viewModel.onSearchTextChange(it) }
            )
        }
    ) { paddingValues ->
        if (uiState.newsList.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.search_no_results),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
            }
        } else {
            NewsListScreen(
                newList = uiState.newsList,
                onNewsClick = { news ->
                    val mensaje = context.getString(R.string.log_news_click, news.title)
                    println(mensaje)
                },
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}