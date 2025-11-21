package com.muratdayan.auron.feature_habits.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.muratdayan.auron.core_ui.R
import com.muratdayan.auron.core_ui.ui.theme.CardShapes
import com.muratdayan.auron.core_ui.ui.theme.LocalDimensions

@Composable
fun HabitCard(
    title: String,
    progress: Float,
    onEdit: () -> Unit,
    onComplete: () -> Unit
) {

    val dims = LocalDimensions.current

    Card(
        shape = CardShapes.medium,
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = MaterialTheme.colorScheme.background,
            disabledContentColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dims.large, vertical = dims.medium)
    ) {
        Row(
            modifier = Modifier
                .padding(dims.large),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    title,
                    style = typography.titleLarge,
                )
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = dims.medium)
                )
                Spacer(modifier = Modifier.height(dims.large))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = onComplete
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_done),
                            contentDescription = "Done"
                        )
                    }
                    IconButton(
                        onClick = onEdit
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_edit),
                            contentDescription = "Edit"
                        )
                    }
                }

            }

        }
    }
}