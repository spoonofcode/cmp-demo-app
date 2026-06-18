package com.spoonofcode.feature.task.presentation.di

import com.spoonofcode.feature.product.presentation.overview.TaskOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val taskPresentationModule = module {
    viewModelOf(::TaskOverviewViewModel)
}