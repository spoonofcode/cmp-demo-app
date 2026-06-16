package com.spoonofcode.feature.home.presentation

import com.spoonofcode.feature.appnavigation.HomeModuleRoute

fun EntryProviderScope<NavKey>.homeModuleRouteResolver() {
    entry<HomeModuleRoute.Home> {
        HomeScreen().Content()
    }
}