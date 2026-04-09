package com.example.noticias_practica3.ui.theme.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.noticias_practica3.R
import com.example.noticias_practica3.data.model.NewsBo
import com.example.noticias_practica3.ui.theme.component.FeaturedNewsItem
import com.example.noticias_practica3.ui.theme.component.StandardNewsItem

@Composable
fun NewsListScreen(
    newList: List<NewsBo>,
    onNewsClick: (NewsBo) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                text = stringResource(id = R.string.top_tittle_main),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        }

        itemsIndexed(newList) { index, news ->
            if (index == 0) {
                FeaturedNewsItem(news, onNewsClick)
            } else {
                StandardNewsItem(news, onNewsClick)
            }
        }
    }
}