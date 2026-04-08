package com.example.noticias_practica3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.noticias_practica3.ui.NewsApp
import com.example.noticias_practica3.ui.theme.Noticiaspractica3Theme

class NavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Noticiaspractica3Theme {
                NewsApp()
            }
        }
    }
}
