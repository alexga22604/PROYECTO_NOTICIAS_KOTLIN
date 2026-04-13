package com.example.noticias_practica3.ui.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.noticias_practica3.R
import com.example.noticias_practica3.data.model.InterestData
import com.example.noticias_practica3.data.repository.InterestsRepository
import com.example.noticias_practica3.ui.component.InterestItem
import kotlinx.coroutines.launch

@Composable
fun InterestNewsScreen(context: Context = LocalContext.current) {
    val repository = remember { InterestsRepository(context) }
    val scope = rememberCoroutineScope()
    val selectedInterests by repository.selectedInterestsFlow.collectAsState(initial = emptySet())
    val availableInterests = InterestsRepository.InterestsDataSource.availableInterests

    Column(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .size(40.dp),
            contentAlignment = Alignment.CenterStart
        )
        {
            Box(
                modifier = Modifier
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Terminal,
                    tint = Color.Red,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                text = stringResource(R.string.nav_interests),
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth().padding(top = 8.dp)
        ) {
            items(availableInterests) { name ->
                val isSelected = selectedInterests.contains(name)
                InterestItem(
                    interest = InterestData(name, isSelected),
                    onToggle = { newValue ->
                        scope.launch {
                            repository.toggleInterest(name, newValue)
                        }
                    })
            }
        }
    }
}
