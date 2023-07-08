/*
 * Created by Mohamed Naser on 7/8/23, 12:43 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 12:43 PM
 *
 */

package com.example.cinematickets.composable.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.cinematickets.screens.book.bookRoute
import com.example.cinematickets.screens.home.homeRoute
import com.example.cinematickets.screens.tickets.ticketRoute

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavScreen.Home.route) {
        homeRoute(navController)
        bookRoute(navController)
        ticketRoute(navController)
    }
}