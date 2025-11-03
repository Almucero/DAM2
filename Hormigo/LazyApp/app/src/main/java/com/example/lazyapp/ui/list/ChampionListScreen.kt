package com.example.lazyapp.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.lazyapp.data.model.LocalizedString

@Composable
fun lsText(ls: LocalizedString): String = when (ls) {
    is LocalizedString.Res -> stringResource(ls.resId)
    is LocalizedString.Plain -> ls.text
}

@Composable
fun ChampionListScreen(
    modifier: Modifier = Modifier,
    viewModel: ChampionListViewModel = hiltViewModel(),
    onNavigateToDetail: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is ListUiState.Initial -> {
            TODO()
        }
        is ListUiState.Loading -> {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        }
        is ListUiState.Success -> {
            LazyColumn(
                modifier = modifier.padding(bottom = 73.dp)
            ) {
                items((uiState as ListUiState.Success).champions, key = { it.id }) { champion ->
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
    }
}