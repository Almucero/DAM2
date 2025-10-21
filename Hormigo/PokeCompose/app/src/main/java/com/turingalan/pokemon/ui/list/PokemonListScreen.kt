package com.turingalan.pokemon.ui.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel(),
    onNavigateToDetail: (Long) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    LazyColumn(
        modifier = modifier
    ) {
        items(uiState.list, key = { it.id }) { pokemon ->
            PokemonListItemScreen(
                id = pokemon.id,
                name = pokemon.name,
                spriteId = pokemon.spriteId,
                onClickItem = onNavigateToDetail,
            )
        }
    }
}