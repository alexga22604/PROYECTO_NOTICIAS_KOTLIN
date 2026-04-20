package com.example.noticias_practica3.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noticias_practica3.data.model.NewsBo
import com.example.noticias_practica3.data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsDetailViewModel : ViewModel() {
    private val _news = MutableStateFlow<NewsBo?>(null)
    val news: StateFlow<NewsBo?> = _news.asStateFlow()
    fun getNewsById(id: String) {
        viewModelScope.launch {
            val allNews = NewsRepository.getNews()
            val selected = allNews.find { it.id == id }
            _news.value = selected
        }
    }
}