/*
 * Created by Mohamed Naser on 7/8/23, 9:17 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 *
 * Last modified: 7/6/23, 7:38 PM
 *
 */

package com.example.cinematickets.utils

import kotlin.random.Random

object Utils {
    fun generateRandomImageUrls(count: Int): List<String> {
        val baseUrl = "https://picsum.photos"
        /*
            val imageCategories =
                listOf("animals", "nature", "people", "architecture") // Add more categories if needed
            val imageSize = 200 // Specify the desired image size
        */
        val imageUrls = mutableListOf<String>()
        val random = Random.Default

        repeat(count) {
            val width = random.nextInt(800) + 200 // Generate random width between 200 and 1000
            val height = random.nextInt(800) + 200 // Generate random height between 200 and 1000
            /* val categoryIndex = random.nextInt(imageCategories.size)
             val category = imageCategories[categoryIndex]*/
            val imageUrl = "$baseUrl/$width/$height" // Build the image URL
            imageUrls.add(imageUrl)
        }
        return imageUrls
    }
}