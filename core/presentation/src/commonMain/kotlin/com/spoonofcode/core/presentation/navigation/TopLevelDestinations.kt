package com.spoonofcode.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Task
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavKey
import com.spoonofcode.core.presentation.compose.navigationbar.BottomNavItem
import com.spoonofcode.feature.appnavigation.HomeModuleRoute
import com.spoonofcode.feature.appnavigation.ProfileModuleRoute
import com.spoonofcode.feature.appnavigation.TaskModuleRoute

object TopLevelDestinations {

    private var content by mutableStateOf(mapOf<NavKey, BottomNavItem>())

    fun content(): Map<NavKey, BottomNavItem> {
        return content
    }

    private fun setContent() {
        content = mapOf(
            HomeModuleRoute.Home to BottomNavItem(
                icon = Icons.Outlined.Home,
                title = "Home",
            ),
            TaskModuleRoute.TaskOverview to BottomNavItem(
                icon = Icons.Outlined.Task,
                title = "Task",
            ),
            ProfileModuleRoute.ProfileDetails to BottomNavItem(
                icon = Icons.Outlined.Person,
                title = "Profile",
            )
        )
    }

    init {
        setContent()
    }
}