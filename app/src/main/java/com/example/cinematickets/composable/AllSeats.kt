/*
 * Created by Mohamed Naser on 7/8/23, 6:20 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 6:20 PM
 *
 */

package com.example.cinematickets.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Seats(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (column in 0..2) {
            Column(
                modifier = if (column == 1) {
                    Modifier.padding(top = 16.dp)
                } else {
                    Modifier
                },
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (seat in 0..4) {
                    when (column) {
                        0 -> SeatItem(rotateDeg = 10f)
                        1 -> SeatItem()
                        2 -> SeatItem(rotateDeg = -10f)
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 360)
@Composable
fun PreviewSeats() {
    Seats()
}