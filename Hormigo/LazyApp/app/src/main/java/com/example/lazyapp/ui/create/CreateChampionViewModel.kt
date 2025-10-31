package com.example.lazyapp.ui.create

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import com.example.lazyapp.data.repository.ChampionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateChampionViewModel @Inject constructor(
    private val respository: ChampionRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<CreateUiState> = MutableStateFlow(CreateUiState.New)
    val uiState: StateFlow<CreateUiState>
        get() = _uiState.asStateFlow()
    val titleState = TextFieldState()

    fun create() {

    }
    fun canCreate() {

    }
}

sealed class CreateUiState() {
    object  New: CreateUiState()
    data class  Error(val message: String): CreateUiState()
    object  Cancelled: CreateUiState()
    object  Created: CreateUiState()
}