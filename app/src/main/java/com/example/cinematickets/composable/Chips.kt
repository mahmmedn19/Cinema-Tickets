/*
 * Created by Mohamed Naser on 7/2/23, 3:52 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/2/23, 3:52 PM
 *
 */

package com.example.cinematickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextChip(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = Color.DarkGray
) {
    val chipColor = if (isSelected) selectedColor else Color.Transparent
    val chipTextColor = if (isSelected) Color.White else Color.Unspecified

    Row(
        modifier = Modifier
            .padding(4.dp)
            .clip(ShapeDefaults.Medium)
            .background(color = chipColor)
            .clickable { onChecked(!isSelected) }
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else Color.LightGray,
                shape = ShapeDefaults.Medium
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = chipTextColor
        )
    }
}