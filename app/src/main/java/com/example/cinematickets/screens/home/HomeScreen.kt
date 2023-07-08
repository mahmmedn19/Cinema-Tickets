/*
 * Created by Mohamed Naser on 7/8/23, 11:27 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 11:27 AM
 *
 */

package com.example.cinematickets.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.cinematickets.R
import com.example.cinematickets.composable.SuggestTag
import com.example.cinematickets.composable.VerticalSpacer
import com.example.cinematickets.screens.home.composable.BackgroundImageBlur
import com.example.cinematickets.screens.home.composable.ChipSelected
import com.example.cinematickets.screens.home.composable.MovieDetails
import com.example.cinematickets.screens.home.composable.MovieImage
import com.example.cinematickets.utils.Utils
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