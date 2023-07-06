/*
 * Created by Mohamed Naser on 7/6/23, 10:43 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/6/23, 10:43 PM
 *
 */

package com.example.cinematickets.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.ui.theme.Orange

@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    drawableResId: Int,
    contentDescription: String? = null,
    text: String,
    iconSize: Dp = 24.dp,
    textSize: TextUnit = 12.sp,
    textColor: Color = Color.Gray,
    tint: Color = Orange
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val painter = painterResource(drawableResId)
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.size(iconSize),
            tint = tint
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = textSize,
            color = textColor
        )
    }

}

