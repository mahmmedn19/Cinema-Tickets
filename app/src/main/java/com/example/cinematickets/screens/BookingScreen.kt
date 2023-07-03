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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinematickets.R
import com.example.cinematickets.composable.CustomIcon
import com.example.cinematickets.composable.HorizontalSpacer
import com.example.cinematickets.composable.SuggestTag
import com.example.cinematickets.composable.VerticalSpacer

@Composable
fun BookingScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val textWithIcon = createRef()
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        }
        Card(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp),
            shape = CircleShape
        ) {
            Box(
                modifier = Modifier.padding(
                    vertical = 4.dp, horizontal = 4.dp
                )
            ) {
                CustomIcon(
                    imageVector = Icons.Default.PlayCircle
                )
            }
        }

        Card(
            modifier = Modifier
                .constrainAs(textWithIcon) {
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(parent.top, 16.dp)
                }, shape = CircleShape
        ) {
            Box(
                modifier = Modifier.padding(
                    vertical = 4.dp, horizontal = 8.dp
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomIcon(imageVector = Icons.Default.PlayCircle)
                    HorizontalSpacer(width = 4.dp)
                    Text(
                        text = "2h 23m",
                    )
                }
            }
        }
        val guideline = createGuidelineFromTop(300.dp)
        val cardContainer = createRef()
        Card(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(cardContainer) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(guideline)
                }, shape = RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp)
        )
        {
            VerticalSpacer(height = 32.dp)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Fantastic Fantastic : the  ghgf dfhfd Fantastic Fantastic ",
                    modifier = Modifier
                        .width(200.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
                VerticalSpacer(height = 32.dp)
                SuggestTag()
            }
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreenBook() {
    BookingScreen()
}