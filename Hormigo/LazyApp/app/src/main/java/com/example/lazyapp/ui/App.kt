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
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
    var showFab by remember { mutableStateOf(false) }
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
            if (showFab) {
                ExtendedFloatingActionButton(
                    text = { Text(
                        stringResource(R.string.create_label),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                    ) },
                    icon = { Icon(Icons.Filled.Add, null) },
                    onClick = {
                        navController.navigate(Destinations.Create)
                    },
                    shape = CircleShape
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destinations.List
        ) {
            val hostModifier = Modifier.consumeWindowInsets(innerPadding).padding(innerPadding).padding(vertical = 8.dp, horizontal = 10.dp)
            composable<Destinations.List> {
                SideEffect { showFab = true }
                ChampionListScreen(
                    modifier = hostModifier,
                    onNavigateToDetail = {
                        id -> navController.navigate(Destinations.Details(id))
                    }
                )
            }
            composable<Destinations.Create> {
                SideEffect { showFab = false }
                CreateChampionScreen(
                    modifier = hostModifier,
                    onCreateItem = { item ->
                        champions.add(item)
                        navController.popBackStack()
                    },
                    onCancel = {
                        navController.popBackStack()
                    }
                )
            }
            composable<Destinations.Details> {
                bse ->
                SideEffect { showFab = false }
                val itemDestination: Destinations.Details = bse.toRoute()
                val itemId = itemDestination.id
                val item = champions.firstOrNull() { it.id == itemId }
                if (item!=null) {
                    ChampionDetailsScreen(
                        modifier = hostModifier,
                        item = item,
                        onCancel = {
                            navController.popBackStack()
                        },
                        onDeleteItem = {
                            champions.removeIf { it.id == itemId }
                            navController.popBackStack()
                        }
                    )
                }
                else {
                    navController.popBackStack()
                }
            }
        }
    }
}
