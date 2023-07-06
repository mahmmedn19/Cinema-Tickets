/*
 * Created by Mohamed Naser on 7/2/23, 7:12 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/2/23, 7:12 AM
 *
 */

package com.example.cinematickets.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinematickets.R
import com.example.cinematickets.Utils.generateRandomImageUrls
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.CustomText
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.IMDbText
import com.example.cinematickets.composable.IconButton
import com.example.cinematickets.composable.IconWithText
import com.example.cinematickets.composable.MyCard
import com.example.cinematickets.composable.MyListRounded
import com.example.cinematickets.composable.RatingText
import com.example.cinematickets.composable.SuggestTag
import com.example.cinematickets.composable.VerticalSpacer
import com.example.cinematickets.ui.theme.White70

@Composable
fun TicketsScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val textWithIcon = createRef()
        val cardContainer = createRef()
        val guideline = createGuidelineFromTop(500.dp)

        MyCard(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp),
            elevation = 0,
            containerColor = White70
        ) {
            CustomIcon(
                modifier = Modifier.padding(
                    vertical = 4.dp, horizontal = 4.dp
                ),
                drawableResId = R.drawable.ic_close_circle
            )
        }
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth() .constrainAs(textWithIcon) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(guideline)
                },
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconWithText(drawableResId = R.drawable.rounded, text = "Available", tint = Color.White)
            IconWithText(drawableResId = R.drawable.rounded, text = "Taken", tint = Color.Gray)
            IconWithText(drawableResId = R.drawable.rounded, text = "Selected")
        }


        Card(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(cardContainer) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(guideline)
                },
            shape = RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        )
        {
                Column {
                }
                IconButton(
                    onClick = { /* Handle button click */ },
                    drawableResId = R.drawable.ic_booking,
                    text = "Booking",
                    textColor = Color.White,
                    tint = Color.White
                )

        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTicketsScreen() {
    TicketsScreen()
}