package com.example.zomatoclone.presentation.homescreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.zomatoclone.data.dummyLargeRestaurants
import com.example.zomatoclone.data.dummySmallRestaurant

class HomeScreenViewModel : ViewModel() {

    val horizontalRowState = mutableStateOf(dummySmallRestaurant)

    val verticalRowState = mutableStateOf(dummyLargeRestaurants)

    fun toggleIsSaved(id : Int){
        val restaurants = horizontalRowState.value.toMutableList()
        val itemIndex = restaurants.indexOfFirst { it.id == id }
        val item = restaurants[itemIndex]
        restaurants[itemIndex] = item.copy(isSaved = !item.isSaved)
        horizontalRowState.value = restaurants
    }

}