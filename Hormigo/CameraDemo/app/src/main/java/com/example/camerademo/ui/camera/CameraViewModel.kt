package com.example.camerademo.ui.camera

import android.content.ContentValues
import android.content.Context
import android.provider.MediaStore
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.core.SurfaceRequest
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.lifecycle.awaitInstance
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CameraViewModel(

): ViewModel() {
    private val _surfaceRequest = MutableStateFlow<SurfaceRequest?>(null)
    val surfaceRequest: StateFlow<SurfaceRequest?>
        get() = _surfaceRequest.asStateFlow()

    private val _cameraSelector = MutableStateFlow(CameraSelector.DEFAULT_BACK_CAMERA)
    val cameraSelector: StateFlow<CameraSelector>
        get() = _cameraSelector.asStateFlow()

    private val imageCapture = ImageCapture.Builder().build()

    private val cameraPreviewUseCase = Preview.Builder().build().apply {
        setSurfaceProvider {
            newSurfaceRequest -> _surfaceRequest.value = newSurfaceRequest
        }
    }

    fun takePicture(context: Context) {
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "img_${System.currentTimeMillis()}" )
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        }
        val outputOptions = ImageCapture.OutputFileOptions.Builder(
            context.contentResolver,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            contentValues
        ).build()

        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(context),
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    Toast.makeText(context, "Foto Guardada", Toast.LENGTH_SHORT).show()
                }
                override fun onError(exc: ImageCaptureException) {
                    Toast.makeText(context, "Error: ${exc.message}", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    fun switchCamera() {
        _cameraSelector.value = if (_cameraSelector.value == CameraSelector.DEFAULT_BACK_CAMERA) {
            CameraSelector.DEFAULT_FRONT_CAMERA
        } else {
            CameraSelector.DEFAULT_BACK_CAMERA
        }
    }

    suspend fun bindToCamera(
        context: Context,
        lifecycleOwner: LifecycleOwner,
        cameraSelector: CameraSelector
    ) {
        val processCameraProvider = ProcessCameraProvider.Companion.awaitInstance(context)
        processCameraProvider.bindToLifecycle(
            lifecycleOwner = lifecycleOwner,
            cameraSelector,
            cameraPreviewUseCase,
            imageCapture
        )
        try {
            awaitCancellation()
        } finally {
            processCameraProvider.unbindAll()
        }
    }
}