package com.example.noticias_practica3.ui.model

import androidx.lifecycle.ViewModel
import com.example.noticias_practica3.data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class NewsViewModel : ViewModel() {

    private val newsRepository = NewsRepository
    private val _uiState = MutableStateFlow(NewUiState())
    val uiState: StateFlow<NewUiState> = _uiState.asStateFlow()

    init {
        val allNews = newsRepository.getNews()
        _uiState.update { it.copy(newsList = allNews) }
    }

    fun onSearchTextChange(newText: String) {
        _uiState.update { it.copy(searchText = newText) }
        applyFilter()
    }

    fun toggleSearch() {
        _uiState.update {
            val isNowActive = !it.isSearchActive
            it.copy(
                isSearchActive = isNowActive,
                searchText = if (!isNowActive) DEFAULT_STRING_VALUE else it.searchText
            )
        }
        applyFilter()
    }

    private fun applyFilter() {
        val allNews = newsRepository.getNews()
        val query = _uiState.value.searchText.lowercase()

        if (query.isEmpty()) {
            _uiState.update { it.copy(newsList = allNews) }
        } else {
            val filtered = allNews.filter { news ->
                news.title.lowercase().contains(query) ||
                        news.description.lowercase().contains(query) ||
                        news.author.name.lowercase().contains(query)
            }
            _uiState.update { it.copy(newsList = filtered) }
        }
    }
}