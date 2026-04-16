package com.example.noticias_practica3.data

data class NewsDto(
    val id: String?,
    val title: String?,
    val subtitle: String?,
    val body: String?,
    val date: String?,
    val authorFirstName: String?,
    val authorLastName: String?,
    val authorImage: Int?,
    val imageRes: Int?
)