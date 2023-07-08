/*
 * Created by Mohamed Naser on 7/8/23, 1:02 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 1:02 PM
 *
 */

package com.example.cinematickets.screens.book.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.IMDbText
import com.example.cinematickets.composable.RatingText

@Composable
fun RatingRow() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

        Row {
            RatingColumn(
                stringResource(R.string.rating_number),
                stringResource(R.string.rating_fixed_nuber),
                stringResource(R.string.imdb)
            )
            HorizontalSpacer(width = 32.dp)
            RatingColumn(
                stringResource(R.string.rating_value),"",
                stringResource(R.string.movie_name)
            )
            HorizontalSpacer(width = 32.dp)
            RatingColumn(
                stringResource(R.string.rating_number),
                stringResource(R.string.rating_fixed_nuber),
                stringResource(R.string.ign)
            )
        }
    }
}
@Composable
fun RatingColumn(ratingNumber: String, fixedNumber: String,type:String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RatingText(ratingNumber)
            IMDbText(fixedNumber)
        }
        IMDbText(type)
    }

}