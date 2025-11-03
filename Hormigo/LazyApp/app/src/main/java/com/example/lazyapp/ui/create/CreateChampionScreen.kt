package com.example.lazyapp.ui.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lazyapp.R

@Composable
fun CreateChampionScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateChampionViewModel = hiltViewModel(),
    onCancel: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val currentState = uiState

    if (currentState is CreateUiState.Cancelled || currentState is CreateUiState.Created) {
        onCancel()
    }

    CreateForm(
        modifier = modifier,
        viewModel = viewModel,
        generalError = (currentState as? CreateUiState.Error)?.message,
        onCancel = onCancel
    )
}

@Composable
private fun ValidatedTextField(
    textState: TextFieldState,
    label: String,
    errorMessage: String? = null,
    isNumeric: Boolean = false,
) {
    OutlinedTextField(
        state = textState,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        isError = errorMessage != null,
        keyboardOptions = if (isNumeric) {
            KeyboardOptions(keyboardType = KeyboardType.Number)
        } else {
            KeyboardOptions.Default
        },
        supportingText = {
            if (errorMessage != null) {
                Text(errorMessage)
            }
        }
    )
}

@Composable
fun CreateForm(
    modifier: Modifier = Modifier,
    viewModel: CreateChampionViewModel,
    generalError: String? = null,
    onCancel: () -> Unit
) {
    Surface(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ChampionInfoSection(viewModel)
            HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(vertical = 12.dp))
            ChampionStatsSection(viewModel)
            HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(vertical = 12.dp))
            ChampionAbilitiesSection(viewModel.abilityStates)
            ActionButtons(viewModel, onCancel, generalError)
        }
    }
}

@Composable
private fun ChampionInfoSection(viewModel: CreateChampionViewModel) {
    val imageUrlError by viewModel.imageUrlError.collectAsStateWithLifecycle()
    val nameError by viewModel.nameError.collectAsStateWithLifecycle()
    val titleError by viewModel.titleError.collectAsStateWithLifecycle()
    val descriptionError by viewModel.descriptionError.collectAsStateWithLifecycle()
    val splashImageError by viewModel.splashImageError.collectAsStateWithLifecycle()
    val longDescriptionError by viewModel.longDescriptionError.collectAsStateWithLifecycle()

    Text(stringResource(R.string.create_text_1), fontSize = 16.sp)
    ValidatedTextField(viewModel.imageUrlState, stringResource(R.string.create_text_2), imageUrlError)
    ValidatedTextField(viewModel.nameState, stringResource(R.string.create_text_3), nameError)
    ValidatedTextField(viewModel.titleState, stringResource(R.string.create_text_4), titleError)
    ValidatedTextField(viewModel.descriptionState, stringResource(R.string.create_text_5), descriptionError)
    ValidatedTextField(viewModel.splashImageState, stringResource(R.string.create_text_6), splashImageError)
    ValidatedTextField(viewModel.longDescriptionState, stringResource(R.string.create_text_7), longDescriptionError)
}

