package com.gamesage.marvel.ui.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import com.gamesage.marvel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    backStackEntry: NavBackStackEntry? = null
) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        }
    )
}