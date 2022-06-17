package com.example.zomatoclone.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.zomatoclone.R
import com.example.zomatoclone.data.RestaurantsSmallDetails
import com.example.zomatoclone.ui.theme.*

@Composable
fun SmallRestaurantCard(
    modifier : Modifier = Modifier,
    restaurant : RestaurantsSmallDetails,
    onSaveClick : (id : Int) -> Unit
){
    val saveIcon = if (restaurant.isSaved) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder

    Card(
        modifier = modifier
            .height(264.dp)
            .width(165.dp)
                ,
        shape = RoundedCornerShape(16.dp),
        elevation = 10.dp
    ) {
        Box(
            modifier = modifier
                .background(Color.White)

        ) {

           Column{
               Box(
                   modifier = Modifier
                       .height(150.dp)
               ) {
                   AsyncImage(
                       modifier = Modifier
                           .height(150.dp)
                       ,
                       model = restaurant.image,
                       contentDescription = null,
                       contentScale = ContentScale.Crop,
                   )
                   SaveHeartButton(
                       modifier = Modifier
                           .align(Alignment.TopEnd)
                           .padding(vertical = 20.dp, horizontal = 8.dp)
                   ,
                       icon = saveIcon,
                   ){
                       onSaveClick(restaurant.id)
                   }
                   if (restaurant.isVeg) {
                       VegetarianCard(
                           modifier = Modifier
                               .align(Alignment.BottomCenter)
                       )
                   }
                   val bottomPadding : Dp = if (restaurant.isVeg) 30.dp else 8.dp
                   if (restaurant.isPromoted) {
                       PromotedTag(
                           modifier = Modifier
                               .align(Alignment.BottomEnd)
                               .padding(bottom = bottomPadding, end = 8.dp)
                       )
                   }

               }

               Row(
                   modifier = modifier
                       .fillMaxWidth()
                       .height(85.dp)
               ) {
                   Column(
                       modifier = modifier
                           .fillMaxHeight()
                           .weight(3f)
                           .padding(8.dp)
                   ) {
                        Text(
                            text = restaurant.restaurantName,
                            fontSize = MaterialTheme.typography.overline.fontSize,
                            fontWeight = FontWeight.Bold,
                            color = ZomatoCloneTheme.colors.brandTextBlack,
                            lineHeight = 15.sp
                        )
                       Spacer(modifier = Modifier.height(6.dp))
                       RestaurantDistance(
                           time = restaurant.time,
                           distance = restaurant.distance
                       )
                       Spacer(modifier = Modifier.height(1.dp))
                       RestaurantPrice(perHeadPrice = restaurant.perHeadPrice)
                   }
                   Column(
                       modifier = modifier
                           .fillMaxHeight()
                           .weight(1f)
                           .padding(top = 8.dp)
                   ) {
                        RestaurantRating(
                            restaurantRating = restaurant.restaurantRating
                        )
                   }
               }
               if (restaurant.discountAvailable) {
                   DiscountCard(
                       discountPercentage = restaurant.discountPercentage.toString(),
                       discountUpTo = restaurant.discountUpTo.toString()
                   )
               }
           }
        }
    }
}

//@Composable
//fun VegAndPromoted(
//    modifier: Modifier = Modifier
//){
//    var isVegetarian by remember { mutableStateOf(true) }
//    Box{
//        Column(
//        ) {
//            PromotedTag()
//            if (isVegetarian) {
//                VegetarianCard()
//            }
//        }
//    }
//}


@Composable
fun RestaurantRating(
    modifier : Modifier = Modifier,
    restaurantRating : Double
){
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(BrandGreenColor)
            .padding(horizontal = 5.dp, vertical = 2.dp)
            .height(15.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = restaurantRating.toString(),
            color = Color.White,
            style = MaterialTheme.typography.overline,
            fontWeight = FontWeight.Bold,
        )
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(10.dp)
        )
    }
}

