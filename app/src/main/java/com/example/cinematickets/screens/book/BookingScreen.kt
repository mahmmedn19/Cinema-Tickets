/*
 * Created by Mohamed Naser on 7/8/23, 11:27 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 11:27 AM
 *
 */

package com.example.cinematickets.screens.book

import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.cinematickets.R
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.CustomText
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.IconButton
import com.example.cinematickets.composable.MyCard
import com.example.cinematickets.composable.MyListRounded
import com.example.cinematickets.composable.SuggestTag
import com.example.cinematickets.composable.VerticalSpacer
import com.example.cinematickets.screens.book.composable.RatingRow
import com.example.cinematickets.screens.tickets.navigateToTicketsScreen
import com.example.cinematickets.ui.theme.White70
import com.example.cinematickets.utils.ListOfImages
import com.example.cinematickets.utils.Utils.generateRandomImageUrls

@Composable
fun BookingScreen(navController: NavHostController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val textWithIcon = createRef()
        val cardContainer = createRef()
        val guideline = createGuidelineFromTop(300.dp)

        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.movies_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        }
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

        MyCard(
            modifier = Modifier
                .constrainAs(textWithIcon) {
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(parent.top, 16.dp)
                },
            elevation = 0,
            contentColor = Color.White,
            containerColor = White70
        ) {
            Row(
                modifier = Modifier.padding(
                    vertical = 4.dp, horizontal = 8.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIcon(
                    drawableResId = R.drawable.ic_clock_circle,
                )
                HorizontalSpacer(width = 4.dp)
                Text(
                    text = "2h 23m",
                )
            }
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
            VerticalSpacer(height = 16.dp)
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RatingRow()
                VerticalSpacer(height = 16.dp)
                CustomText(
                    text = stringResource(R.string.movie_details),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    fontSize = 20.sp,
                )
                VerticalSpacer(height = 8.dp)
                SuggestTag()
                MyListRounded(ListOfImages.listOfImages())
                CustomText(
                    text = stringResource(R.string.movie_description),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    fontSize = 16.sp,
                )
                VerticalSpacer(height = 16.dp)
                IconButton(
                    onClick = { navigateToTicketsScreen(navController) },
                    drawableResId = R.drawable.ic_booking,
                    text = "Booking",
                    textColor = Color.White,
                    tint = Color.White
                )
            }
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreenBook() {
    BookingScreen(NavHostController(LocalContext.current))
}