/*
 * Created by Mohamed Naser on 7/8/23, 6:11 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 6:11 PM
 *
 */

package com.example.cinematickets.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.screens.tickets.SeatState
import com.example.cinematickets.R

@Composable
fun SeatItem(
    rotateDeg: Float = 0f,
    seatState: Pair<SeatState, SeatState> = Pair(SeatState.Available, SeatState.Available),
) {

    var leftSeatState by remember { mutableStateOf(seatState.first) }
    var rightSeatState by remember { mutableStateOf(seatState.second) }

    val leftSeatColor by animateColorAsState(getSeatColor(leftSeatState))
    val rightSeatColor by animateColorAsState(getSeatColor(rightSeatState))

    Box(
        modifier = Modifier.rotate(rotateDeg),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
            painter = painterResource(id = R.drawable.seat_container),
            contentDescription = "container",
            tint = Gray
        )
        Row(
            Modifier.padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Icon(
                modifier = Modifier.clickable { leftSeatState = leftSeatState.nextState() },
                painter = painterResource(id = R.drawable.ic_seat),
                contentDescription = "Seat",
                tint = leftSeatColor
            )
            Icon(
                modifier = Modifier.clickable { rightSeatState = rightSeatState.nextState() },
                painter = painterResource(id = R.drawable.ic_seat),
                contentDescription = "Seat",
                tint = rightSeatColor
            )
        }
    }
}


private fun getSeatColor(seat: SeatState): Color {
    return when (seat) {
        SeatState.Available -> SeatState.Available.seatColor
        SeatState.Taken -> SeatState.Taken.seatColor
        SeatState.Selected -> SeatState.Selected.seatColor
    }
}


@Preview
@Composable
fun PreviewSeatItem() {
//    SeatItem(1, 1, 1, onClickLeftSeat = {}, onClickRightSeat = {})
}