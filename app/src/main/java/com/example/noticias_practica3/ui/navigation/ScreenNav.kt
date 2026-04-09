package com.example.noticias_practica3.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenNav: NavKey{
    @Serializable

    object Home : ScreenNav()
    @Serializable

    object Interests : ScreenNav()
    @Serializable

    data class NewsDetail(val newsId: String) : ScreenNav()

}