@Composable
private fun ChampionStatsSection(viewModel: CreateChampionViewModel) {
    val hpBaseError by viewModel.hpBaseError.collectAsStateWithLifecycle()
    val hpPerLevelError by viewModel.hpPerLevelError.collectAsStateWithLifecycle()
    val mpBaseError by viewModel.mpBaseError.collectAsStateWithLifecycle()
    val mpPerLevelError by viewModel.mpPerLevelError.collectAsStateWithLifecycle()
    val adBaseError by viewModel.adBaseError.collectAsStateWithLifecycle()
    val adPerLevelError by viewModel.adPerLevelError.collectAsStateWithLifecycle()
    val armorBaseError by viewModel.armorBaseError.collectAsStateWithLifecycle()
    val armorPerLevelError by viewModel.armorPerLevelError.collectAsStateWithLifecycle()
    val mrBaseError by viewModel.mrBaseError.collectAsStateWithLifecycle()
    val mrPerLevelError by viewModel.mrPerLevelError.collectAsStateWithLifecycle()
    val attackSpeedBaseError by viewModel.attackSpeedBaseError.collectAsStateWithLifecycle()
    val attackSpeedPerLevelError by viewModel.attackSpeedPerLevelError.collectAsStateWithLifecycle()
    val moveSpeedError by viewModel.moveSpeedError.collectAsStateWithLifecycle()
    val rangeError by viewModel.rangeError.collectAsStateWithLifecycle()

    Text(stringResource(R.string.create_text_8), fontSize = 16.sp)
    ValidatedTextField(viewModel.hpBaseState, stringResource(R.string.create_text_9), hpBaseError, true)
    ValidatedTextField(viewModel.hpPerLevelState, stringResource(R.string.create_text_10), hpPerLevelError, true)
    ValidatedTextField(viewModel.mpBaseState, stringResource(R.string.create_text_11), mpBaseError, true)
    ValidatedTextField(viewModel.mpPerLevelState, stringResource(R.string.create_text_12), mpPerLevelError, true)
    ValidatedTextField(viewModel.adBaseState, stringResource(R.string.create_text_13), adBaseError, true)
    ValidatedTextField(viewModel.adPerLevelState, stringResource(R.string.create_text_14), adPerLevelError, true)
    ValidatedTextField(viewModel.armorBaseState, stringResource(R.string.create_text_15), armorBaseError, true)
    ValidatedTextField(viewModel.armorPerLevelState, stringResource(R.string.create_text_16), armorPerLevelError, true)
    ValidatedTextField(viewModel.mrBaseState, stringResource(R.string.create_text_17), mrBaseError, true)
    ValidatedTextField(viewModel.mrPerLevelState, stringResource(R.string.create_text_18), mrPerLevelError, true)
    ValidatedTextField(viewModel.attackSpeedBaseState, stringResource(R.string.create_text_19), attackSpeedBaseError, true)
    ValidatedTextField(viewModel.attackSpeedPerLevelState, stringResource(R.string.create_text_20), attackSpeedPerLevelError, true)
    ValidatedTextField(viewModel.moveSpeedState, stringResource(R.string.create_text_21), moveSpeedError, true)
    ValidatedTextField(viewModel.rangeState, stringResource(R.string.create_text_22), rangeError, true)
}

@Composable
private fun ChampionAbilitiesSection(abilityStates: SnapshotStateList<AbilityFormState>) {
    Text(stringResource(R.string.create_abilities_title), fontSize = 16.sp)
    abilityStates.forEach { ability ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            Text(stringResource(R.string.create_ability_kind_label, ability.kind), fontSize = 14.sp)
            ValidatedTextField(ability.imageUrl, stringResource(R.string.create_text_24), ability.imageUrlError)
            ValidatedTextField(ability.nameText, stringResource(R.string.create_text_25), ability.nameTextError)
            ValidatedTextField(ability.descriptionText, stringResource(R.string.create_text_26), ability.descriptionTextError)
            ValidatedTextField(ability.cooldowns, stringResource(R.string.create_text_27), ability.cooldownsError)
            ValidatedTextField(ability.costs, stringResource(R.string.create_text_28), ability.costsError)
            ValidatedTextField(ability.effectsText, stringResource(R.string.create_text_29), ability.effectsTextError)
        }
        HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(vertical = 12.dp))
    }
}

@Composable
private fun ActionButtons(
    viewModel: CreateChampionViewModel,
    onCancel: () -> Unit,
    generalError: String?
) {
    val mandatoryErrorMessage = stringResource(id = R.string.error_field_mandatory)
    val numericErrorMessageFormat = stringResource(id = R.string.error_field_must_be_number)
    val integerErrorMessageFormat = stringResource(id = R.string.error_field_must_be_integer)
    val championFieldsGenericError = stringResource(id = R.string.error_fix_champion_fields)
    val unexpectedErrorMessage = stringResource(id = R.string.error_unexpected)
    val getNumericErrorMessage: (String) -> String = { fieldName -> String.format(numericErrorMessageFormat, fieldName) }
    val getIntegerErrorMessage: (String) -> String = { fieldName -> String.format(integerErrorMessageFormat, fieldName) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = {
                viewModel.attemptCreation(
                    mandatoryErrorMessage = mandatoryErrorMessage,
                    getNumericErrorMessage = getNumericErrorMessage,
                    getIntegerErrorMessage = getIntegerErrorMessage,
                    championFieldsGenericError = championFieldsGenericError,
                    unexpectedErrorMessage = unexpectedErrorMessage
                )
            },
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(R.string.create_champion_button))
        }
        Button(onClick = onCancel, modifier = Modifier.weight(1f)) {
            Text(stringResource(R.string.cancel_button))
        }
    }
    if (generalError != null) {
        Text(
            text = generalError,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
    Spacer(modifier = Modifier.height(28.dp))
}
