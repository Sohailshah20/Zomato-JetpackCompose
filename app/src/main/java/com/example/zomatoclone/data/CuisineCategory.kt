package com.example.zomatoclone.data

import androidx.compose.ui.graphics.painter.Painter
import com.example.zomatoclone.R

data class CuisineCategory(
    val categoryName: String,
    val image: Int = R.drawable.biryani_picture
)

val cuisineCategoryList = listOf<String>(
    "Home Style",
    "Biryani",
    "Pizza",
    "Chicken",
    "Manchurian",
    "Dosa",
    "Healthy",
    "Shake",
    "Cake",
    "Burger",
    "Paratha",
    "Chaat",
    "Ice Cream",
    "Dal",
    "Noodles",
    "Idli",
)
//val cuisineCategoryList = listOf<CuisineCategory>(
//    CuisineCategory("Home Style"),
//    CuisineCategory("Biryani"),
//    CuisineCategory("Pizza"),
//    CuisineCategory("Chicken"),
//    CuisineCategory("Manchurian"),
//    CuisineCategory("Dosa"),
//    CuisineCategory("Healthy"),
//    CuisineCategory("Shake"),
//    CuisineCategory("Cake"),
//    CuisineCategory("Burger"),
//    CuisineCategory("Paratha"),
//    CuisineCategory("Chaat"),
//    CuisineCategory("Ice Cream"),
//    CuisineCategory("Dal"),
//    CuisineCategory("Noodles"),
//    CuisineCategory("Idli"),
//)