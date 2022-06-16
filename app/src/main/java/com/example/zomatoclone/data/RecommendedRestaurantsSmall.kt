package com.example.zomatoclone.data

import com.example.zomatoclone.R

data class RecommendedRestaurantsSmall(
    val id : Int,
    val image : Int,
    val isVeg : Boolean,
    val isPromoted : Boolean,
    val isSaved : Boolean = false,
    val restaurantName : String,
    val restaurantRating : Double,
    val time : Int,
    val distance : Int,
    val perHeadPrice : Int,
    val discountAvailable : Boolean,
    val discountPercentage : Int? = null,
    val discountUpTo : Int? = null
)

val dummySmallRestaurant = listOf(
    RecommendedRestaurantsSmall(
            id = 1,
            image = R.drawable.biryani_picture,
            isVeg = false,
            isPromoted = false,
            isSaved = false,
            restaurantName = "Paradise",
            restaurantRating = 4.4,
            time = 40,
            distance = 5,
            perHeadPrice = 300,
            discountAvailable = true,
            discountPercentage = 30,
            discountUpTo = 80
        ),
    RecommendedRestaurantsSmall(
            id = 2,
            image = R.drawable.biryani_picture,
            isVeg = true,
            isPromoted = false,
            isSaved = true,
            restaurantName = "Chef King",
            restaurantRating = 4.1,
            time = 50,
            distance = 8,
            perHeadPrice = 250,
            discountAvailable = true,
            discountPercentage = 20,
            discountUpTo = 100
        ),
    RecommendedRestaurantsSmall(
            id = 3,
            image = R.drawable.biryani_picture,
            isVeg = false,
            isPromoted = true,
            isSaved = true,
            restaurantName = "Azeebo Arabian Mandi",
            restaurantRating = 4.5,
            time = 40,
            distance = 12,
            perHeadPrice = 350,
            discountAvailable = true,
            discountPercentage = 20,
            discountUpTo = 100
        ),

    RecommendedRestaurantsSmall(
            id = 4,
            image = R.drawable.biryani_picture,
            isVeg = true,
            isPromoted = false,
            isSaved = true,
            restaurantName = "Punjabi Dhaba",
            restaurantRating = 3.9,
            time = 20,
            distance = 4,
            perHeadPrice = 200,
            discountAvailable = false,
        ),

    RecommendedRestaurantsSmall(
            id = 5,
            image = R.drawable.biryani_picture,
            isVeg = false,
            isPromoted = true,
            isSaved = false,
            restaurantName = "Mujtaba Grills",
            restaurantRating = 4.0,
            time = 30,
            distance = 7,
            perHeadPrice = 150,
            discountAvailable = true,
            discountPercentage = 30,
            discountUpTo = 100
        ),
    )
