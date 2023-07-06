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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SuggestTag() {
    Row {
        MyCard(
            elevation = 1,
        ) {
            CustomText(
                modifier = Modifier
                    .padding(8.dp),
                text = "Fantasy",
                fontSize = 16.sp,
            )
        }
        HorizontalSpacer(width = 16.dp)
        MyCard(
            elevation = 1,
        ) {
            CustomText(
                modifier = Modifier
                    .padding(8.dp),
                text = "Adventure",
                fontSize = 16.sp,
            )
        }
    }
}
