package com.muratdayan.auron.core_ui.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val smallest: Dp = 2.dp,
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 24.dp,

    // Border Radius
    val radiusSmall: Dp = 4.dp,
    val radiusMedium: Dp = 8.dp,
    val radiusLarge: Dp = 16.dp,

    // Elevation
    val elevationSmall: Dp = 2.dp,
    val elevationMedium: Dp = 4.dp,
    val elevationLarge: Dp = 8.dp,

    // Icon Sizes
    val iconSmall: Dp = 16.dp,
    val iconMedium: Dp = 24.dp,
    val iconLarge: Dp = 32.dp,

    // Component Heights
    val buttonHeight: Dp = 48.dp,
    val textFieldHeight: Dp = 56.dp
)

val LocalDimensions = staticCompositionLocalOf { AppDimensions() }
