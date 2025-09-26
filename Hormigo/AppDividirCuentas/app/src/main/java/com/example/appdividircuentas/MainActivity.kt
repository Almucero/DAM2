package com.example.appdividircuentas

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntRange
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appdividircuentas.ui.theme.AppDividirCuentasTheme
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppDividirCuentasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Pantalla(modifier = Modifier.padding((innerPadding)))
                    }
                }
            }
        }
    }
}

@Composable
fun Pantalla(modifier: Modifier) {
    var cantidad by remember { mutableStateOf("") }
    var comensales by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    TextField(
        value = cantidad,
        onValueChange = { cantidad = it },
        label = { Text("Cantidad") },
        modifier = modifier.fillMaxWidth()
    )
    TextField(
        value = comensales,
        onValueChange = { comensales = it },
        label = { Text("Comensales") },
        modifier = modifier.fillMaxWidth()
    )
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = MaterialTheme.colorScheme.secondary,
            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        steps = 4,
        valueRange = 0f..5f
    )
    Text(text = sliderPosition.toString())

    var cantidadTotal by remember { mutableStateOf("") }
    var cadaUno by remember { mutableStateOf("") }

    Button(onClick = {
        var cantidadDouble: Double = cantidad.toDouble()
        var comensalesInt: Int = comensales.toInt()
        when (sliderPosition.roundToInt()) {
            1 -> {
                cantidadDouble = cantidadDouble + cantidadDouble*0.05
            }
            2 -> {
                cantidadDouble = cantidadDouble + cantidadDouble*0.1
            }
            3 -> {
                cantidadDouble = cantidadDouble + cantidadDouble*0.15
            }
            4 -> {
                cantidadDouble = cantidadDouble + cantidadDouble*0.2
            }
            5 -> {
                cantidadDouble = cantidadDouble + cantidadDouble*0.25
            }
        }
        if (checked) {
            cantidadTotal = cantidadDouble.roundToInt().toString()
            cadaUno = (cantidadDouble.roundToInt()/comensalesInt).toString()
        }
        else {
            cantidadTotal = cantidadDouble.toString()
            cadaUno = (cantidadDouble.toInt()/comensalesInt).toString()
        }
    }, modifier = modifier.fillMaxWidth()) {
        Text("Calcular")
    }
    Text(
        text = "Cantidad total: $cantidadTotal"
    )
    Text(
        text = "Cada uno: $cadaUno"
    )
}