package com.example.camerademo

import android.Manifest
import android.annotation.SuppressLint
import androidx.camera.compose.CameraXViewfinder
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@SuppressLint("PermissionLaunchedDuringComposition")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(
    modifier: Modifier = Modifier,
    viewModel: CameraViewModel
) {
    val context = LocalContext.current

    val cameraPermissionState = rememberPermissionState(
        Manifest.permission.CAMERA
    )

    if (cameraPermissionState.status.isGranted) {
        Box(modifier = modifier.fillMaxSize()) {
            CameraPreview(modifier = modifier, viewModel = viewModel)
            CameraControls(
                modifier = modifier.align(Alignment.BottomCenter).padding(bottom = 32.dp),
                onSwitchCamera = { viewModel.switchCamera() },
                onCaptureImage = { viewModel.takePicture(context) },
            )
        }
    }
    //No tenemos permisos para usar la camara
    else {
        LaunchedEffect("CAMERA_PERMISSION") {
            cameraPermissionState.launchPermissionRequest()
        }
    }
}

@Composable
fun CameraPreview(
    modifier: Modifier = Modifier,
    viewModel: CameraViewModel = CameraViewModel(),
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
    val surfaceRequest by viewModel.surfaceRequest.collectAsStateWithLifecycle()
    val cameraSelector by viewModel.cameraSelector.collectAsStateWithLifecycle()

    val context = LocalContext.current
    LaunchedEffect(lifecycleOwner, cameraSelector) {
        viewModel.bindToCamera(
            context = context.applicationContext,
            lifecycleOwner = lifecycleOwner,
            cameraSelector = cameraSelector
        )
    }

    surfaceRequest?.let { newSurfaceRequest ->
        CameraXViewfinder(
            surfaceRequest = newSurfaceRequest,
            modifier = modifier,
        )
    }
}

@Composable
fun CameraControls(
    modifier: Modifier = Modifier,
    onSwitchCamera: () -> Unit,
    onCaptureImage: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(32.dp))
        IconButton(
            onClick = onCaptureImage,
            modifier = Modifier.size(72.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Circle,
                contentDescription = "Tomar foto",
                tint = Color.White,
                modifier = Modifier.fillMaxSize()
            )
        }
        IconButton(onClick = onSwitchCamera) {
            Icon(
                imageVector = Icons.Default.Cameraswitch,
                contentDescription = "Cambiar cámara",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}