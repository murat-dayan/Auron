package com.muratdayan.auron.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class RootKey : NavKey{
    @Serializable
    data object Habits: RootKey()

    @Serializable
    data object Virtues : RootKey()

    @Serializable
    data object Journal : RootKey()

    @Serializable
    data object Profile : RootKey()

}