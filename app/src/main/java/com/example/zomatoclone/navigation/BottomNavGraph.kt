package com.example.zomatoclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zomatoclone.presentation.DiningScreen
import com.example.zomatoclone.presentation.HomeScreen
import com.example.zomatoclone.presentation.MoneyScreen
import com.example.zomatoclone.presentation.OffersScreen

@Composable
fun BottomNavGraph(navController : NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ){
        composable(route = Screens.Home.route){
            HomeScreen()
        }
        composable(route = Screens.Dining.route){
            DiningScreen()
        }
        composable(route = Screens.Offers.route){
            OffersScreen()
        }
        composable(route = Screens.Money.route){
            MoneyScreen()
        }
    }
}