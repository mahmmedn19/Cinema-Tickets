/*
 * Created by Mohamed Naser on 7/8/23, 10:43 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 10:43 AM
 *
 */

package com.example.cinematickets.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.ui.theme.Blue
import com.example.cinematickets.ui.theme.Brown
import com.example.cinematickets.ui.theme.White70
import com.example.cinematickets.utils.daysOfWeek

@Composable
fun ListOfDaysOfWeek() {
    var selectedDayIndex by remember { mutableStateOf(0) }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        itemsIndexed(daysOfWeek) { index, day ->
            val isSelected = selectedDayIndex == index

            Column(
                modifier = Modifier
                    .background(
                        color = if (isSelected) Brown else Color.Transparent,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(border = BorderStroke(1.dp, color = if (isSelected) Color.Transparent else Brown),
                        shape = RoundedCornerShape(16.dp) )
                    .clickable { selectedDayIndex = index }
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomText(
                    text = day.number.toString(),
                    fontSize = 14.sp,
                    color = if (isSelected) Color.White else Blue
                )
                CustomText(
                    text = day.text,
                    fontSize = 8.sp,
                    color = White70
                )
            }
        }
    }
}
