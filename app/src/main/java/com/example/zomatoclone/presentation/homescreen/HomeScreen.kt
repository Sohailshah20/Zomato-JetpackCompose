@file:OptIn(ExperimentalFoundationApi::class)

package com.example.zomatoclone.presentation

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zomatoclone.data.CuisineCategory
import com.example.zomatoclone.data.RecommendedRestaurantsSmall
import com.example.zomatoclone.data.cuisineCategoryList
import com.example.zomatoclone.presentation.component.*
import com.example.zomatoclone.presentation.homescreen.HomeScreenViewModel
import com.example.zomatoclone.ui.theme.ZomatoCloneTheme
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import kotlin.math.abs


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
        .verticalScroll(
            enabled = true,
            state = rememberScrollState()
        )

){
    val viewModel : HomeScreenViewModel = viewModel()

    val isSavedState = remember { mutableStateOf(false)}
    val saveIcon = if (isSavedState.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder

    Scaffold(
        topBar = {
            AppBar()
        },
        backgroundColor = Color.White
    ) {
        var showMore by remember { mutableStateOf(false) }

        Column(
            modifier = modifier
        ) {
            MySearchBar(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "",
                onTextChange = {},
                placeHolder = "Search Here",
                onCloseClicked = { /*TODO*/ },
                onSearchClicked = {},
                onMicClicked = {}
            )
            Spacer(modifier = Modifier.height(10.dp))
            SearchChips()
            OrderAgainBlock()
            CuisineTypeGrid(
                showMore = showMore,
                onClickedPressed = {
                    showMore = !showMore
                }
            )
            RecommendedForYouRow()
        }
    }
}

@Composable
fun SearchChips(){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        val items = getAllCategories()
        items(items = items){ name ->
            MyChip(
                name = name.category,
            ) {
            }
        }
    }
}

@Composable
fun OrderAgainBlock(){
    Text(
        modifier = Modifier.padding(10.dp),
        text = "Order Again",
        style = MaterialTheme.typography.body2
    )

    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .horizontalScroll(
                enabled = true,
                state = rememberScrollState()
            )
    ) {
        OrderAgainRestaurantCard()
        Spacer(modifier = Modifier.width(10.dp))
        OrderAgainRestaurantCard()
    }
}


@Preview
@Composable
fun AppBar(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(60.dp)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(0.6f)
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = ZomatoCloneTheme.colors.brand,
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Home",
                    style = MaterialTheme.typography.body1,
                    color = ZomatoCloneTheme.colors.brandTextBlack,

                    )
                Text(
                    text = "Plot no 10, 2nd, SAIL Colony, Bowenpally",
                    fontSize = MaterialTheme.typography.overline.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    color = ZomatoCloneTheme.colors.brandTextGrey,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                    )
            }
        }
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            imageVector = Icons.Outlined.Comment,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .weight(0.1f)
                .size(24.dp)
        )
        Icon(
            imageVector = Icons.Outlined.Comment,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .weight(0.1f)
                .size(24.dp)
        )


    }
}

@Composable
fun CuisineTypeGrid(
    modifier: Modifier = Modifier,
    showMore : Boolean = false,
    onClickedPressed : () -> Unit

){
    val items = if (showMore) 1 else 9
    val showText = if (showMore) "see less" else "see more"
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        modifier = Modifier.padding(10.dp),
        text = "Eat what makes you happy",
        style = MaterialTheme.typography.body2
    )
    FlowRow(
        modifier =Modifier
            .padding(horizontal = 10.dp)
                ,
        mainAxisSize = SizeMode.Expand,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,

    ) {
        for(category in 0..cuisineCategoryList.size - items){
            RoundImageWithText(cuisineCategory = cuisineCategoryList[category])
        }
    }
//    LazyVerticalGrid(
//        cells = GridCells.Fixed(4),
//        content = {
//            items(items){ index ->
//                RoundImageWithText()
//            }
//        },
//    )
    Spacer(modifier = Modifier.height(20.dp))
    MyOutlinedButton(
        modifier = Modifier.padding(horizontal = 10.dp),
        text = showText,
        onClickPressed = onClickedPressed,
        showMore = showMore
    )

}

@Composable
fun RecommendedForYouRow(
    modifier: Modifier = Modifier,
    recommendedRestaurants : List<RecommendedRestaurantsSmall>,
    icon : ImageVector
){
    Row(
        modifier = Modifier
            .padding(10.dp)
            ,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Recommended for you",
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "see all",
            style = MaterialTheme.typography.overline,
            color = ZomatoCloneTheme.colors.brand,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(modifier = modifier){
            items(items = recommendedRestaurants){ restataurant ->
                SmallRestaurantCard(
                    discountPercentage = restataurant.discountPercentage.toString(),
                    discountUpTo = restataurant.discountUpTo.toString(),
                    perHeadPrice = restataurant.perHeadPrice,
                    time = restataurant.time,
                    distance = restataurant.distance,
                    restaurantRating = restataurant.restaurantRating,
                    restaurantName = restataurant.restaurantName,
                    image = restataurant.image,
                    isVeg = restataurant.isVeg,
                    isPromoted = restataurant.isPromoted,
                    isSaved = restataurant.isPromoted,
                    discountAvailable = restataurant.discountAvailable,
                    icon = icon
                )
            }
        }
    }
}

@Composable
fun rememberNestedScrollConnection(onOffsetChanged:(Float)->Unit, appBarHeight:Float) = remember {
    var currentHeight = appBarHeight
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            currentHeight = (currentHeight+available.y).coerceIn(minimumValue = 0f, maximumValue = appBarHeight)
            return if(abs(currentHeight) == appBarHeight || abs(currentHeight) == 0f){
                super.onPreScroll(available, source)
            }else{
                onOffsetChanged(currentHeight)
                available
            }
        }

        override suspend fun onPreFling(available: Velocity): Velocity {
            if(available.y<0){
                onOffsetChanged(0f)
            }else{
                onOffsetChanged(appBarHeight)
            }
            return super.onPreFling(available)
        }
    }
}
