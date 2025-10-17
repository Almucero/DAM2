package com.turingalan.pokemon.ui

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.turingalan.pokemon.ui.list.PokemonListScreen

@Composable
fun NavGraph() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
                bse ->
                val itemDestination: Destinations.Details = bse.toRoute()
                val itemId = itemDestination.id
//                val item = pokemonList.first() { it.id == itemId }
//                PokemonDetailScreen(
//                    modifier = hostModifier,
//                    name = item.name,
//                    artworkId = item.artwork,
//                    onCancel = {
//                        navController.popBackStack()
//                    }
//                )
            }
        }
    }
}