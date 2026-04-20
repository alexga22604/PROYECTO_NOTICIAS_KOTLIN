package com.example.noticias_practica3.ui.viewmodel

import com.example.noticias_practica3.data.model.NewsBo

const val DEFAULT_STRING_VALUE = ""

data class NewUiState(
    val newsList: List<NewsBo> = emptyList(),
    val searchText: String = DEFAULT_STRING_VALUE,
    val isSearchActive: Boolean = false,
    val selectedInterests: Set<String> = emptySet(),
    val selectedNews: NewsBo? = null
)