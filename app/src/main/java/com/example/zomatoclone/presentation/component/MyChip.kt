package com.example.zomatoclone.presentation.component

import android.util.Log
import android.view.Surface
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zomatoclone.presentation.SearchChips
import com.example.zomatoclone.presentation.getAllCategories
import com.example.zomatoclone.ui.theme.Cranberry
import com.example.zomatoclone.ui.theme.ZomatoCloneTheme

@Composable
fun MyChip(
    modifier: Modifier = Modifier,
    name: String,
    isSelected: Boolean = false,
    onSelectionChanged: () -> Unit,
) {
    Surface(
        modifier = Modifier,
        elevation = if (isSelected) 0.dp else 2.dp,
        shape = RoundedCornerShape(12.dp),
        color = if(isSelected) ZomatoCloneTheme.colors.brandAlpha else Color.White,
        border = BorderStroke(0.3.dp, if(isSelected) ZomatoCloneTheme.colors.brand else ZomatoCloneTheme.colors.brandLightGrey)
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {}
            )
            .padding(horizontal = 10.dp, vertical = 8.dp)
        ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.caption,
                color = ZomatoCloneTheme.colors.brandTextBlack,
                fontWeight = FontWeight.SemiBold

            )
            Log.d("selescted", "$isSelected")
            if (isSelected){
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    tint = ZomatoCloneTheme.colors.brandTextBlack
                )
            }
        }
    }
}

