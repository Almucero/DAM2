package com.example.lazyapp.ui

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.lazyapp.R
import com.example.lazyapp.lazyList.ChampionListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(
                    stringResource(R.string.create_label),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                ) },
                icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
                onClick = { },
                shape = CircleShape
            )
        }
    ) { innerPadding ->
        ChampionListScreen(
            modifier = Modifier.consumeWindowInsets(innerPadding).padding(innerPadding)
        )
    }
}
