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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cinematickets.ui.theme.Orange

@Composable
fun TextChip(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
) {
    val chipColor: Color = if (isSelected) Orange else Color.Transparent
    val chipTextColor = if (isSelected) Color.White else Color.White

    Card(
        modifier = Modifier
            .padding(4.dp)
            .clip(CircleShape)
            .clickable { onChecked(!isSelected) }
            .border(
                width = 1.dp,
                color = if (isSelected) Orange else Color.White,
                shape = CircleShape
            ),
        colors = CardDefaults.cardColors(
            contentColor = Color.White,
            containerColor = chipColor
        )
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            text = text,
            color = chipTextColor
        )
    }
}