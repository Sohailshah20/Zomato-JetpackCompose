package com.example.zomatoclone.data

import androidx.compose.ui.graphics.painter.Painter
import com.example.zomatoclone.R

data class CuisineCategory(
    val categoryName: String,
    val image: Int
)
//
//val cuisineCategoryList = listOf<CuisineCategory>(
//    CuisineCategory(
//
//    )
//    "Home Style",
//    "Biryani",
//    "Pizza",
//    "Chicken",
//    "Manchurian",
//    "Dosa",
//    "Healthy",
//    "Shake",
//    "Cake",
//    "Burger",
//    "Paratha",
//    "Chaat",
//    "Ice Cream",
//    "Dal",
//    "Noodles",
//    "Idli",
//)
val cuisineCategoryList = listOf<CuisineCategory>(
    CuisineCategory(
        categoryName = "Home Style",
        image = R.drawable.home_made
    ),
    CuisineCategory(
        categoryName ="Biryani",
        image = R.drawable.biryani
    ),
    CuisineCategory(
        categoryName ="Pizza",
        image = R.drawable.pizza
    ),
    CuisineCategory(
        categoryName ="Chicken",
        image = R.drawable.chicken
    ),
    CuisineCategory(
        categoryName ="Manchurian",
        image = R.drawable.manchurian
    ),
    CuisineCategory(
        categoryName ="Dosa",
        image = R.drawable.dosa
    ),
    CuisineCategory(
        categoryName ="Healthy",
        image = R.drawable.healthy
    ),
    CuisineCategory(
        categoryName ="Shake",
        image = R.drawable.shakes
    ),
    CuisineCategory(
        categoryName ="Cake",
        image = R.drawable.cake
    ),
    CuisineCategory(
        categoryName ="Burger",
        image = R.drawable.burger
    ),
    CuisineCategory(
        categoryName ="Paratha",
        image = R.drawable.paratha
    ),
    CuisineCategory(
        categoryName ="Chaat",
        image = R.drawable.chaat
    ),
    CuisineCategory(
        categoryName ="Ice Cream",
        image = R.drawable.icecream
    ),
    CuisineCategory(
        categoryName ="Dal",
        image = R.drawable.dal
    ),
    CuisineCategory(
        categoryName ="Noodles",
        image = R.drawable.noodles
    ),
    CuisineCategory(
        categoryName ="Shawarma",
        image = R.drawable.shawarma
    ),
)