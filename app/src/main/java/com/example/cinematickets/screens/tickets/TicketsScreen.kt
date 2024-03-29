/*
 * Created by Mohamed Naser on 7/8/23, 11:27 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 11:27 AM
 *
 */

package com.example.cinematickets.screens.tickets


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.cinematickets.R
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.CustomText
import com.example.cinematickets.composable.IconButton
import com.example.cinematickets.composable.ListOfDaysOfWeek
import com.example.cinematickets.composable.ListOfTimes
import com.example.cinematickets.composable.MyCard
import com.example.cinematickets.composable.Seats
import com.example.cinematickets.composable.VerticalSpacer
import com.example.cinematickets.screens.tickets.composable.IconText
import com.example.cinematickets.screens.tickets.composable.ImageHeader
import com.example.cinematickets.ui.theme.White70

@Composable
fun TicketsScreen(navController: NavHostController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val textWithIcon = createRef()
        val cardContainer = createRef()
        val seats = createRef()
        val guideline = createGuidelineFromTop(450.dp)

        ImageHeader()
        Seats(modifier =  Modifier.fillMaxWidth()
            .padding(16.dp).constrainAs(seats){
                bottom.linkTo(textWithIcon.top)
            })
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
                .padding(bottom = 32.dp)
                .fillMaxWidth()
                .constrainAs(textWithIcon) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(guideline)
                },
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconText()
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
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            }
            VerticalSpacer(height = 16.dp)
            ListOfDaysOfWeek()
            ListOfTimes()
            VerticalSpacer(height = 16.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Column {
                    CustomText(text = "$100.00", fontSize = 26.sp)
                    CustomText(text = "4 tickets", color = Color.Gray)
                }
                IconButton(
                    onClick = { },
                    drawableResId = R.drawable.ic_booking,
                    text = stringResource(R.string.buy_tickets),
                    textColor = Color.White,
                    tint = Color.White
                )
            }
        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTicketsScreen() {
    TicketsScreen(NavHostController(LocalContext.current))
}