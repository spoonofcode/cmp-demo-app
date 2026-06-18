package com.spoonofcode.core.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlin.reflect.KClass

class ViewModelNavigatorImpl : ViewModelNavigator {
    private val _navigationEvents = MutableSharedFlow<NavigationEvent>()

    override val navigationEvents: SharedFlow<NavigationEvent>
        get() = _navigationEvents.asSharedFlow()

    override suspend fun pop() = navigate(NavigationEvent.Pop)
    //
    override suspend fun popToRoot() = navigate(NavigationEvent.PopToRoot)
    //
    override suspend fun <T : NavKey> popUpTo(routeClass: KClass<T>) =
        navigate(NavigationEvent.PopUpTo(routeClass))

    override suspend fun push(route: NavKey) = navigate(NavigationEvent.Push(route = route))

    // override suspend fun replaceAll(screens: List<Screen>) = navigate(NavigationEvent.ReplaceAll(screens))

    override suspend fun replace(route: NavKey) = navigate(NavigationEvent.Replace(route = route))

    private suspend fun navigate(event: NavigationEvent) = _navigationEvents.emit(event)

}