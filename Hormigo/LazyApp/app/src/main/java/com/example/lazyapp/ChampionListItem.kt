package com.example.lazyapp

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChampionListItem(
    image: Int,
    title: String,
    description: String
) {
    val imageModifier = Modifier.size(128.dp).padding(8.dp).clip(CircleShape)
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = imageModifier,
            painter = painterResource(image),
            contentDescription = "Champion image",
            contentScale = ContentScale.Crop
        )
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}