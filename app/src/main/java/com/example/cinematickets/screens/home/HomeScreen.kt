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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import com.example.cinematickets.composable.SuggestTag
import com.example.cinematickets.composable.VerticalSpacer
import com.example.cinematickets.screens.book.navigateToBookingScreen
import com.example.cinematickets.screens.home.composable.BackgroundImageBlur
import com.example.cinematickets.screens.home.composable.ChipSelected
import com.example.cinematickets.screens.home.composable.MovieDetails
import com.example.cinematickets.screens.home.composable.MovieImage
import com.example.cinematickets.utils.ListOfImages
import kotlin.math.absoluteValue

@ExperimentalMaterial3Api
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val images = ListOfImages.listOfImages()
    val selectedChipIndex = remember { mutableStateOf(0) }
    val pagerState = rememberPagerState(0)
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
            Card(
                onClick = { navigateToBookingScreen(navController) },
                modifier = Modifier
                    .aspectRatio(4.6f / 5.2f)
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                        alpha = lerp(
                            start = 0.7f,
                            stop = 1f,
                            fraction = 0.8f + 0.8f * (1f - pageOffset.coerceIn(0f, 1f))
                        )

                        scaleY = lerp(
                            start = 0.8f,
                            stop = 1f,
                            fraction = (1f - pageOffset.coerceIn(0f, 1f))
                        )
                    },
                shape = RoundedCornerShape(32.dp)
            ) {
                MovieImage(images[page])
            }
        }

        MovieDetails()
        SuggestTag()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
    HomeScreen(NavHostController(LocalContext.current))
}