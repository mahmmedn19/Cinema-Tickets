/*
 * Created by Mohamed Naser on 7/8/23, 11:32 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 11:32 AM
 *
 */

package com.example.cinematickets.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MovieImage(imageResId: Int) {
    val imageModifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(16.dp))

    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = imageModifier
    )
}
