package com.example.lazyapp.ui.create

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazyapp.data.model.Ability
import com.example.lazyapp.data.model.LocalizedString
import com.example.lazyapp.data.repository.ChampionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.toDoubleOrNull
import kotlin.text.toIntOrNull

// Moved from CreateChampionScreen
class AbilityFormState(val kind: String, idInit: String = kind) {
    val id = TextFieldState(idInit)
    val imageUrl = TextFieldState()
    val nameText = TextFieldState()
    val descriptionText = TextFieldState()
    val cooldowns = TextFieldState()
    val costs = TextFieldState()
    val effectsText = TextFieldState()

    var imageUrlError: String? by mutableStateOf(null)
    var nameTextError: String? by mutableStateOf(null)
    var descriptionTextError: String? by mutableStateOf(null)
    var cooldownsError: String? by mutableStateOf(null)
    var costsError: String? by mutableStateOf(null)
    var effectsTextError: String? by mutableStateOf(null)

    fun validate(mandatoryError: String): Boolean {
        var allValid = true
        if (imageUrl.text.toString().isBlank()) {
            imageUrlError = mandatoryError
            allValid = false
        } else {
            imageUrlError = null
        }
        if (nameText.text.toString().isBlank()) {
            nameTextError = mandatoryError
            allValid = false
        } else {
            nameTextError = null
        }
        if (descriptionText.text.toString().isBlank()) {
            descriptionTextError = mandatoryError
            allValid = false
        } else {
            descriptionTextError = null
        }
        if (cooldowns.text.toString().isBlank()) {
            cooldownsError = mandatoryError
            allValid = false
        } else {
            cooldownsError = null
        }
        if (costs.text.toString().isBlank()) {
            costsError = mandatoryError
            allValid = false
        } else {
            costsError = null
        }
        if (effectsText.text.toString().isBlank()) {
            effectsTextError = mandatoryError
            allValid = false
        } else {
            effectsTextError = null
        }
        return allValid
    }
}

