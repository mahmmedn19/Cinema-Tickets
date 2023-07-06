/*
 * Created by Mohamed Naser on 7/6/23, 1:05 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/6/23, 1:05 PM
 *
 */

package com.example.cinematickets.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = FontFamily.SansSerif,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        modifier = modifier,
        fontFamily = fontFamily,
        fontSize = fontSize,
        color = color,
        textAlign = textAlign,
        maxLines = 3
    )
}

@Composable
fun RatingText(rating: String) {
    Text(
        text = rating,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(end = 4.dp)
    )
}

@Composable
fun IMDbText(imdbText: String) {
    Text(
        text = imdbText,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Gray
    )
}

@Composable
fun RatingIMDb() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RatingText("6.8/10")
            IMDbText("IMDb")
        }
    }
}
