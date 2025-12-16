package com.gamesage.marvel.ui.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamesage.marvel.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.gamesage.marvel.data.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: CharacterRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<ListUiState> =
        MutableStateFlow(value = ListUiState.Initial)
    val uiState: StateFlow<ListUiState>
        get() = _uiState.asStateFlow()
    init {
        viewModelScope.launch {
            _uiState.value = ListUiState.Loading
            repository.observe().collect { result ->
                if (result.isSuccess) {
                    val successResponse = ListUiState.Success(result.getOrNull()!!.asListUiState())
                    _uiState.value = successResponse
                } else {
                    _uiState.value = ListUiState.Error
                }
            }
        }
    }

    fun onDeleteCharacter(id: Long) {
        viewModelScope.launch {
            val character = repository.readOne(id).getOrNull()
            if (character!=null) {
                repository.deleteOne(character)
            }
        }
    }

    fun onDeleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    fun onSearch(text: String) {
        viewModelScope.launch {
            repository.deleteAll()
            val character = repository.readAll(text).getOrNull()
            if (character!=null) {
                repository.addAll(character)
            }
        }
    }
}

sealed class ListUiState {
    object Initial: ListUiState()
    object Loading: ListUiState()
    object Error: ListUiState()
    data class Success(
        val characters: List<ListItemUiState>
    ): ListUiState()
}

data class ListItemUiState(
    val id: Long,
    val name: String,
    val image: String
)

fun Character.asListItemUiState(): ListItemUiState {
    return ListItemUiState(
        id = this.id,
        name = this.name.replaceFirstChar { it.uppercase() },
        image = this.image
    )
}

fun List<Character>.asListUiState(): List<ListItemUiState> = this.map(Character::asListItemUiState)