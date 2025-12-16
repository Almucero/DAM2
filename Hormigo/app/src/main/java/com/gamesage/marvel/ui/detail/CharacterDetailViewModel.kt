package com.gamesage.marvel.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gamesage.marvel.data.model.Character
import com.gamesage.marvel.data.repository.CharacterRepository
import com.gamesage.marvel.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val characterRepository: CharacterRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<DetailUiState> =
        MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val route = savedStateHandle.toRoute<Route.Detail>()
            val pokemonId = route.id
            val pokemon = characterRepository.readOne(pokemonId)
            pokemon.let {
                _uiState.value = pokemon.getOrNull()!!.toDetailUiState()
            }
        }
    }
}

data class DetailUiState(
    val name: String = "",
    val image: String? = ""
)

fun Character.toDetailUiState(): DetailUiState = DetailUiState(
    name = this.name,
    image = this.image
)