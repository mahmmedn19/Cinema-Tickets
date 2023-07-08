/*
 * Created by Mohamed Naser on 7/8/23, 6:08 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 6:08 PM
 *
 */

package com.example.cinematickets.screens.tickets.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.composable.IconWithText
@Composable
fun IconText(){
    IconWithText(
        drawableResId = R.drawable.rounded,
        text = stringResource(R.string.available),
        tint = Color.White,
        iconSize = 14.dp
    )
    IconWithText(
        drawableResId = R.drawable.rounded,
        text = stringResource(R.string.taken),
        tint = Color.Gray,
        iconSize = 14.dp
    )
    IconWithText(
        drawableResId = R.drawable.rounded,
        text = stringResource(R.string.selected),
        iconSize = 14.dp
    )
}