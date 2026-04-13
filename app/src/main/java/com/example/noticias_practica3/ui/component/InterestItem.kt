package com.example.noticias_practica3.ui.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.noticias_practica3.R

import com.example.noticias_practica3.data.model.InterestData

@Composable
fun InterestItem(
    interest: InterestData,
    onToggle: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Category,
                contentDescription = null,
                tint = Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = interest.name,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )

        IconButton(
            onClick = { onToggle(!interest.isSelected) },
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.red_chill),
                    shape = CircleShape
                )
                .size(32.dp)
        ) {
            Icon(
                imageVector = if (interest.isSelected) Icons.Default.Remove else Icons.Default.Add,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier.size(20.dp)
            )
        }
    }
    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp), thickness = 0.5.dp)
}