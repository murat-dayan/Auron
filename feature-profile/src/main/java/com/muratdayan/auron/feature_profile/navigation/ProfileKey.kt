package com.muratdayan.auron.feature_profile.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface ProfileKey: NavKey {

    @Serializable
    data object ProfileMain: ProfileKey
}