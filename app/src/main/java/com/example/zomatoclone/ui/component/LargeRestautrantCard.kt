package com.example.zomatoclone.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.zomatoclone.R
import com.example.zomatoclone.ui.theme.BrandBlue
import com.example.zomatoclone.ui.theme.BrandBlueLight
import com.example.zomatoclone.ui.theme.BrandGreenColor
import com.example.zomatoclone.ui.theme.BrandGreenColorLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeRestaurantCard(
    modifier : Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(310.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Box(
            modifier = modifier
                .background(Color.White)

        ) {
            Column {
                Box(
                    modifier = Modifier
                        .height(210.dp)
                ){
                    AsyncImage(
                        modifier = Modifier
                            .height(210.dp)
                        ,
                        model = R.drawable.biryani_picture,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    DistanceAndTime(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(10.dp)
                    )
                    SaveHeartButton(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(20.dp)
                    )
                    PromotedTag(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(horizontal = 10.dp, vertical = 20.dp)
                    )
                    DiscountBox(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(bottom = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "United Kitchens Of India",
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RestaurantRating()
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Biryani, South Indian, Sea Food",
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$400 for One",
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    thickness = 0.2.dp
                )
                Spacer(modifier = Modifier.weight(1f))
                RecycleRow()

            }
        }
    }
}

@Composable
fun DistanceAndTime(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)
            .padding(horizontal = 2.dp, vertical = 2.dp)
            ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Timer,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(10.dp)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = "50 mins",
            color = Color.Black,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            fontWeight = FontWeight.Normal,
        )
        Spacer(modifier = Modifier.width(2.dp))
        Divider(
            modifier = Modifier
                .width(0.5.dp)
            ,
            color = Color.Black,
            thickness = 10.dp
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = "8 km",
            color = Color.Black,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            fontWeight = FontWeight.Normal,
        )
    }
}

@Composable
fun FoodNameAndPrice(
    modifier: Modifier = Modifier
){

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)
            .padding(horizontal = 4.dp, vertical = 2.dp)
        ,
        horizontalAlignment = Alignment.End
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Chicken Biryani",
                color = Color.Black,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            )
        }
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "order for $200",
                color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun DiscountBox(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp))
            .background(BrandBlue)
            .padding(4.dp)
            ,
        horizontalArrangement = Arrangement.SpaceBetween,
        ) {
       Column(
           modifier = Modifier
       ) {
           Spacer(modifier = Modifier.height(3.dp))
           Icon(
               painter = painterResource(id = R.drawable.ic_discount_sticker_with_percentage_svgrepo_com),
               contentDescription = null,
               tint = Color.White,
               modifier = Modifier
                   .size(10.dp)
           )
       }
        Spacer(modifier = Modifier.width(2.dp))
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "10 % OFF",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Up to $40",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun VegetarianCardLarge(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(color = BrandGreenColor.copy(0.8f))
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_leaf_svgrepo_com),
            contentDescription = null,
            tint = Color.White,
            modifier = modifier
                .size(9.dp)
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            text = "PURE VEG RESTAURANT",
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,

            )
    }
}

@Composable
fun RecycleRow(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(color = Color.White)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Recycling,
            contentDescription = null,
            tint = BrandGreenColor,
            modifier = modifier
                .size(14.dp)
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            text = "Zomato recycles more plastic than used in orders",
            color = Color.Black,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            fontWeight = FontWeight.Light,

            )
    }
}

@Preview
@Composable
fun prevRecycleRow(){
    RecycleRow()
}

@Preview
@Composable
fun prevVegetarianCardLarge(){
    VegetarianCardLarge()
}

@Preview
@Composable
fun prevDiscountBox(){
    DiscountBox()
}

@Preview
@Composable
fun prevFoodNameAndPrice(){
    FoodNameAndPrice()
}

@Preview
@Composable
fun prevDistanceAndTime(){
    DistanceAndTime()
}

@Preview
@Composable
fun prevLargeRestaurantCard(){
    LargeRestaurantCard()
}