package com.example.noticias_practica3.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.noticias_practica3.R
import com.example.noticias_practica3.ui.navigation.ScreenNav

@Composable
fun NewsBottomBar(
    currentScreen: ScreenNav,
    onNavigate: (ScreenNav) -> Unit
) {
    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = currentScreen is ScreenNav.Home || currentScreen is ScreenNav.NewsDetail,
            onClick = { if (currentScreen !is ScreenNav.Home) {
                onNavigate(ScreenNav.Home)} },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                indicatorColor = colorResource(R.color.red_chill),
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Red,
                unselectedTextColor = Color.Gray,
                )
        )
        NavigationBarItem(
            selected = currentScreen is ScreenNav.Interests,
            onClick = { onNavigate(ScreenNav.Interests) },
            icon = { Icon(Icons.AutoMirrored.Filled.ListAlt, contentDescription = null) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                indicatorColor = colorResource(R.color.red_chill),
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Red,
                unselectedTextColor = Color.Gray,

                )
        )
    }
}