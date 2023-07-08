/*
 * Created by Mohamed Naser on 7/8/23, 6:06 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 6:06 PM
 *
 */

package com.example.cinematickets.screens.tickets.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R

@Composable
fun ImageHeader() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        painter = painterResource(id = R.drawable.cinema),
        contentDescription = null,
    )
}