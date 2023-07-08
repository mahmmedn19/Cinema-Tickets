/*
 * Created by Mohamed Naser on 7/8/23, 12:57 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 11:05 AM
 *
 */

package com.example.cinematickets.composable.navigation

import com.example.cinematickets.R

sealed class BottomNavScreen(val route: String, val title: String, val icon: Int) {
    object Home : BottomNavScreen("home", "Home", R.drawable.ic_home_play)
    object Search : BottomNavScreen("search", "Search", R.drawable.ic_search)
    object Tickets : BottomNavScreen("tickets", "Tickets", R.drawable.ic_ticket)
    object Profile : BottomNavScreen("profile", "Profile", R.drawable.ic_user_rounded)
}