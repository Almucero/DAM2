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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lazyapp.data.model.Ability
import com.example.lazyapp.data.model.Champion
import com.example.lazyapp.data.model.LocalizedString
import com.example.lazyapp.data.model.Stats
import com.example.lazyapp.data.model.champions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateChampionScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateChampionViewModel = hiltViewModel(),
    onCreateItem: (Champion) -> Unit,
    onCancel: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when(uiState) {
        is CreateUiState.Cancelled -> {
            onCancel()
        }
        is CreateUiState.Created -> {
            onCancel()
        }
        is CreateUiState.Error -> {
            TODO()
        }
        is CreateUiState.New -> {
            CreateForm(
                modifier = modifier,
                viewModel = viewModel,
                error = null,
                onCreateItem = onCreateItem,
                onCancel = onCancel
            )
        }
    }
}

@Composable
fun CreateForm(
    modifier: Modifier = Modifier,
    viewModel: CreateChampionViewModel,
    error: String? = null,
    onCreateItem: (Champion) -> Unit,
    onCancel: () -> Unit
) {
    Surface(
        modifier = modifier
    ) {
        val isScreenInError = error != null
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val imageUrl = remember { mutableStateOf("") }
            val name = remember { mutableStateOf("") }
            val title = remember { mutableStateOf("") }
            val description = remember { mutableStateOf("") }
            val splashUrl = remember { mutableStateOf("") }
            val longDescription = remember { mutableStateOf("") }
            val deletable = true
            Text("Campos obligatorios del campeón", fontSize = 16.sp)
            OutlinedTextField(
                value = imageUrl.value,
                onValueChange = { imageUrl.value = it },
                label = { Text("imageUrl (String)") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("name (String)") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = title.value,
                onValueChange = { title.value = it },
                label = { Text("title (texto plano)") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = description.value,
                onValueChange = { description.value = it },
                label = { Text("description (texto plano)") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = splashUrl.value,
                onValueChange = { splashUrl.value = it },
                label = { Text("splashImageUrl (String)") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = longDescription.value,
                onValueChange = { longDescription.value = it },
                label = { Text("longDescription (texto plano)") },
                modifier = Modifier.fillMaxWidth()
            )

            Divider()

            // --- Stats (abreviado y simple) ---
            Text("Stats (todos obligatorios)", fontSize = 16.sp)
            val hpBase = remember { mutableStateOf("") }
            val hpPerLevel = remember { mutableStateOf("") }
            val mpBase = remember { mutableStateOf("") }
            val mpPerLevel = remember { mutableStateOf("") }
            val adBase = remember { mutableStateOf("") }
            val adPerLevel = remember { mutableStateOf("") }
            val armorBase = remember { mutableStateOf("") }
            val armorPerLevel = remember { mutableStateOf("") }
            val mrBase = remember { mutableStateOf("") }
            val mrPerLevel = remember { mutableStateOf("") }
            val attackSpeedBase = remember { mutableStateOf("") }
            val attackSpeedPerLevel = remember { mutableStateOf("") }
            val moveSpeed = remember { mutableStateOf("") }
            val range = remember { mutableStateOf("") }

            @Composable
            fun NumberField(state: MutableState<String>, label: String) {
                OutlinedTextField(
                    value = state.value,
                    onValueChange = { state.value = it },
                    label = { Text(label) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            NumberField(hpBase, "hpBase (Double)")
            NumberField(hpPerLevel, "hpPerLevel (Double)")
            NumberField(mpBase, "mpBase (Double)")
            NumberField(mpPerLevel, "mpPerLevel (Double)")
            NumberField(adBase, "adBase (Double)")
            NumberField(adPerLevel, "adPerLevel (Double)")
            NumberField(armorBase, "armorBase (Double)")
            NumberField(armorPerLevel, "armorPerLevel (Double)")
            NumberField(mrBase, "mrBase (Double)")
            NumberField(mrPerLevel, "mrPerLevel (Double)")
            NumberField(attackSpeedBase, "attackSpeedBase (Double)")
            NumberField(attackSpeedPerLevel, "attackSpeedPerLevel (Double)")
            NumberField(moveSpeed, "moveSpeed (Int)")
            NumberField(range, "range (Int)")

            Divider()

            // --- Abilities fijas: Passive, Q, W, E, R (sin añadir/eliminar) ---
            Text("Habilidades (completa las 5 obligatorias: Passive, Q, W, E, R)", fontSize = 16.sp)

            // AbilityForm con estados internos para que los TextFields funcionen correctamente (foco/pegar/etc).
            class AbilityForm(val kind: String, idInit: String = kind) {
                var id by mutableStateOf(idInit) // id asignado automáticamente según tipo
                var imageUrl by mutableStateOf("")
                var nameText by mutableStateOf("")
                var descriptionText by mutableStateOf("")
                var cooldowns by mutableStateOf("")
                var costs by mutableStateOf("")
                var effectsText by mutableStateOf("")
            }

            val fixedAbilities = remember {
                mutableStateListOf(
                    AbilityForm("Passive"),
                    AbilityForm("Q"),
                    AbilityForm("W"),
                    AbilityForm("E"),
                    AbilityForm("R")
                )
            }

            fixedAbilities.forEach { form ->
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)) {
                    // mostramos el tipo/id pero no permitimos editarlo
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Habilidad: ${form.kind}", fontSize = 14.sp)
                        Text("(id: ${form.id})", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                    }
                    // campos editables normales — ahora con estado reactivo -> teclado y pegar funcionan
                    OutlinedTextField(form.imageUrl, { form.imageUrl = it }, label = { Text("imageUrl (String)") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(form.nameText, { form.nameText = it }, label = { Text("name (texto plano)") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(form.descriptionText, { form.descriptionText = it }, label = { Text("description (texto plano)") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(form.cooldowns, { form.cooldowns = it }, label = { Text("cooldowns (String) — p.ej. '4s / 4s'") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(form.costs, { form.costs = it }, label = { Text("costs (String) — p.ej. '60 / 65'") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(form.effectsText, { form.effectsText = it }, label = { Text("effects (texto plano)") }, modifier = Modifier.fillMaxWidth())
                }
                Divider()
            }

            Spacer(modifier = Modifier.height(12.dp))

            // --- Create Button & simple validation ---
            var errorMsg by remember { mutableStateOf<String?>(null) }

            // mantenemos la lógica de creación pero movemos el botón abajo para que los dos estén en la misma fila
            fun tryCreate() {
                errorMsg = null
                // id autonumérico
                val nextId = (champions.maxOfOrNull { it.id } ?: 0) + 1

                // checks básicos
                if (imageUrl.value.isBlank()) { errorMsg = "imageUrl vacío"; return }
                if (splashUrl.value.isBlank()) { errorMsg = "splashImageUrl vacío"; return }
                if (name.value.isBlank()) { errorMsg = "name vacío"; return }
                if (title.value.isBlank()) { errorMsg = "title vacío"; return }
                if (description.value.isBlank()) { errorMsg = "description vacío"; return }
                if (longDescription.value.isBlank()) { errorMsg = "longDescription vacío"; return }

                // parse stats (mínimo esfuerzo)
                val stats = try {
                    Stats(
                        hpBase = hpBase.value.toDouble(),
                        hpPerLevel = hpPerLevel.value.toDouble(),
                        mpBase = mpBase.value.toDouble(),
                        mpPerLevel = mpPerLevel.value.toDouble(),
                        adBase = adBase.value.toDouble(),
                        adPerLevel = adPerLevel.value.toDouble(),
                        armorBase = armorBase.value.toDouble(),
                        armorPerLevel = armorPerLevel.value.toDouble(),
                        mrBase = mrBase.value.toDouble(),
                        mrPerLevel = mrPerLevel.value.toDouble(),
                        attackSpeedBase = attackSpeedBase.value.toDouble(),
                        attackSpeedPerLevel = attackSpeedPerLevel.value.toDouble(),
                        moveSpeed = moveSpeed.value.toInt(),
                        range = range.value.toInt()
                    )
                } catch (e: Exception) {
                    errorMsg = "Algún stat inválido"; return
                }

                // abilities parse: todas obligatorias y fijas
                val parsedAbilities = mutableListOf<Ability>()
                fixedAbilities.forEach { f ->
                    if (f.imageUrl.isBlank()) { errorMsg = "Habilidad ${f.kind}: imageUrl vacío"; return }
                    if (f.nameText.isBlank()) { errorMsg = "Habilidad ${f.kind}: name vacío"; return }
                    if (f.descriptionText.isBlank()) { errorMsg = "Habilidad ${f.kind}: description vacío"; return }
                    if (f.effectsText.isBlank()) { errorMsg = "Habilidad ${f.kind}: effects vacío"; return }

                    parsedAbilities.add(
                        Ability(
                            id = f.id,
                            imageUrl = f.imageUrl,
                            name = LocalizedString.Plain(f.nameText),
                            description = LocalizedString.Plain(f.descriptionText),
                            cooldowns = if (f.cooldowns.isBlank()) null else f.cooldowns,
                            costs = if (f.costs.isBlank()) null else f.costs,
                            effects = LocalizedString.Plain(f.effectsText)
                        )
                    )
                }

                // construir campeón y devolver
                val champion = Champion(
                    id = nextId,
                    imageUrl = imageUrl.value,
                    name = LocalizedString.Plain(name.value),
                    title = LocalizedString.Plain(title.value),
                    description = LocalizedString.Plain(description.value),
                    splashImageUrl = splashUrl.value,
                    longDescription = LocalizedString.Plain(longDescription.value),
                    stats = stats,
                    abilities = parsedAbilities,
                    deletable = deletable
                )

                onCreateItem(champion)
            }

            // --- Bottom buttons: ambos en la misma fila y con mismo ancho ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { tryCreate() }, modifier = Modifier.weight(1f)) {
                    Text("Crear campeón")
                }
                Button(onClick = onCancel, modifier = Modifier.weight(1f)) {
                    Text("Cancelar")
                }
            }

            errorMsg?.let {
                Text(text = it, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(top = 8.dp))
            }

            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}

//val titleState = rememberTextFieldState
//OutLinedTextFiled(state=viewModel.titleState)