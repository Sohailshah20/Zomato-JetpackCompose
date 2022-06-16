package com.example.zomatoclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.zomatoclone.presentation.AppBar
import com.example.zomatoclone.presentation.HomeScreen
import com.example.zomatoclone.presentation.component.LargeRestaurantCard
import com.example.zomatoclone.presentation.component.MySearchBar
import com.example.zomatoclone.presentation.component.OrderAgainRestaurantCard
import com.example.zomatoclone.presentation.component.SmallRestaurantCard
import com.example.zomatoclone.ui.theme.ZomatoCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZomatoCloneTheme {
                HomeScreen()
//                Column(
//                    modifier = Modifier
//                        .verticalScroll(
//                            enabled = true,
//                            state = rememberScrollState()
//                        )
//                        .fillMaxSize()
//                        .background(Color.White)
//                        .padding(10.dp)
//                ) {
//                    AppBar()
//                    MySearchBar(
//                        text = "",
//                        onCloseClicked = {},
//                        onMicClicked = {},
//                        onSearchClicked = {},
//                        onTextChange = {},
//                        placeHolder = stringResource(id = R.string.search_bar_placeholder)
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    SmallRestaurantCard()
//                    Spacer(modifier = Modifier.height(32.dp))
//                    LargeRestaurantCard()
//                    Spacer(modifier = Modifier.height(32.dp))
//                    OrderAgainRestaurantCard()
//                }
            }
        }
    }
}
