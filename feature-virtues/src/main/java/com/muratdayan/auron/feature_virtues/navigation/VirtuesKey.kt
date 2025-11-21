package com.muratdayan.auron.feature_virtues.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface VirtuesKey: NavKey {

    @Serializable
    data object VirtuesMain: VirtuesKey
}