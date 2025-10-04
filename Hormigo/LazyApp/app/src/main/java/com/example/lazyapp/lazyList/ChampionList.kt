package com.example.lazyapp.lazyList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lazyapp.data.champions

@Composable
fun Screen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(vertical = 8.dp, horizontal = 10.dp)
    ) {
        items(items = champions) { champion ->
            ChampionListItem(
                imageUrl = champion.imageUrl,
                name = stringResource(id = champion.name),
                title = stringResource(id = champion.title),
                description = stringResource(id = champion.description)
            )
        }
    }
}
