package com.example.dragonball.ui.navigation

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val startDestination = Destinations.CharacterList
    val backStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            //TODO
        }
    ) {
        innerPadding ->
        val contentModifier = Modifier.consumeWindowInsets(innerPadding).padding(innerPadding)
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {

        }
    }
}