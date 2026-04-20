package com.example.noticias_practica3.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.noticias_practica3.data.model.NewsBo
import com.example.noticias_practica3.data.repository.InterestsRepository
import com.example.noticias_practica3.data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: NewsRepository,
    private val interestsRepository: InterestsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(NewUiState())
    val uiState: StateFlow<NewUiState> = _uiState.asStateFlow()
    private var allNews: List<NewsBo> = emptyList()

    init {
        fetchNews()
        observeInterests()
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
                searchText = if (!isNowActive) "" else it.searchText
            )
        }
        applyFilter()
    }
    fun selectNewsById(id: String) {
        val news = allNews.find { it.id == id }
        _uiState.update { it.copy(selectedNews = news) }
    }


    private fun observeInterests() {
        viewModelScope.launch {
            interestsRepository.selectedInterestsFlow.collect { uptadeInterests ->
                _uiState.update { it.copy(selectedInterests = uptadeInterests) }
                applyFilter()
            }
        }
    }

    private fun applyFilter() {
        val state = _uiState.value
        val query = state.searchText.lowercase()
        val selectedInterests = state.selectedInterests
        val filtered = allNews.filter { news ->
            val matchesQuery = query.isEmpty() ||
                    news.title.lowercase().contains(query) ||
                    news.description.lowercase().contains(query) ||
                    news.author.fullName.lowercase().contains(query)
            val matchesInterests = if (selectedInterests.isEmpty()) {
                true
            } else {
                selectedInterests.any { interest ->
                    news.title.contains(interest, ignoreCase = true) ||
                            news.description.contains(interest, ignoreCase = true)
                }
            }

            matchesQuery && matchesInterests
        }

        _uiState.update { it.copy(newsList = filtered) }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                return NewsViewModel(
                    newsRepository = NewsRepository,
                    interestsRepository = InterestsRepository(application.applicationContext)
                ) as T
            }
        }
    }
}