@Composable
fun PromotedTag(
    modifier : Modifier = Modifier
){
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(3.dp))
            .background(ZomatoCloneTheme.colors.brandTextBlack.copy(alpha = 0.4f))
            .padding(horizontal = 4.dp, vertical = 1.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Promoted",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}


@Composable
fun RestaurantDistance(
    modifier: Modifier = Modifier,
    time : Int,
    distance : Int
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.Timer,
            contentDescription = null,
            tint = Color.Black,
            modifier = modifier
                .size(12.dp)

        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            buildAnnotatedString {
                append(time.toString())
                append(" mins")
            },
            color = ZomatoCloneTheme.colors.brandTextBlack,
            fontSize = MaterialTheme.typography.overline.fontSize,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = modifier.width(4.dp))
        Divider(
            modifier = modifier
                .width(2.dp)
            ,
            color = Color.Black,
            thickness = 2.dp
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            buildAnnotatedString {
                append(distance.toString())
                append(" km")
            },
            color = ZomatoCloneTheme.colors.brandTextBlack,
            fontSize = MaterialTheme.typography.overline.fontSize,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
fun RestaurantPrice(
    modifier: Modifier = Modifier,
    perHeadPrice : Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.Timer,
            contentDescription = null,
            tint = Color.Black,
            modifier = modifier
                .size(12.dp)

        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            buildAnnotatedString {
                append(perHeadPrice.toString())
                append(" ")
                append("for one")
            },
            color = ZomatoCloneTheme.colors.brandTextBlack,
            fontSize = MaterialTheme.typography.overline.fontSize,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = modifier.width(4.dp))

    }
}

@Composable
fun DiscountCard(
    modifier: Modifier = Modifier,
    discountPercentage : String,
    discountUpTo : String
){
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(color = BrandBlueLight.copy(alpha = 0.5f))
            .padding(horizontal = 8.dp)

        ,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(
            painter = painterResource(id = R.drawable.ic_discount_sticker_with_percentage_svgrepo_com),
            contentDescription = null,
            tint = BrandBlue,
            modifier = modifier
                .size(10.dp)
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            buildAnnotatedString {
                append(discountPercentage)
                append("%")
                append(" ")
                append("OFF up to ")
                append(discountUpTo)
            },
            color = BrandBlue,
            fontSize = MaterialTheme.typography.overline.fontSize,
            fontWeight = FontWeight.Bold,

        )
    }
}

@Composable
fun VegetarianCard(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(25.dp)
            .background(color = BrandGreenColorLight.copy(0.8f))
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_leaf_svgrepo_com),
            contentDescription = null,
            tint = BrandGreenColor,
            modifier = modifier
                .size(9.dp)
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            text = "Pure Veg",
            color = BrandGreenColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,

            )
    }
}

@Composable
fun SaveHeartButton(
    modifier : Modifier = Modifier,
    icon : ImageVector,
    onClick : () -> Unit = {}
) {
    IconButton(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.White)
            .size(30.dp),
        onClick = {
            onClick()
        }
    ) {
        Icon(
                modifier = Modifier
                    .size(18.dp),
                imageVector = icon,
                contentDescription = null,
                tint = Cranberry
            )

        }

}




//
//@Preview
//@Composable
//fun testButton(){
//    SaveHeartButton()
//}
//
//
//@Composable
//fun SaveIcon(
//    modifier : Modifier = Modifier
//){
//
//}
//
//
//@Preview
//@Composable
//fun test2(){
//    VegetarianCard()
//}
//@Preview
//@Composable
//fun test1(){
//    RestaurantDistance()
//}
//@Preview
//@Composable
//fun test(){
//    RestaurantRating()
//}
//
//@Preview
//@Composable
//fun test5(){
//    SaveIcon()
//}
//
//@Preview
//@Composable
//fun test4(){
//    PromotedTag()
//}
//
//@Preview
//@Composable
//fun cardtest(){
//    SmallRestaurantCard()
//}