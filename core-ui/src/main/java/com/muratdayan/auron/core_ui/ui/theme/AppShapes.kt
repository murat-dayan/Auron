package com.muratdayan.auron.core_ui.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * AppShapes: Uygulama genelinde kullanılacak temel shapes seti
 */
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),   // Chip, MiniButton
    medium = RoundedCornerShape(8.dp),  // Card, TextField, Sheet
    large = RoundedCornerShape(16.dp)   // Dialog, BottomSheet, Surface
)

/**
 * ButtonShapes: Butonlara özel köşe radiusları
 */
val ButtonShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp)
)

/**
 * CardShapes: Kart ve liste öğeleri için
 */
val CardShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp)
)

/**
 * AvatarShapes: Avatar ve dairesel ikonlar için
 */
val AvatarShapes = Shapes(
    small = CircleShape,
    medium = CircleShape,
    large = CircleShape
)

/**
 * DialogShapes: Dialog ve büyük container’lar
 */
val DialogShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(28.dp)
)

/**
 * SheetShapes: BottomSheet ve ModalSheet
 */
val SheetShapes = Shapes(
    small = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
    medium = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
    large = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
)

/**
 * CutCornerShapes: Kesik köşe efekti isteyen componentler
 */
val CutShapes = Shapes(
    small = CutCornerShape(4.dp),
    medium = CutCornerShape(8.dp),
    large = CutCornerShape(16.dp)
)

/**
 * ExtraShapes: Özel ve asimetrik köşeler
 */
val ExtraShapes = Shapes(
    small = RoundedCornerShape(topStart = 0.dp, topEnd = 12.dp, bottomEnd = 12.dp, bottomStart = 0.dp),
    medium = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 8.dp, bottomStart = 8.dp),
    large = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp, bottomEnd = 16.dp, bottomStart = 16.dp)
)
