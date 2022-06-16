package com.example.zomatoclone.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.zomatoclone.R


private val Metropolis = FontFamily(
    Font(R.font.metropolisextralight, weight = FontWeight.ExtraLight),
    Font(R.font.metropolislight, weight = FontWeight.Light),
    Font(R.font.metropolisthin, weight = FontWeight.Thin),
    Font(R.font.metropolismedium, weight = FontWeight.Medium),
    Font(R.font.metropolisregular, weight = FontWeight.Normal),
    Font(R.font.metropolissemibold, weight = FontWeight.SemiBold),
    Font(R.font.metropolisbold, weight = FontWeight.Bold),
    Font(R.font.metropolisextrabold, weight = FontWeight.ExtraBold),
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),
    caption = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    overline = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    body2 = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        letterSpacing = (-0.04).em
    ),
)
