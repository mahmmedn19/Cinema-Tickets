/*
 * Created by Mohamed Naser on 7/8/23, 6:10 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 6:10 PM
 *
 */

package com.example.cinematickets.screens.tickets


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import com.example.cinematickets.ui.theme.Orange


sealed class SeatState(val seatColor: Color) {
    object Available : SeatState(Color.White)
    object Taken : SeatState(Gray)
    object Selected : SeatState(Orange)

    fun nextState(): SeatState {
        return when (this) {
            Available -> Selected
            Selected -> Taken
            Taken -> Available
        }
    }
}