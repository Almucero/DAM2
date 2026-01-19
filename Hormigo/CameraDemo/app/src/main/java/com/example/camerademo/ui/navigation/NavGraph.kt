package com.example.camerademo.ui.navigation

import android.net.Uri
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.camerademo.ui.camera.CameraViewModel
import androidx.core.net.toUri

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val startDestination = Destinations.Camera
    val context = LocalContext.current
    val viewModel: CameraViewModel = hiltViewModel()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        val contentModifier = Modifier.consumeWindowInsets(innerPadding).padding(innerPadding)
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            cameraDestination(
                modifier = contentModifier,
                onNavigateToImage = { navController.navigateToImage(it) }
            )
            imageDestination(
                modifier = contentModifier,
                onAccept = {
                    viewModel.saveToGallery(context, it.toUri())
                    navController.popBackStack()
                },
                onCancel = {
                    navController.popBackStack()
                }
            )
        }
    }
}