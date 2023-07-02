/*
 * Created by Mohamed Naser on 7/2/23, 4:05 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/2/23, 4:05 PM
 *
 */

package com.example.cinematickets.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ResizableImage(
    modifier: Modifier = Modifier,
    painter: Painter,
    size: Int = 0,
) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .size(size.dp)
            .clip(RoundedCornerShape(16.dp)),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop
    )
}