package com.muratdayan.auron.feature_habits.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface HabitsKey: NavKey {

    @Serializable
    data object HabitsMain: HabitsKey
}