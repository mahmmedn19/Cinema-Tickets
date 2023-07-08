/*
 * Created by Mohamed Naser on 7/8/23, 12:49 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 12:49 PM
 *
 */

package com.example.cinematickets.screens.tickets

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
private const val ROUTE = "TicketsRoute"

fun NavGraphBuilder.ticketRoute(navController: NavHostController) {
    composable(ROUTE) { TicketsScreen(navController) }
}

fun navigateToTicketsScreen(navHostController: NavHostController) {
    navHostController.navigate(ROUTE){
        slideInHorizontally(initialOffsetX = { it })
        slideOutHorizontally(targetOffsetX = { -it })
        slideInHorizontally(initialOffsetX = { -it })
        slideOutHorizontally(targetOffsetX = { it })
    }
}