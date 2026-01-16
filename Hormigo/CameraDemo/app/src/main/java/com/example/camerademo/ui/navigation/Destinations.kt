package com.example.camerademo.ui.navigation

import androidx.camera.core.ImageCapture
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.camerademo.ui.camera.CameraScreen
import com.example.camerademo.ui.image.ImageScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations(val route: String) {
    @Serializable
    data object Camera: Destinations("camera")
    
    @Serializable
    data class Image(val imageUri: String): Destinations("image")
}

fun NavController.navigateToImage(imageUri: String) {
    this.navigate(Destinations.Image(imageUri))
}

fun NavGraphBuilder.imageDestination(
    modifier: Modifier = Modifier
) {
    composable<Destinations.Image> {
        backStackEntry ->
        ImageScreen(
            modifier = modifier
        )
    }
}

fun NavGraphBuilder.cameraDestination(
    modifier: Modifier = Modifier,
    onNavigateToImage: (String) -> Unit
) {
    composable<Destinations.Camera> {
        CameraScreen(
            modifier = modifier,
            onShowImage = onNavigateToImage
        )
    }
}