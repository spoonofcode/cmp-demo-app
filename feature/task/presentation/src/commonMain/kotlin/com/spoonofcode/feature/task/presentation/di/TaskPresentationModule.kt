package com.spoonofcode.feature.task.presentation.di

import com.spoonofcode.feature.task.presentation.details.TaskDetailsViewModel
import com.spoonofcode.feature.task.presentation.edit.TaskEditViewModel
import com.spoonofcode.feature.task.presentation.overview.TaskOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val taskPresentationModule = module {
    viewModelOf(::TaskOverviewViewModel)
    viewModelOf(::TaskDetailsViewModel)
    viewModelOf(::TaskEditViewModel)
}