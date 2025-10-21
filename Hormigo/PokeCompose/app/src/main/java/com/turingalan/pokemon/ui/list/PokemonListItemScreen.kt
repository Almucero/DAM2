package com.turingalan.pokemon.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp

@Composable
fun PokemonListItemScreen(
    id: Long,
    name: String,
    spriteId: Int,
    onClickItem: (Long) -> Unit
) {
    HorizontalDivider(
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 10.dp)
    )
    Row(
        modifier = Modifier.fillMaxWidth().clickable(true, onClick = {
            onClickItem(id)
        }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(spriteId),
            modifier = Modifier.size(128.dp).padding(8.dp).clip(CircleShape),
            contentDescription = "Pokemon image",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}