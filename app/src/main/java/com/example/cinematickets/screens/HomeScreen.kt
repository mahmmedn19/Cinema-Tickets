/*
 * Created by Mohamed Naser on 7/2/23, 7:12 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/2/23, 7:12 AM
 *
 */

package com.example.cinematickets.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.Utils
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.CustomText
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.ResizableImage
import com.example.cinematickets.composable.SuggestTag
import com.example.cinematickets.composable.TextChip
import com.example.cinematickets.composable.VerticalSpacer

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val images = listOf(
        R.drawable.movies_image,
        R.drawable.zz,
        R.drawable.movies_image,
    )
    val randomImageUrls = Utils.generateRandomImageUrls(10)
    val selectedChipIndex = remember { mutableStateOf(0) }
    val pagerState = rememberPagerState(images.size)
    val currentIndex = remember { mutableStateOf(1) }

    Box(modifier = Modifier.fillMaxWidth()) {
        if (pagerState.currentPage in images.indices) {
            ResizableImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .blur(radius = 20.dp),
                painter = painterResource(id = images[pagerState.currentPage])
            )
        }
        // Gradient mask
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
                        endY = 1000f
                    )
                )
        )

    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalSpacer(height = 32.dp)
        Row {
            TextChip(
                isSelected = selectedChipIndex.value == 0,
                text = "Now Showing",
                onChecked = { selectedChipIndex.value = 0 }
            )
            TextChip(
                isSelected = selectedChipIndex.value == 1,
                text = "Coming Soon",
                onChecked = { selectedChipIndex.value = 1 }
            )
        }
        HorizontalPager(
            pageCount = images.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(32.dp)
            ) {
                val imageModifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)) // Round the corners of the image

                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
            }
        }

        Row(
            modifier = Modifier.padding(
                vertical = 4.dp, horizontal = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIcon(
                drawableResId = R.drawable.ic_clock_circle,
                tint = Color.Gray
            )
            HorizontalSpacer(width = 4.dp)
            Text(
                text = "2h 23m",
            )
        }
        VerticalSpacer(height = 16.dp)
        CustomText(
            text = "Fantastic Fantastic : the  ghgf dfhfd Fantastic Fantastic ",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp),
            fontSize = 20.sp,
        )
        VerticalSpacer(height = 16.dp)
        SuggestTag()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
    HomeScreen()
}