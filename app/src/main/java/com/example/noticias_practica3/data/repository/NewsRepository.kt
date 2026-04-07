package com.example.noticias_practica3.data.repository

import com.example.noticias_practica3.data.AuthorBo
import com.example.noticias_practica3.data.BlogBo
import com.example.noticias_practica3.data.InterestBo
import com.example.noticias_practica3.data.NewsBo

object NewsRepository {
    fun getNews(): List<NewsBo> {
        val author = AuthorBo("1", "Aris", "Guimera", 0)
        val blog = BlogBo("1", "Android Blog", "https://android.com")
        val interests = listOf(InterestBo("1", "Kotlin"), InterestBo("2", "Compose"))

        return listOf(
            NewsBo(
                "1",
                "Novedades de Android 16",
                "Descubre lo nuevo...",
                "Cuerpo largo...",
                "12 Oct",
                author,
                blog,
                0,
                interests
            ),
            NewsBo(
                "2",
                "Compose Multiplatform",
                "Ya es estable...",
                "Cuerpo largo...",
                "11 Oct",
                author,
                blog,
                0,
                interests
            ),
            NewsBo(
                "3",
                "Kotlin 2.1",
                "Mejoras de rendimiento...",
                "Cuerpo largo...",
                "10 Oct",
                author,
                blog,
                0,
                interests
            ),
            NewsBo(
                "4",
                "Material Design 4?",
                "Rumores sobre el futuro...",
                "Cuerpo largo...",
                "09 Oct",
                author,
                blog,
                0,
                interests
            )
        )
    }
}
