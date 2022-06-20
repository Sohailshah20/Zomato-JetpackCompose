package com.example.zomatoclone.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.zomatoclone.navigation.BottomNavGraph
import com.example.zomatoclone.navigation.Screens
import com.example.zomatoclone.ui.theme.ZomatoCloneTheme

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        backgroundColor = Color.White
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController : NavHostController){
    val screens = listOf(
        Screens.Home,
        Screens.Dining,
        Screens.Offers,
        Screens.Money,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Color.White
    ) {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen : Screens,
    currentDestination : NavDestination?,
    navController: NavHostController
){
    val isSelected = currentDestination?.hierarchy?.any{
        it.route == screen.route
    } ==  true

    BottomNavigationItem(
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
            },
        label = {
            Text(
                text = screen.title,
                style = MaterialTheme.typography.overline,
                color = if (isSelected) ZomatoCloneTheme.colors.brandTextBlack else ZomatoCloneTheme.colors.brandTextGrey
            )
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = null)
        },
        selectedContentColor = ZomatoCloneTheme.colors.brand,
        unselectedContentColor = ZomatoCloneTheme.colors.brandTextGrey
    )
}