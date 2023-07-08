/*
 * Created by Mohamed Naser on 7/8/23, 11:30 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 11:30 AM
 *
 */

package com.example.cinematickets.screens.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.composable.ResizableImage

@Composable
fun BackgroundImageBlur(images: List<String>, currentPage: Int) {
    Box(modifier = Modifier.fillMaxWidth()) {
        if (currentPage in images.indices) {
            ResizableImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .blur(radius = 20.dp),
                painter = rememberAsyncImagePainter(images[currentPage])
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.surface
                        ),
                        startY = 0f,
                        endY = 800f
                    )
                )
        )
    }
}