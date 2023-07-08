/*
 * Created by Mohamed Naser on 7/8/23, 10:43 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/8/23, 10:43 AM
 *
 */

package com.example.cinematickets.utils

data class Day(val number: Int, val text: String)

val daysOfWeek = listOf(
    Day(15, "Sun"),
    Day(16, "Mon"),
    Day(17, "Tue"),
    Day(18, "Wed"),
    Day(19, "Thu"),
    Day(20, "Fri"),
    Day(21, "Sat")
)
