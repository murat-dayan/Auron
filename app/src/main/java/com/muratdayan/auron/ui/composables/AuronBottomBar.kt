package com.muratdayan.auron.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import com.muratdayan.auron.R
import com.muratdayan.auron.data.BottomBarItem
import com.muratdayan.auron.navigation.RootKey


@Composable
fun AuronBottomBar(
    currentTab: RootKey,
    onTabSelected : (RootKey) -> Unit
){
    val items = remember {
        listOf(
            BottomBarItem(RootKey.Habits,"Habits", com.muratdayan.auron.core_ui.R.drawable.ic_habit),
            BottomBarItem(RootKey.Virtues,"Virtues",com.muratdayan.auron.core_ui.R.drawable.ic_honor ),
            BottomBarItem(RootKey.Journal,"Journal", com.muratdayan.auron.core_ui.R.drawable.ic_journal),
            BottomBarItem(RootKey.Profile,"Profile", com.muratdayan.auron.core_ui.R.drawable.ic_profile),

        )
    }

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentTab == item.key,
                onClick = {onTabSelected(item.key)},
                icon = { Icon(painter = painterResource(item.icon), contentDescription = item.title) },
                label = { Text(item.title, style = MaterialTheme.typography.titleSmall) },
            )
        }
    }
}