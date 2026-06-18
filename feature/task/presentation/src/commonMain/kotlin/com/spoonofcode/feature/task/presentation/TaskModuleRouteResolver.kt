package com.spoonofcode.feature.task.presentation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.spoonofcode.feature.appnavigation.TaskModuleRoute
import com.spoonofcode.feature.task.presentation.details.TaskDetailsScreen
import com.spoonofcode.feature.task.presentation.edit.TaskEditScreen
import com.spoonofcode.feature.task.presentation.overview.TaskOverviewScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

fun EntryProviderScope<NavKey>.taskModuleRouteResolver() {
    entry<TaskModuleRoute.TaskOverview> {
        TaskOverviewScreen(
            viewModel = koinViewModel()
        )
    }

    entry<TaskModuleRoute.TaskDetails> {
        TaskDetailsScreen(
            viewModel = koinViewModel { parametersOf(it.taskId) },
        )
    }

    entry<TaskModuleRoute.TaskEdit> {
        TaskEditScreen(
            viewModel = koinViewModel()
        )
    }
}
