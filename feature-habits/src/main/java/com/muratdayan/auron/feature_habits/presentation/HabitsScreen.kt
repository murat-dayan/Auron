package com.muratdayan.auron.feature_habits.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.muratdayan.auron.core_ui.ui.AuronCenteredText

@Composable
fun HabitsScreen(
    onNavigateToVirtues: () -> Unit,
    onNavigateToProfile : () -> Unit,
    onNavigateToJournal : () -> Unit,
){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Habits")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNavigateToVirtues) { Text("Go Virtues") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onNavigateToProfile) { Text("Go Profile") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onNavigateToJournal) { Text("Go Journal") }
    }
}