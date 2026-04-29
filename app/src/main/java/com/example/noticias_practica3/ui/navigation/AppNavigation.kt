package com.example.noticias_practica3.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.noticias_practica3.ui.screen.NewsDetailScreen
import com.example.noticias_practica3.ui.screen.NewsHomeScreen

@Composable
fun AppNavigation(
    paddingValues: PaddingValues,
) {
    val backStack = rememberNavBackStack(ScreenNav.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        modifier = Modifier.padding(paddingValues),
        entryProvider = entryProvider {
            entry<ScreenNav.Home> {
                NewsHomeScreen(
                    onNewsClick = { id ->
                        backStack.add(ScreenNav.NewsDetail(id))
                    }
                )
            }

            entry<ScreenNav.NewsDetail> { key ->
                NewsDetailScreen(
                    newsId = key.newsId,
                    onBack = { backStack.removeLastOrNull() },
                    viewModel  = viewModel()
                )
            }
        }
    )
}