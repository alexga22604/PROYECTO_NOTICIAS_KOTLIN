package com.example.noticias_practica3.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noticias_practica3.data.model.NewsBo
import com.example.noticias_practica3.data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val newsRepository = NewsRepository
    private var allNews: List<NewsBo> = emptyList()
    private val _uiState = MutableStateFlow(NewUiState())
    val uiState: StateFlow<NewUiState> = _uiState.asStateFlow()

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            val news = NewsRepository.getNews()
            allNews = news
            _uiState.update { it.copy(newsList = news) }
        }
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