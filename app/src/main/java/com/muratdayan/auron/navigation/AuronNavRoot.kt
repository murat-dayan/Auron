package com.muratdayan.auron.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.muratdayan.auron.feature_habits.navigation.HabitsKey
import com.muratdayan.auron.feature_habits.presentation.HabitsScreen
import com.muratdayan.auron.feature_journal.navigation.JournalKey
import com.muratdayan.auron.feature_journal.presentation.JournalScreen
import com.muratdayan.auron.feature_profile.navigation.ProfileKey
import com.muratdayan.auron.feature_profile.presentation.ProfileScreen
import com.muratdayan.auron.feature_virtues.navigation.VirtuesKey
import com.muratdayan.auron.feature_virtues.presentation.VirtuesScreen


@Composable
fun AuronNavRoot(){

    val backStack = rememberNavBackStack(HabitsKey.HabitsMain)

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<HabitsKey.HabitsMain>{
                HabitsScreen(
                    onNavigateToJournal = {backStack.add(JournalKey.JournalMain)},
                    onNavigateToProfile = {backStack.add(ProfileKey.ProfileMain)},
                    onNavigateToVirtues = {backStack.add(VirtuesKey.VirtuesMain)}
                )
            }

            entry<VirtuesKey.VirtuesMain>{
                VirtuesScreen(
                    onBack = {backStack.removeLastOrNull()}
                )
            }

            entry<ProfileKey.ProfileMain>{
                ProfileScreen(
                    onBack = {backStack.removeLastOrNull()}
                )
            }

            entry<JournalKey.JournalMain>{
                JournalScreen(
                    onBack = {backStack.removeLastOrNull()}
                )
            }
        }
    )
}