package com.muratdayan.auron.feature_habits.navigation

import android.R.attr.visible
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.muratdayan.auron.feature_habits.presentation.AddHabitScreen
import com.muratdayan.auron.feature_habits.presentation.HabitsScreen

@Composable
fun HabitsNavigation(
    onNavigateToVirtues: () -> Unit,
    onNavigateToProfile : () -> Unit,
    onNavigateToJournal : () -> Unit,
    onBottomBarVisibilityChanged: (Boolean) -> Unit
){

    val backstack  = rememberNavBackStack(HabitsKey.HabitsMain)


    NavDisplay(
        backStack = backstack,
        onBack = {backstack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry <HabitsKey.HabitsMain>{
                onBottomBarVisibilityChanged(true)
                HabitsScreen(
                    onNavigateToVirtues = onNavigateToVirtues,
                    onNavigateToProfile = onNavigateToProfile,
                    onNavigateToJournal = onNavigateToJournal,
                    onNavigateToAddHabit = {backstack.add(HabitsKey.AddHabit)}
                )
            }

            entry<HabitsKey.AddHabit> {
                onBottomBarVisibilityChanged(false)
                AddHabitScreen(
                    onBack = {
                        backstack.removeLastOrNull()
                        onBottomBarVisibilityChanged(true)
                    }

                )
            }
        }
    )
}