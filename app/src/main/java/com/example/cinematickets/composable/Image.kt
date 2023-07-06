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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.screens.generateRandomImageUrls

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

@Composable
fun MyListImage(dataList: List<String>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(dataList) { imageUrl ->
            ResizableImage(
                painter = rememberAsyncImagePainter(imageUrl),
                size = 200,
                modifier = Modifier
                    .height(200.dp)
                    .padding(end = 8.dp)
            )
        }
    }
}

@Composable
fun MyListRounded(dataList: List<String>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(dataList) { imageUrl ->
            ResizableImage(
                painter = rememberAsyncImagePainter(imageUrl),
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    MyListRounded(generateRandomImageUrls(10))
}