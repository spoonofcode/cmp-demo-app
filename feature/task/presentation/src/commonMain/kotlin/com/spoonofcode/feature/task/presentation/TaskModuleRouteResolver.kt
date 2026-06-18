package com.spoonofcode.feature.task.presentation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.spoonofcode.feature.appnavigation.TaskModuleRoute
import com.spoonofcode.feature.task.presentation.details.TaskDetailsScreen
import com.spoonofcode.feature.task.presentation.edit.TaskEditScreen
import com.spoonofcode.feature.task.presentation.overview.TaskOverviewScreen

fun EntryProviderScope<NavKey>.taskModuleRouteResolver() {
    entry<TaskModuleRoute.TaskOverview> {
        TaskOverviewScreen()
    }

    entry<TaskModuleRoute.TaskDetails> {
        TaskDetailsScreen(taskId = it.taskId)
    }

    entry<TaskModuleRoute.TaskEdit> {
        TaskEditScreen()
    }
}
