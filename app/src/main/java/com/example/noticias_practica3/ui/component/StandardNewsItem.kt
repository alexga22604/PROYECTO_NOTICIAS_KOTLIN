package com.example.noticias_practica3.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.noticias_practica3.data.model.NewsBo

@Composable
fun StandardNewsItem(news: NewsBo, onClick: (NewsBo) -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick(news) }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = news.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = news.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${news.author.fullName} - ${news.date}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 0.5.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )
    }
}

