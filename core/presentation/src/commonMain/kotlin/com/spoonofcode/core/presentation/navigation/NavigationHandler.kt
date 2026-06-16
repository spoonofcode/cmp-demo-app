package com.spoonofcode.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun NavigationHandler(
    navigationFlow: SharedFlow<NavigationEvent>,
    navigator: Navigator
) {
    LaunchedEffect(true) {
        navigationFlow.collect { navigationEvent ->
            when (navigationEvent) {
                NavigationEvent.Pop -> navigator.goBack()
                NavigationEvent.PopToRoot -> navigator.popToRoot()
                is NavigationEvent.PopUpTo -> navigator.popTo(navigationEvent.routeClass)
                is NavigationEvent.Push -> navigator.navigate(navigationEvent.route)
                is NavigationEvent.Replace -> navigator.replace(navigationEvent.route)
// is NavigationEvent.ReplaceAll -> navigator.replaceAll(navigationEvent.screens)
            }
        }
    }
}import androidx.navigation3.runtime.NavKey
import kotlin.reflect.KClass

interface ViewModelNavigator {
    val navigationEvents: SharedFlow<NavigationEvent>

    suspend fun pop()
    suspend fun popToRoot()
    suspend fun <T : NavKey> popUpTo(routeClass: KClass<T>)
    suspend fun push(route: NavKey)
    suspend fun replace(route: NavKey)
}