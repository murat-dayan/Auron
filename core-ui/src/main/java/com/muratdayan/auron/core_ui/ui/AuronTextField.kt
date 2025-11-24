package com.muratdayan.auron.core_ui.ui

import android.R.attr.rotation
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.muratdayan.auron.core_ui.R
import java.nio.file.Files.size
import java.util.Collections.rotate

@Composable
fun AuronTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeHolder: String ="",
    isError: Boolean = false,
    singleLine: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    focusedBorderColor: Color = MaterialTheme.colorScheme.primary,
    unfocusedBorderColor: Color = MaterialTheme.colorScheme.outline,
    leadingIconId: Int = R.drawable.ic_label,
    trailingIconId: Int = R.drawable.ic_close
){
    var isFocused by remember { mutableStateOf(false) }

    val borderColor by animateColorAsState(
        targetValue = if (isFocused) focusedBorderColor else if (isError) MaterialTheme.colorScheme.error else unfocusedBorderColor
    )

    val placeHolderColor by animateColorAsState(
        targetValue = if (isFocused) focusedBorderColor else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )

    val infiniteTransition = rememberInfiniteTransition()
    val shiftState = if (isFocused) {
        infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    } else {
        // focus yoksa animasyon duracak, State<Float> dönmesi için sabit state
        remember { mutableStateOf(0f) }
    }

    val shift = shiftState.value

    val gradientColors = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.error
    )

    fun shiftedColors(colors: List<Color>, shiftFraction: Float): List<Color> {
        val n = colors.size
        val shiftIndex = (shiftFraction * n).toInt() % n
        return colors.drop(shiftIndex) + colors.take(shiftIndex)
    }



    val composedModifier = modifier
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.large)
        .shadow(
            elevation = if (isFocused) 8.dp else 4.dp,
            shape = MaterialTheme.shapes.large,
            clip = false
        )
        .drawWithContent {
            // önce normal içeriği çiz
            drawContent()

            val animatedColors = shiftedColors(gradientColors, shift)
            val animatedBrush = Brush.sweepGradient(
                colors = animatedColors,
                center = center,
            )

            // sonra (içerik üstünde) dönen gradient border'ı çiz
            withTransform({
            }) {
                // Sweep gradient merkezi burada center olmalı
                drawRoundRect(
                    brush = animatedBrush,
                    size = size,
                    cornerRadius = CornerRadius(24.dp.toPx()),
                    style = Stroke(width = 4.dp.toPx())
                )
            }
        }
        // Arka planu burada ekleyebilirsin; drawWithContent içeriğin üstüne çizmeden önce arka plan zaten içerikte gösterilir
        .onFocusChanged { isFocused = it.isFocused }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = composedModifier,
        placeholder = {AuronText(text = placeHolder, color = placeHolderColor)},
        singleLine = singleLine,
        shape = MaterialTheme.shapes.large,
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            errorTextColor = MaterialTheme.colorScheme.error,
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            errorContainerColor = backgroundColor,
            cursorColor = borderColor,
            errorCursorColor = MaterialTheme.colorScheme.error,
            selectionColors = TextSelectionColors(
                handleColor = borderColor,
                backgroundColor = borderColor.copy(alpha = 0.4f)
            ),
            focusedIndicatorColor = borderColor,
            unfocusedIndicatorColor = borderColor.copy(alpha = 0.5f),
            disabledIndicatorColor = borderColor.copy(alpha = 0.3f),
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            focusedLabelColor = MaterialTheme.colorScheme.onSurface,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            disabledLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            errorLabelColor = MaterialTheme.colorScheme.error,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
            disabledPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            errorPlaceholderColor = MaterialTheme.colorScheme.error,
            focusedSupportingTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedSupportingTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            disabledSupportingTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            errorSupportingTextColor = MaterialTheme.colorScheme.error,
            focusedLeadingIconColor = borderColor,
            unfocusedLeadingIconColor = borderColor.copy(alpha = 0.5f),
            disabledLeadingIconColor = borderColor.copy(alpha = 0.3f),
            errorLeadingIconColor = MaterialTheme.colorScheme.error,
            focusedTrailingIconColor = borderColor,
            unfocusedTrailingIconColor = borderColor.copy(alpha = 0.5f),
            disabledTrailingIconColor = borderColor.copy(alpha = 0.3f),
            errorTrailingIconColor = MaterialTheme.colorScheme.error,
            focusedPrefixColor = MaterialTheme.colorScheme.onSurface,
            unfocusedPrefixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            disabledPrefixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            errorPrefixColor = MaterialTheme.colorScheme.error,
            focusedSuffixColor = MaterialTheme.colorScheme.onSurface,
            unfocusedSuffixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            disabledSuffixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            errorSuffixColor = MaterialTheme.colorScheme.error
        ),
        textStyle = MaterialTheme.typography.bodyMedium,
        leadingIcon = {
            if (leadingIconId != null){
                Icon(
                    painter = painterResource(leadingIconId),
                    contentDescription = "Leading Icon TextField"
                )
            }

        },
        trailingIcon = {
            if (trailingIconId != null){
                if (value.isNotEmpty()){
                    IconButton(onClick = {onValueChange("")}) {
                        Icon(painter = painterResource(trailingIconId), contentDescription = "Trailing Icon TextField")
                    }
                }
            }

        }

    )
}
