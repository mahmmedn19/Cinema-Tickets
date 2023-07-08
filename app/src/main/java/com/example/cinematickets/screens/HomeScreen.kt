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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.compose.rememberNavController
import com.example.cinematickets.R
import com.example.cinematickets.utils.Utils
import com.example.cinematickets.composable.AppNavigation
import com.example.cinematickets.composable.BottomNavigationBar
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.CustomText
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.ResizableImage
import com.example.cinematickets.composable.SuggestTag
import com.example.cinematickets.composable.TextChip
import com.example.cinematickets.composable.VerticalSpacer
import kotlin.math.absoluteValue

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
   // val navController = rememberNavController()
    BackgroundImageBlur(images, pagerState.currentPage)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalSpacer(height = 32.dp)
        ChipSelected(selectedChipIndex)

        HorizontalPager(
            pageCount = images.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
            pageSpacing = 16.dp
        ) { page ->
            Box(
                modifier = Modifier
                    .aspectRatio(4.6f / 5.2f)
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                        alpha = lerp(
                            start = 0.7f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )

                        scaleY = lerp(
                            start = 0.8f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    },
            ) {
                MovieImage(images[page])
            }
        }

        MovieDetails()
        SuggestTag()
/*        Scaffold(
            containerColor = Color.White,
            contentColor = Color.White,
            bottomBar = { BottomNavigationBar(navController) },
        ) {
            AppNavigation(navController)
        }*/
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
    HomeScreen()
}

@Composable
private fun BackgroundImageBlur(images: List<Int>, currentPage: Int) {
    Box(modifier = Modifier.fillMaxWidth()) {
        if (currentPage in images.indices) {
            ResizableImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .blur(radius = 20.dp),
                painter = painterResource(id = images[currentPage])
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
                        endY = 1000f
                    )
                )
        )
    }
}

@Composable
private fun ChipSelected(selectedChipIndex: MutableState<Int>) {
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
}

@Composable
private fun MovieImage(imageResId: Int) {
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

@Composable
private fun MovieDetails() {
    Row(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
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
        text = stringResource(R.string.movie_description),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 64.dp),
        fontSize = 20.sp,
    )

    VerticalSpacer(height = 16.dp)
}