package com.example.noticias_practica3.data.repository

import com.example.noticias_practica3.R
import com.example.noticias_practica3.data.NewsDto
import com.example.noticias_practica3.data.mapper.toBo
import com.example.noticias_practica3.data.model.NewsBo

object NewsRepository {
    private fun getNewsFromDataSource(): List<NewsDto> {
        return listOf(
            NewsDto(
                "1",
                "Novedades de Android 16",
                "Descubre lo nuevo...",
                "Cuerpo...",
                "12 Oct",
                "Aris",
                "Guimera",
                R.drawable.img_news5,
                R.drawable.img_news1
            ),
            NewsDto(
                "2",
                "Compose Multiplatform",
                "Ya es estable...",
                "Cuerpo...",
                "11 Oct",
                "Aris",
                "Guimera",
                R.drawable.img_news5,
                R.drawable.img_news2
            ),
            NewsDto(
                "3",
                "Kotlin 2.1",
                "Mejoras de rendimiento...",
                "Cuerpo...",
                "10 Oct",
                "Aris",
                "Guimera",
                R.drawable.img_news5,
                R.drawable.img_news3
            ),
            NewsDto(
                "4",
                "Material Design 4?",
                "Rumores...",
                "Cuerpo...",
                "09 Oct",
                "Aris",
                "Guimera",
                R.drawable.img_news5,
                R.drawable.img_news4
            )
        )
    }

    fun getNews(): List<NewsBo> {
        return getNewsFromDataSource().map { it.toBo() }
    }
}