/*
 * Created by Mohamed Naser on 7/8/23, 11:29 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 11:29 AM
 *
 */

package com.example.cinematickets.screens.home.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.CustomText
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.VerticalSpacer

@Composable
fun MovieDetails() {
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