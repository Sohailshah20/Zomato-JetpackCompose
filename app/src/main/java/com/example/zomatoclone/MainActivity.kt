package com.example.zomatoclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zomatoclone.ui.component.MySearchBar
import com.example.zomatoclone.ui.component.RestaurantCard
import com.example.zomatoclone.ui.component.SaveHeartButton
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
                    RestaurantCard()
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}
