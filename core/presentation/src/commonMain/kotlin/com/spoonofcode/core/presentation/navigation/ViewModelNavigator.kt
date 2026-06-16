package com.spoonofcode.core.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.flow.SharedFlow
import kotlin.reflect.KClass

interface ViewModelNavigator {
    val navigationEvents: SharedFlow<NavigationEvent>

    suspend fun pop()
    suspend fun popToRoot()
    suspend fun <T : NavKey> popUpTo(routeClass: KClass<T>)
    suspend fun push(route: NavKey)
    suspend fun replace(route: NavKey)
}
