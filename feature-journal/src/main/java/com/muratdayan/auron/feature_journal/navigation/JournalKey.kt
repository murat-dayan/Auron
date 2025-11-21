package com.muratdayan.auron.feature_journal.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface JournalKey: NavKey {

    @Serializable
    data object JournalMain: JournalKey
}