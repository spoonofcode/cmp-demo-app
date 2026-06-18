package com.spoonofcode.feature.task.presentation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.spoonofcode.feature.appnavigation.TaskModuleRoute
import com.spoonofcode.feature.product.presentation.overview.TaskOverviewScreen

fun EntryProviderScope<NavKey>.taskModuleRouteResolver() {
    entry<TaskModuleRoute.TaskOverview> {
        TaskOverviewScreen().Content()
    }
}
