package com.spoonofcode.feature.task.presentation

import com.spoonofcode.feature.product.presentation.overview.TaskOverviewScreen

fun EntryProviderScope<NavKey>.taskModuleRouteResolver() {
    entry<TaskModuleRoute.TaskOverview> {
        TaskOverviewScreen().Content()
    }
}