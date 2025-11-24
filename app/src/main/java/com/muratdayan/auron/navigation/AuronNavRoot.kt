package com.muratdayan.auron.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.muratdayan.auron.feature_habits.navigation.HabitsNavigation
import com.muratdayan.auron.feature_habits.presentation.HabitsScreen
import com.muratdayan.auron.feature_journal.presentation.JournalScreen
import com.muratdayan.auron.feature_profile.presentation.ProfileScreen
import com.muratdayan.auron.feature_virtues.presentation.VirtuesScreen
import com.muratdayan.auron.ui.composables.AuronBottomBar


@Composable
fun AuronNavRoot() {

    val backStack = rememberNavBackStack(RootKey.Habits as NavKey)
    var showBottomBar by remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                val currentTab = backStack.lastOrNull() ?: RootKey.Habits
                if (currentTab is RootKey) {
                    AuronBottomBar(currentTab = currentTab) { selectedTab ->
                        backStack.add(selectedTab)
                    }
                }
            }
        }
    ) { innerPadding ->

        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                // Habits Tab
                entry<RootKey.Habits> {
                    HabitsNavigation(
                        onNavigateToJournal = { backStack.add(RootKey.Journal) },
                        onNavigateToProfile = { backStack.add(RootKey.Profile) },
                        onNavigateToVirtues = { backStack.add(RootKey.Virtues) },
                        onBottomBarVisibilityChanged = { visible -> showBottomBar = visible }
                    )
                }

                // Virtues Tab
                entry<RootKey.Virtues> {
                    VirtuesScreen(onBack = { backStack.removeLastOrNull() })
                }

                // Journal Tab
                entry<RootKey.Journal> {
                    JournalScreen(onBack = { backStack.removeLastOrNull() })
                }

                // Profile Tab
                entry<RootKey.Profile> {
                    ProfileScreen(onBack = { backStack.removeLastOrNull() })
                }
            }
        )
    }
}
