package com.turingalan.pokemon.ui.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel(),
    onNavigateToDetail: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {

    }
}