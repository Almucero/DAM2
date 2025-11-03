package com.example.lazyapp.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.lazyapp.data.model.Ability
import com.example.lazyapp.data.model.Champion
import com.example.lazyapp.data.model.LocalizedString
import com.example.lazyapp.data.model.Stats
import com.example.lazyapp.data.repository.ChampionRepository
import com.example.lazyapp.ui.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ChampionRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<DetailUiState> = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState>
        get() = _uiState.asStateFlow()

    private var championId: Int = -1

    init {
        viewModelScope.launch {
            val route = savedStateHandle.toRoute<Destinations.Details>()
            championId = route.id
            val champion = repository.readOne(championId)
            champion?.let {
                _uiState.value = champion.toDetailUiState()
            }
        }
    }

    fun deleteChampion() {
        viewModelScope.launch {
            if (championId != -1) {
                repository.removeChampion(championId)
            }
        }
    }
}

fun Champion.toDetailUiState(): DetailUiState {
    return DetailUiState(
        this.imageUrl,
        this.splashImageUrl,
        this.name,
        this.title,
        this.description,
        this.longDescription,
        this.stats,
        this.abilities,
        this.deletable
    )
}

data class DetailUiState(
    val imageUrl: String = "",
    val splashImageUrl: String = "",
    val name: LocalizedString = LocalizedString.Plain(""),
    val title: LocalizedString = LocalizedString.Plain(""),
    val description: LocalizedString = LocalizedString.Plain(""),
    val longDescription: LocalizedString = LocalizedString.Plain(""),
    val stats: Stats = Stats(
        hpBase = 0.0,
        hpPerLevel = 0.0,
        mpBase = 0.0,
        mpPerLevel = 0.0,
        adBase = 0.0,
        adPerLevel = 0.0,
        armorBase = 0.0,
        armorPerLevel = 0.0,
        mrBase = 0.0,
        mrPerLevel = 0.0,
        attackSpeedBase = 0.0,
        attackSpeedPerLevel = 0.0,
        moveSpeed = 0,
        range = 0
    ),
    val abilities: List<Ability> = emptyList(),
    val deletable: Boolean = false
)
