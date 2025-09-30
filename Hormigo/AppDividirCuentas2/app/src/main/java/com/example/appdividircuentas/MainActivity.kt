package com.example.appdividircuentas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.appdividircuentas.ui.theme.AppTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen(modifier = Modifier.padding((innerPadding)))
                }
            }
        }
    }
}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    var quantity by remember { mutableStateOf("") }
    var people by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var totalQuantity by remember { mutableStateOf("") }
    var eachOne by remember { mutableStateOf("") }
    var done by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
    ) {
        TextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text(stringResource(R.string.quantity_label)) },
            modifier = modifier.fillMaxWidth().padding(vertical = 12.dp)
        )
        TextField(
            value = people,
            onValueChange = { people = it },
            label = { Text(stringResource(R.string.people_label)) },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.tip_label)
            )
            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )
        }
        Text(
            text = stringResource(R.string.valoration_label)
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
            valueRange = 0f..5f,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = sliderPosition.roundToInt().toString())
        }
        Button(onClick = {
            var doubleQuantity: Double = quantity.toDouble()
            val peopleInt: Int = people.toInt()
            when (sliderPosition.roundToInt()) {
                1 -> doubleQuantity += doubleQuantity*0.05
                2 -> doubleQuantity += doubleQuantity*0.1
                3 -> doubleQuantity += doubleQuantity*0.15
                4 -> doubleQuantity += doubleQuantity*0.2
                5 ->  doubleQuantity += doubleQuantity*0.25
            }
            if (checked) {
                totalQuantity = doubleQuantity.roundToInt().toString()
                eachOne = (doubleQuantity.roundToInt()/peopleInt).toString()
            }
            else {
                totalQuantity = doubleQuantity.toString()
                eachOne = (doubleQuantity.toInt()/peopleInt).toString()
            }
            done = true
        }, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.calculate_24px),
                    contentDescription = "Calculate"
                )
                Text("  "+stringResource(R.string.calculate_label))
            }
        }
        if (done) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.totalQuantity_label)+": $totalQuantity",
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(R.string.eachOne_label)+": $eachOne",
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    AppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Screen(modifier = Modifier.padding((innerPadding)))
        }
    }
}