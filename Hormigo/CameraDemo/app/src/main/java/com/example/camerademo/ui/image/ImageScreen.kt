package com.example.camerademo.ui.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

@Composable
fun ImageScreen(
    modifier: Modifier = Modifier
) {
    Image(
        bitmap = TODO(),
        contentDescription = TODO(),
        modifier = modifier,
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit,
    )
}