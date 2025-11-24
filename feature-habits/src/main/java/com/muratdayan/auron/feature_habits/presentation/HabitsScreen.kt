package com.muratdayan.auron.feature_habits.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.muratdayan.auron.core_ui.R
import com.muratdayan.auron.core_ui.ui.AuronText
import com.muratdayan.auron.feature_habits.ui.components.HabitCard

@Composable
fun HabitsScreen(
    onNavigateToVirtues: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToJournal: () -> Unit,
    onNavigateToAddHabit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AuronText(
            text = "Habits",
            style = MaterialTheme.typography.titleLarge,

            )
        IconButton(
            onClick = { onNavigateToAddHabit() }
        ) {
            Icon(painter = painterResource(R.drawable.ic_plus), contentDescription = "Add Habit")
        }
        HabitCard(
            progress = 0.5f,
            title = "Auron",
            onComplete = {},
            onEdit = {}
        )
    }
}