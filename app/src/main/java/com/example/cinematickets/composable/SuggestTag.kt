/*
 * Created by Mohamed Naser on 7/3/23, 6:47 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/3/23, 6:47 PM
 *
 */

package com.example.cinematickets.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun SuggestTag(){
    Row {
        CustomBox(
            backgroundColor = Color.White,
            shape = CircleShape
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp),
                text = "Fantasy",
            )
        }
        HorizontalSpacer(width = 4.dp)
        CustomBox(
            shape = CircleShape
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp),
                text = "Fantasy",
            )
        }
    }
}