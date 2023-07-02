/*
 * Created by Mohamed Naser on 7/2/23, 7:12 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/2/23, 7:12 AM
 *
 */

package com.example.cinematickets.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.composable.CustomBox
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.ResizableImage
import com.example.cinematickets.composable.TextChip
import com.example.cinematickets.composable.VerticalSpacer

@Composable
fun HomeScreen() {

    val selectedChipIndex = remember { mutableStateOf(0) }
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
        ResizableImage(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            size = 300
        )
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
            modifier = Modifier.width(200.dp),
            textAlign = TextAlign.Center
        )
        VerticalSpacer(height = 16.dp)
        Row {
            CustomBox(
                backgroundColor = Color.White,
                borderColor = Color.Gray,
                borderWidth = 1.dp,
                shape = CircleShape
            ) {
                Text(
                    text = "Fantasy",
                )
            }
            HorizontalSpacer(width = 8.dp)
            CustomBox(
                backgroundColor = Color.White,
                borderColor = Color.Gray,
                borderWidth = 1.dp,
                shape = CircleShape
            ) {
                Text(
                    text = "Fantasy",
                )
            }
        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
    HomeScreen()
}