@HiltViewModel
class CreateChampionViewModel @Inject constructor(
    private val respository: ChampionRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<CreateUiState> = MutableStateFlow(CreateUiState.New)
    val uiState: StateFlow<CreateUiState>
        get() = _uiState.asStateFlow()

    val imageUrlState = TextFieldState()
    val nameState = TextFieldState()
    val titleState = TextFieldState()
    val descriptionState = TextFieldState()
    val splashImageState = TextFieldState()
    val longDescriptionState = TextFieldState()
    val hpBaseState = TextFieldState()
    val hpPerLevelState = TextFieldState()
    val mpBaseState = TextFieldState()
    val mpPerLevelState = TextFieldState()
    val adBaseState = TextFieldState()
    val adPerLevelState = TextFieldState()
    val armorBaseState = TextFieldState()
    val armorPerLevelState = TextFieldState()
    val mrBaseState = TextFieldState()
    val mrPerLevelState = TextFieldState()
    val attackSpeedBaseState = TextFieldState()
    val attackSpeedPerLevelState = TextFieldState()
    val moveSpeedState = TextFieldState()
    val rangeState = TextFieldState()

    val abilityStates = mutableStateListOf<AbilityFormState>()

    init {
        abilityStates.addAll(
            listOf(
                AbilityFormState("Passive"),
                AbilityFormState("Q"),
                AbilityFormState("W"),
                AbilityFormState("E"),
                AbilityFormState("R")
            )
        )
    }

    // Individual error states for each TextField
    private val _imageUrlError = MutableStateFlow<String?>(null)
    val imageUrlError: StateFlow<String?> = _imageUrlError.asStateFlow()

    private val _nameError = MutableStateFlow<String?>(null)
    val nameError: StateFlow<String?> = _nameError.asStateFlow()

    private val _titleError = MutableStateFlow<String?>(null)
    val titleError: StateFlow<String?> = _titleError.asStateFlow()

    private val _descriptionError = MutableStateFlow<String?>(null)
    val descriptionError: StateFlow<String?> = _descriptionError.asStateFlow()

    private val _splashImageError = MutableStateFlow<String?>(null)
    val splashImageError: StateFlow<String?> = _splashImageError.asStateFlow()

    private val _longDescriptionError = MutableStateFlow<String?>(null)
    val longDescriptionError: StateFlow<String?> = _longDescriptionError.asStateFlow()

    private val _hpBaseError = MutableStateFlow<String?>(null)
    val hpBaseError: StateFlow<String?> = _hpBaseError.asStateFlow()

    private val _hpPerLevelError = MutableStateFlow<String?>(null)
    val hpPerLevelError: StateFlow<String?> = _hpPerLevelError.asStateFlow()

    private val _mpBaseError = MutableStateFlow<String?>(null)
    val mpBaseError: StateFlow<String?> = _mpBaseError.asStateFlow()

    private val _mpPerLevelError = MutableStateFlow<String?>(null)
    val mpPerLevelError: StateFlow<String?> = _mpPerLevelError.asStateFlow()

    private val _adBaseError = MutableStateFlow<String?>(null)
    val adBaseError: StateFlow<String?> = _adBaseError.asStateFlow()

    private val _adPerLevelError = MutableStateFlow<String?>(null)
    val adPerLevelError: StateFlow<String?> = _adPerLevelError.asStateFlow()

    private val _armorBaseError = MutableStateFlow<String?>(null)
    val armorBaseError: StateFlow<String?> = _armorBaseError.asStateFlow()

    private val _armorPerLevelError = MutableStateFlow<String?>(null)
    val armorPerLevelError: StateFlow<String?> = _armorPerLevelError.asStateFlow()

    private val _mrBaseError = MutableStateFlow<String?>(null)
    val mrBaseError: StateFlow<String?> = _mrBaseError.asStateFlow()

    private val _mrPerLevelError = MutableStateFlow<String?>(null)
    val mrPerLevelError: StateFlow<String?> = _mrPerLevelError.asStateFlow()

    private val _attackSpeedBaseError = MutableStateFlow<String?>(null)
    val attackSpeedBaseError: StateFlow<String?> = _attackSpeedBaseError.asStateFlow()

    private val _attackSpeedPerLevelError = MutableStateFlow<String?>(null)
    val attackSpeedPerLevelError: StateFlow<String?> = _attackSpeedPerLevelError.asStateFlow()

    private val _moveSpeedError = MutableStateFlow<String?>(null)
    val moveSpeedError: StateFlow<String?> = _moveSpeedError.asStateFlow()

    private val _rangeError = MutableStateFlow<String?>(null)
    val rangeError: StateFlow<String?> = _rangeError.asStateFlow()

    private fun validateAbilities(mandatoryError: String): Boolean {
        var allValid = true
        abilityStates.forEach { abilityState ->
            if (!abilityState.validate(mandatoryError)) {
                allValid = false
            }
        }
        return allValid
    }

    private fun validateChampionFields(
        mandatoryError: String,
        numericError: (String) -> String,
        integerError: (String) -> String
    ): Boolean {
        clearChampionErrors()
        var hasError = false

        mapOf(
            imageUrlState to _imageUrlError,
            nameState to _nameError,
            titleState to _titleError,
            descriptionState to _descriptionError,
            splashImageState to _splashImageError,
            longDescriptionState to _longDescriptionError
        ).forEach { (state, errorFlow) ->
            if (state.text.toString().isBlank()) {
                errorFlow.value = mandatoryError
                hasError = true
            }
        }

        mapOf(
            hpBaseState to Pair("HP Base", _hpBaseError),
            hpPerLevelState to Pair("HP Per Level", _hpPerLevelError),
            mpBaseState to Pair("MP Base", _mpBaseError),
            mpPerLevelState to Pair("MP Per Level", _mpPerLevelError),
            adBaseState to Pair("AD Base", _adBaseError),
            adPerLevelState to Pair("AD Per Level", _adPerLevelError),
            armorBaseState to Pair("Armor Base", _armorBaseError),
            armorPerLevelState to Pair("Armor Per Level", _armorPerLevelError),
            mrBaseState to Pair("MR Base", _mrBaseError),
            mrPerLevelState to Pair("MR Per Level", _mrPerLevelError),
            attackSpeedBaseState to Pair("Attack Speed Base", _attackSpeedBaseError),
            attackSpeedPerLevelState to Pair("Attack Speed Per Level", _attackSpeedPerLevelError)
        ).forEach { (state, data) ->
            val (name, errorFlow) = data
            if (validateNumericField(state.text.toString(), name, errorFlow, mandatoryError, numericError)) {
                hasError = true
            }
        }

        mapOf(
            moveSpeedState to Pair("Move Speed", _moveSpeedError),
            rangeState to Pair("Range", _rangeError)
        ).forEach { (state, data) ->
            val (name, errorFlow) = data
            if (validateIntField(state.text.toString(), name, errorFlow, mandatoryError, integerError)) {
                hasError = true
            }
        }

        return !hasError
    }

    fun attemptCreation(
        mandatoryErrorMessage: String,
        getNumericErrorMessage: (String) -> String,
        getIntegerErrorMessage: (String) -> String,
        championFieldsGenericError: String,
        unexpectedErrorMessage: String
    ) {
        val areChampionFieldsValid = validateChampionFields(
            mandatoryErrorMessage,
            getNumericErrorMessage,
            getIntegerErrorMessage
        )
        val areAbilitiesValid = validateAbilities(mandatoryErrorMessage)

        if (!areAbilitiesValid || !areChampionFieldsValid) {
            _uiState.value = CreateUiState.Error(championFieldsGenericError)
            return
        }

        val abilities = abilityStates.map { ability ->
            Ability(
                id = ability.id.text.toString(),
                imageUrl = ability.imageUrl.text.toString(),
                name = LocalizedString.Plain(ability.nameText.text.toString()),
                description = LocalizedString.Plain(ability.descriptionText.text.toString()),
                cooldowns = ability.cooldowns.text.toString().takeIf { it.isNotBlank() },
                costs = ability.costs.text.toString().takeIf { it.isNotBlank() },
                effects = LocalizedString.Plain(ability.effectsText.text.toString())
            )
        }

        viewModelScope.launch {
            if (respository.addChampion(
                    imageUrl = imageUrlState.text.toString(),
                    splashImageUrl = splashImageState.text.toString(),
                    name = nameState.text.toString(),
                    title = titleState.text.toString(),
                    description = descriptionState.text.toString(),
                    longDescription = longDescriptionState.text.toString(),
                    hpBase = hpBaseState.text.toString().toDoubleOrNull() ?: 0.0,
                    hpPerLevel = hpPerLevelState.text.toString().toDoubleOrNull() ?: 0.0,
                    mpBase = mpBaseState.text.toString().toDoubleOrNull() ?: 0.0,
                    mpPerLevel = mpPerLevelState.text.toString().toDoubleOrNull() ?: 0.0,
                    adBase = adBaseState.text.toString().toDoubleOrNull() ?: 0.0,
                    adPerLevel = adPerLevelState.text.toString().toDoubleOrNull() ?: 0.0,
                    armorBase = armorBaseState.text.toString().toDoubleOrNull() ?: 0.0,
                    armorPerLevel = armorPerLevelState.text.toString().toDoubleOrNull() ?: 0.0,
                    mrBase = mrBaseState.text.toString().toDoubleOrNull() ?: 0.0,
                    mrPerLevel = mrPerLevelState.text.toString().toDoubleOrNull() ?: 0.0,
                    attackSpeedBase = attackSpeedBaseState.text.toString().toDoubleOrNull() ?: 0.0,
                    attackSpeedPerLevel = attackSpeedPerLevelState.text.toString().toDoubleOrNull()
                        ?: 0.0,
                    moveSpeed = moveSpeedState.text.toString().toIntOrNull() ?: 0,
                    range = rangeState.text.toString().toIntOrNull() ?: 0,
                    abilities = abilities
                )
            ) {
                _uiState.value = CreateUiState.Created
            } else {
                _uiState.value = CreateUiState.Error(unexpectedErrorMessage)
            }
        }
    }

    private fun validateNumericField(
        text: String,
        fieldName: String,
        errorFlow: MutableStateFlow<String?>,
        mandatoryError: String,
        numericError: (String) -> String
    ): Boolean {
        if (text.isEmpty()) {
            errorFlow.value = mandatoryError
            return true
        }
        if (text.toDoubleOrNull() == null) {
            errorFlow.value = numericError(fieldName)
            return true
        }
        return false
    }

    private fun validateIntField(
        text: String,
        fieldName: String,
        errorFlow: MutableStateFlow<String?>,
        mandatoryError: String,
        integerError: (String) -> String
    ): Boolean {
        if (text.isEmpty()) {
            errorFlow.value = mandatoryError
            return true
        }
        if (text.toIntOrNull() == null) {
            errorFlow.value = integerError(fieldName)
            return true
        }
        return false
    }

    private fun clearChampionErrors() {
        listOf(
            _imageUrlError, _nameError, _titleError, _descriptionError, _splashImageError,
            _longDescriptionError, _hpBaseError, _hpPerLevelError, _mpBaseError, _mpPerLevelError,
            _adBaseError, _adPerLevelError, _armorBaseError, _armorPerLevelError, _mrBaseError,
            _mrPerLevelError, _attackSpeedBaseError, _attackSpeedPerLevelError, _moveSpeedError,
            _rangeError
        ).forEach { it.value = null }
    }
}

sealed class CreateUiState {
    object New : CreateUiState()
    data class Error(val message: String) : CreateUiState()
    object Cancelled : CreateUiState()
    object Created : CreateUiState()
}
