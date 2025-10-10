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
import androidx.compose.material3.Icon
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
import com.example.lazyapp.R
import com.example.lazyapp.data.champions
import com.example.lazyapp.ui.lazyList.ChampionListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    val navController = rememberNavController()
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
                onClick = {
                    navController.navigate(Destinations.Create)
                },
                shape = CircleShape
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destinations.List
        ) {
            val hostModifier = Modifier.consumeWindowInsets(innerPadding).padding(innerPadding)
            composable<Destinations.List> {
                ChampionListScreen(
                    modifier = hostModifier,
                    onNavigateToDetail = {
                        id -> navController.navigate(Destinations.Details(id))
                    }
                )
            }
            composable<Destinations.Create> {
                CreateChampionScreen(
                    modifier = hostModifier,
                    onCreateItem = {

                    },
                    onCancel = {
                        navController.popBackStack()
                    }
                )
            }
            composable<Destinations.Details> {
                bse ->
                val itemDestination: Destinations.Details = bse.toRoute()
                val itemId = itemDestination.id
                val item = champions.first { it.id == itemId }
                ChampionDetailsScreen(
                    modifier = hostModifier,
                    onCancel = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
