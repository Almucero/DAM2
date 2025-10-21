package com.turingalan.pokemon.ui

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.turingalan.pokemon.R
import com.turingalan.pokemon.ui.detail.PokemonDetailScreen
import com.turingalan.pokemon.ui.list.PokemonListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
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
    ) { innerPadding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Destinations.List
        ) {
            val hostModifier = Modifier.consumeWindowInsets(innerPadding).padding(innerPadding)
            composable<Destinations.List> {
                PokemonListScreen(
                    modifier = hostModifier,
                    onNavigateToDetail = {
                            id -> navController.navigate(Destinations.Details(id))
                    }
                )
            }
            composable<Destinations.Details> {
                PokemonDetailScreen(
                    modifier = hostModifier,
                    onCancel = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}