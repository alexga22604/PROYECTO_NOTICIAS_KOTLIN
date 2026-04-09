package com.example.noticias_practica3.data.repository

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
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://cloudfront-us-east-1.images.arcpublishing.com/infobae/CPPGNCS225BTJLMR73XHZGIYFM.jpg"
            ),
            NewsDto(
                "2",
                "Compose Multiplatform",
                "Ya es estable...",
                "Cuerpo...",
                "11 Oct",
                "Aris",
                "Guimera",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://i.ytimg.com/vi/JsugLEM6po0/maxresdefault.jpg"
            ),
            NewsDto(
                "3",
                "Kotlin 2.1",
                "Mejoras de rendimiento...",
                "Cuerpo...",
                "10 Oct",
                "Aris",
                "Guimera",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeNt93GJrmzlQZ2aXF-HKODaM3Ufd-sdHHDQ&s"
            ),
            NewsDto(
                "4",
                "Material Design 4?",
                "Rumores...",
                "Cuerpo...",
                "09 Oct",
                "Aris",
                "Guimera",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://ichef.bbci.co.uk/ace/ws/640/cpsprodpb/102B7/production/_108613266_22d51f56-2a9f-4966-a0c4-d3c91687acfd.jpg.webp"
            ),
            NewsDto(
                "5",
                "Compose Multiplatform",
                "Ya es estable...",
                "Cuerpo...",
                "11 Oct",
                "Aris",
                "Guimera",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://ichef.bbci.co.uk/ace/ws/640/amz/worldservice/live/assets/images/2015/08/10/150810105302_android_624x351_getty.jpg.webp"
            ),
            NewsDto(
                "6",
                "Kotlin 2.1",
                "Mejoras de rendimiento...",
                "Cuerpo...",
                "10 Oct",
                "Aris",
                "Guimera",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://dplnews.com/wp-content/uploads/2021/07/dplnews_android12_vr140721.jpeg"
            ),
            NewsDto(
                "7",
                "Material Design 4?",
                "Rumores...",
                "Cuerpo...",
                "09 Oct",
                "Aris",
                "Guimera",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://imagenes.20minutos.es/files/image_1920_1080/files/fp/uploads/imagenes/2022/05/05/android-malware.r_d.566-57.jpeg"
            )
        )
    }

    fun getNews(): List<NewsBo> {
        return getNewsFromDataSource().map { it.toBo() }
    }
}