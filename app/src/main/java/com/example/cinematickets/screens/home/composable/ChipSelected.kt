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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.cinematickets.composable.TextChip

@Composable
fun ChipSelected(selectedChipIndex: MutableState<Int>) {
    Row {
        TextChip(
            isSelected = selectedChipIndex.value == 0,
            text = "Now Showing",
            onChecked = { selectedChipIndex.value = 0 }
        )
        TextChip(
            isSelected = selectedChipIndex.value == 1,
            text = "Coming Soon",
            onChecked = { selectedChipIndex.value = 1 }
        )
    }
}