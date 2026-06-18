package com.spoonofcode.core.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlin.reflect.KClass

sealed class NavigationEvent {
    data object Pop : NavigationEvent()
    data object PopToRoot : NavigationEvent()
    data class PopUpTo(val routeClass: KClass<out NavKey>) : NavigationEvent()
    data class Push(val route: NavKey) : NavigationEvent()
    // data class ReplaceAll(val screens: List<Screen>) : NavigationEvent()
    data class Replace(val route: NavKey) : NavigationEvent()
}