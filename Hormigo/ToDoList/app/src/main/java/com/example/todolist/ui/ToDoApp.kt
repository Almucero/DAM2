package com.example.todolist.ui

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.todolist.R
import com.example.todolist.data.todos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.app_name)) }
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        innerPadding ->
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Destinations.List.route,
            ) {

            }
    }
}