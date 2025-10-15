package com.example.lazyapp.ui.lazyList

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lazyapp.data.LocalizedString
import com.example.lazyapp.data.champions

@Composable
fun ChampionListScreen(
    modifier: Modifier = Modifier,
    onNavigateToDetail: (Int) -> Unit
) {
    @Composable
    fun lsText(ls: LocalizedString): String = when (ls) {
        is LocalizedString.Res -> stringResource(ls.resId)
        is LocalizedString.Plain -> ls.text
    }

    LazyColumn(
        modifier = modifier.padding(bottom = 73.dp)
    ) {
        items(champions, key = { it.id }) { champion ->
            ChampionListItemScreen(
                id = champion.id,
                imageUrl = champion.imageUrl,
                name = lsText(champion.name),
                title = lsText(champion.title),
                description = lsText(champion.description),
                onClickItem = onNavigateToDetail
            )
        }
    }
}
