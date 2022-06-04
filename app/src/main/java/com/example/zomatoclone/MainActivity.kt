package com.example.zomatoclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.zomatoclone.ui.component.LargeRestaurantCard
import com.example.zomatoclone.ui.component.MySearchBar
import com.example.zomatoclone.ui.component.SmallRestaurantCard
import com.example.zomatoclone.ui.theme.ZomatoCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZomatoCloneTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    MySearchBar(
                        text = "",
                        onCloseClicked = {},
                        onMicClicked = {},
                        onSearchClicked = {},
                        onTextChange = {},
                        placeHolder = stringResource(id = R.string.search_bar_placeholder)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    SmallRestaurantCard()
                    Spacer(modifier = Modifier.height(32.dp))
                    LargeRestaurantCard()
                }
            }
        }
    }
}
