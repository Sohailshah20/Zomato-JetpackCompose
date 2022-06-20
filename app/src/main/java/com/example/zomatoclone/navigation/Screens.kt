package com.example.zomatoclone.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.zomatoclone.R

sealed class Screens (
    val route : String,
    val title : String,
    val icon : ImageVector
){
        object Home : Screens(
            route = "home",
            title = "Delivery",
            icon = Icons.Default.Moped
        )
    object Dining : Screens(
        route = "dining",
        title = "Dining",
        icon = Icons.Default.Dining
    )
    object Offers : Screens(
        route = "offers",
        title = "Offers",
        icon = Icons.Default.LocalOffer
    )
    object Money : Screens(
        route = "money",
        title = "Money",
        icon = Icons.Default.AccountBalance
    )
}