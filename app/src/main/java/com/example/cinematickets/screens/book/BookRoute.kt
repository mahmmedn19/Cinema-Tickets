/*
 * Created by Mohamed Naser on 7/8/23, 12:48 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 12:48 PM
 *
 */

package com.example.cinematickets.screens.book

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

private const val ROUTE = "BookingRoute"

fun NavGraphBuilder.bookRoute(navController: NavHostController) {
    composable(ROUTE) { BookingScreen(navController) }
}

fun navigateToBookingScreen(navHostController: NavHostController) {
    navHostController.navigate(ROUTE){
        slideInHorizontally(initialOffsetX = { it })
        slideOutHorizontally(targetOffsetX = { -it })
        slideInHorizontally(initialOffsetX = { -it })
        slideOutHorizontally(targetOffsetX = { it })
    }
}