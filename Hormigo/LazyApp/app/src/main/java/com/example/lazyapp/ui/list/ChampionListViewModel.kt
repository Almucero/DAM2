package com.example.lazyapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazyapp.data.model.Champion
import com.example.lazyapp.data.repository.ChampionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionListViewModel @Inject constructor(
    private val repository: ChampionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<ListUiState>(ListUiState.Initial)
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = ListUiState.Loading
            repository.observeAll().collect { champions ->
                _uiState.value = ListUiState.Success(champions)
            }
        }
    }
}

sealed class ListUiState {
    object Initial : ListUiState()
    object Loading : ListUiState()
    data class Success(val champions: List<Champion>) : ListUiState()
}