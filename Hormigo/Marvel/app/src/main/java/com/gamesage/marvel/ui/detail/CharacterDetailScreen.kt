package com.gamesage.marvel.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage

@Composable
fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    CharacterDetailScreen(
        modifier = modifier,
        uiState = uiState,
        onNameChange = viewModel::onNameChange,
        onOriginNameChange = viewModel::onOriginNameChange,
        onUpdateClick = viewModel::updateCharacter
    )
}

@Composable
fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    uiState: DetailUiState,
    onNameChange: (String) -> Unit,
    onOriginNameChange: (String) -> Unit,
    onUpdateClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.image != null) {
            AsyncImage(
                model = uiState.image,
                contentScale = ContentScale.Crop,
                contentDescription = uiState.name
            )
        }
        TextField(
            value = uiState.name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
        TextField(
            value = uiState.originName ?: "",
            onValueChange = onOriginNameChange,
            label = { Text("Origin Name") }
        )
        Button(onClick = onUpdateClick) {
            Text("Update Character")
        }
    }
}
