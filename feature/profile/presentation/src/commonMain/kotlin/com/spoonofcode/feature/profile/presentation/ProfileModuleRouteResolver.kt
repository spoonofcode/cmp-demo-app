package com.spoonofcode.feature.profile.presentation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.spoonofcode.feature.appnavigation.ProfileModuleRoute
import com.spoonofcode.feature.profile.presentation.details.ProfileDetailsScreen

fun EntryProviderScope<NavKey>.profileModuleRouteResolver() {
    entry<ProfileModuleRoute.Home> {
        ProfileDetailsScreen().Content()
    }
}
