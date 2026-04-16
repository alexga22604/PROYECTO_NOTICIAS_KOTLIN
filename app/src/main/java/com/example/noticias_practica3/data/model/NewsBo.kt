package com.example.noticias_practica3.data.model

data class NewsBo(
    val id: String,
    val title: String,
    val description: String,
    val content: String,
    val date: String,
    val author: AuthorBo,
    val blog: BlogBo,
    val imageRes: Int,
    val interests: List<InterestBo>
)