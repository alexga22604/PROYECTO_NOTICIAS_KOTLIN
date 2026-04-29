package com.example.noticias_practica3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.noticias_practica3.ui.NewsApp
import com.example.noticias_practica3.ui.navigation.ScreenNav
import com.example.noticias_practica3.ui.screen.NewsDetailScreen
import com.example.noticias_practica3.ui.theme.Noticiaspractica3Theme

class NavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Noticiaspractica3Theme {
                val backStack = rememberNavBackStack(ScreenNav.Home) as NavBackStack<ScreenNav>
                val currentScreen = backStack.last()

                AnimatedContent(
                    targetState = currentScreen,
                    transitionSpec = {
                        slideInHorizontally { it } + fadeIn() togetherWith
                                slideOutHorizontally { -it } + fadeOut()
                    },
                    label = stringResource(R.string.screen_transition)
                ) { targetScreen ->
                    when (targetScreen) {
                        is ScreenNav.Home -> {
                            NewsApp(backStack = backStack)
                        }

                        is ScreenNav.NewsDetail -> {
                            NewsDetailScreen(
                                newsId = targetScreen.newsId,
                                onBack = {
                                    backStack.remove(currentScreen)
                                }
                            )
                        }

                        is ScreenNav.Interests -> {
                            //TODO
                        }
                    }
                }
            }
        }
    }
}
