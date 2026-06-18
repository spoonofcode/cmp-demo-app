package com.spoonofcode.core.presentation.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import kotlin.reflect.KClass

/**
 * Tab-level routes are treated as roots.
 * All other routes are simply pushed onto the stack.
 */
class Navigator(private val backStack: NavBackStack<NavKey>) {

    fun navigate(route: NavKey) {
        if (route.isTabRoute()) {
            switchTab(route)
        } else {
            backStack.add(route)
        }
    }

    fun goBack() {
        backStack.removeLastOrNull()
    }

    fun replace(route: NavKey) {
        backStack.removeLastOrNull()
        backStack.add(route)
    }

    fun popTo(routeClass: KClass<out NavKey>) {
        backStack.clearAfterLast { routeClass.isInstance(it) }
    }

    fun popToRoot() {
        backStack.clearAfterFirst()
    }

    fun getCurrentRoute(): NavKey? = backStack.lastOrNull()

    private fun NavKey.isTabRoute() = this in TopLevelDestinations.content().keys

    private fun switchTab(tab: NavKey) {
        backStack.clearAfterFirst { it.isTabRoute() }
        if (tab != backStack.lastOrNull()) backStack.add(tab)
    }

    private fun NavBackStack<NavKey>.clearAfterFirst(predicate: (NavKey) -> Boolean = { true }) {
        val idx = indexOfFirst(predicate)
        if (idx >= 0) subList(idx + 1, size).clear()
    }

    private fun NavBackStack<NavKey>.clearAfterLast(predicate: (NavKey) -> Boolean) {
        val idx = indexOfLast(predicate)
        if (idx >= 0) subList(idx + 1, size).clear()
    }
}