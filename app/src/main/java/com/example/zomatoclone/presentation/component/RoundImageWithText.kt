package com.example.zomatoclone.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.zomatoclone.R
import com.example.zomatoclone.data.CuisineCategory

import com.example.zomatoclone.ui.theme.ZomatoCloneTheme

@Composable
fun RoundImageWithText(
    modifier: Modifier = Modifier,
    cuisineCategory : CuisineCategory
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
                ,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        AsyncImage(
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp),
            model = cuisineCategory.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = cuisineCategory.categoryName,
            fontSize = MaterialTheme.typography.overline.fontSize,
            fontWeight = FontWeight.SemiBold,
            color = ZomatoCloneTheme.colors.brandTextGrey
            )
    }
}

@Composable
fun MyOutlinedButton(
    modifier: Modifier = Modifier,
    text : String,
    onClickPressed : () -> Unit,
    showMore : Boolean = false,
    ){

    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
        ,
        onClick = {onClickPressed()},
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = ZomatoCloneTheme.colors.brandTextBlack,
        ) ,
        border = BorderStroke(0.5.dp,ZomatoCloneTheme.colors.brandTextGrey.copy(alpha = 0.5f))
    ) {
        Text(
            text =  text,
            style = MaterialTheme.typography.overline,
            color = ZomatoCloneTheme.colors.brandTextBlack,
            fontWeight = FontWeight.Medium,
        )
        Icon(
            imageVector = if (showMore) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = null,
        )
    }
}
