/*
 * Created by Mohamed Naser on 7/8/23, 12:48 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 12:48 PM
 *
 */

package com.example.cinematickets.screens.home

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.cinematickets.composable.navigation.BottomNavScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.homeRoute(navController: NavHostController) {
    composable(BottomNavScreen.Home.route) { HomeScreen(navController) }
}

fun navigateToHomeScreen(navHostController: NavHostController) {
    navHostController.navigate(BottomNavScreen.Home.route) {
        slideInHorizontally(initialOffsetX = { it })
        slideOutHorizontally(targetOffsetX = { -it })
        slideInHorizontally(initialOffsetX = { -it })
        slideOutHorizontally(targetOffsetX = { it })
    }
}