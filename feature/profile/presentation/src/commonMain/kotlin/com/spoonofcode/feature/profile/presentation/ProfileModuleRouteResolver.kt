package com.spoonofcode.feature.profile.presentation

import com.spoonofcode.feature.appnavigation.ProfileModuleRoute

fun EntryProviderScope<NavKey>.profileModuleRouteResolver() {
    entry<ProfileModuleRoute.Home> {
        ProfileScreen().Content()
    }
}