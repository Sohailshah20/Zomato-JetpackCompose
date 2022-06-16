package com.example.zomatoclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = ZomatoCloneColors(
    brand = Cranberry,
    brandAlpha = CranberryLight,
    brandLightGrey = BackgroundGrey,
    brandDarkGrey = BackgroundDarkGrey,
    brandBlue = BrandBlue,
    brandLightBlue = BrandBlueLight,
    brandGreen = BrandGreenColor,
    brandLightGreen = BrandGreenColorLight,
    brandTextBlack = PepperCornBlack,
    brandTextGrey = GreyTextColor,
)

private val LightColorPalette = ZomatoCloneColors(
    brand = Cranberry,
    brandAlpha = CranberryLight,
    brandLightGrey = BackgroundGrey,
    brandDarkGrey = BackgroundDarkGrey,
    brandBlue = BrandBlue,
    brandLightBlue = BrandBlueLight,
    brandGreen = BrandGreenColor,
    brandLightGreen = BrandGreenColorLight,
    brandTextBlack = PepperCornBlack,
    brandTextGrey = GreyTextColor,
)

@Composable
fun ZomatoCloneTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ProvideZomatoCloneColors(colors = colors) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = Typography,
            content = content
        )
    }

}

object ZomatoCloneTheme {
    val colors: ZomatoCloneColors
        @Composable
        get() = LocalZomatoCloneColors.current
}

@Stable
class ZomatoCloneColors(
    brand: Color,
    brandAlpha: Color,
    brandLightGrey: Color,
    brandDarkGrey: Color,
    brandBlue: Color,
    brandLightBlue: Color,
    brandGreen: Color,
    brandLightGreen: Color,
    brandTextBlack: Color,
    brandTextGrey: Color,
){
    var brand by mutableStateOf(brand)
        private set
    var brandAlpha by mutableStateOf(brandAlpha)
        private set
    var brandLightGrey by mutableStateOf(brandLightGrey)
        private set
    var brandDarkGrey by mutableStateOf(brandDarkGrey)
        private set
    var brandBlue by mutableStateOf(brandBlue)
        private set
    var brandLightBlue by mutableStateOf(brandLightBlue)
        private set
    var brandGreen by mutableStateOf(brandGreen)
        private set
    var brandLightGreen by mutableStateOf(brandLightGreen)
        private set
    var brandTextBlack by mutableStateOf(brandTextBlack)
        private set
    var brandTextGrey by mutableStateOf(brandTextGrey)
        private set

    fun update(other: ZomatoCloneColors){
        brand = other.brand
        brandAlpha = other.brandAlpha
        brandLightGrey = other.brandLightGrey
        brandDarkGrey = other.brandDarkGrey
        brandBlue = other.brandBlue
        brandLightBlue = other.brandLightBlue
        brandGreen = other.brandGreen
        brandLightGreen = other.brandLightGreen
        brandTextBlack = other.brandTextBlack
        brandTextGrey = other.brandTextGrey
    }

    fun copy() : ZomatoCloneColors = ZomatoCloneColors(
        brand = brand,
        brandAlpha = brandAlpha,
        brandLightGrey = brandLightGrey,
        brandDarkGrey = brandDarkGrey,
        brandBlue = brandBlue,
        brandLightBlue = brandLightBlue,
        brandGreen = brandGreen,
        brandLightGreen = brandLightGreen,
        brandTextBlack = brandTextBlack,
        brandTextGrey = brandTextGrey,
    )
}

@Composable
fun ProvideZomatoCloneColors(
    colors: ZomatoCloneColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalZomatoCloneColors provides colorPalette, content = content)
}

private val LocalZomatoCloneColors = staticCompositionLocalOf<ZomatoCloneColors> {
    error("No JetsnackColorPalette provided")
}


fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)