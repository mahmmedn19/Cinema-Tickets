/*
 * Created by Mohamed Naser on 7/2/23, 7:12 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/2/23, 7:12 AM
 *
 */

package com.example.cinematickets.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.R
import com.example.cinematickets.composable.CustomBox
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.ResizableImage
import com.example.cinematickets.composable.SuggestTag
import com.example.cinematickets.composable.TextChip
import com.example.cinematickets.composable.VerticalSpacer
import kotlin.random.Random

@Composable
fun HomeScreen() {
    val randomImageUrls = generateRandomImageUrls(10) // Generate 10 random image URLs
    val selectedChipIndex = remember { mutableStateOf(0) }
    // State to keep track of the currently visible item index
    var visibleItemIndex by remember { mutableStateOf(0) }

    // Scroll state for LazyRow
    val listState = rememberLazyListState()

    // Obtain the index of the currently visible item based on its position in the LazyRow
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .collect { visibleItemIndex = it }
    }

    // Fetch the currently visible image URL
    val currentImageUrl = randomImageUrls.getOrNull(visibleItemIndex)

    // Create a painter for the current image URL
    val painter = rememberAsyncImagePainter(model = currentImageUrl)

    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .blur(radius = 10.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
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
                selectedColor = Color.DarkGray,
                onChecked = { selectedChipIndex.value = 0 }
            )
            TextChip(
                isSelected = selectedChipIndex.value == 1,
                text = "Coming Soon",
                selectedColor = Color.DarkGray,
                onChecked = { selectedChipIndex.value = 1 }
            )
        }
        VerticalSpacer(height = 32.dp)
        LazyRow(
            state = listState,
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(randomImageUrls) { index, imageUrl ->
                ResizableImage(
                    painter = rememberAsyncImagePainter(imageUrl),
                    size = 300,
                    modifier = Modifier
                        .height(400.dp)
                        .padding(end = 16.dp)
                )
            }
            if (currentImageUrl != null) {
                // BlurredImage(painter = painter)
            }
        }
        VerticalSpacer(height = 32.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIcon(imageVector = Icons.Default.PlayCircle)
            HorizontalSpacer(width = 4.dp)
            Text(
                text = "2h 23m",
            )
        }
        VerticalSpacer(height = 16.dp)
        Text(
            text = "Fantastic Fantastic : the  ghgf dfhfd Fantastic Fantastic ",
            modifier = Modifier
                .width(200.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
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

fun generateRandomImageUrls(count: Int): List<String> {
    val baseUrl = "https://picsum.photos"
    /*
        val imageCategories =
            listOf("animals", "nature", "people", "architecture") // Add more categories if needed
        val imageSize = 200 // Specify the desired image size
    */
    val imageUrls = mutableListOf<String>()
    val random = Random.Default

    repeat(count) {
        val width = random.nextInt(800) + 200 // Generate random width between 200 and 1000
        val height = random.nextInt(800) + 200 // Generate random height between 200 and 1000
        /* val categoryIndex = random.nextInt(imageCategories.size)
         val category = imageCategories[categoryIndex]*/
        val imageUrl = "$baseUrl/$width/$height" // Build the image URL
        imageUrls.add(imageUrl)
    }
    return imageUrls
}
