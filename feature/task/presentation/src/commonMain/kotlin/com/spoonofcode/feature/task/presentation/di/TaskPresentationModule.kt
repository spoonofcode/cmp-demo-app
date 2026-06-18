package com.spoonofcode.feature.task.presentation.di

import com.spoonofcode.feature.task.presentation.details.ProductDetailsViewModel
import com.spoonofcode.feature.task.presentation.edit.ProductEditViewModel
import com.spoonofcode.feature.task.presentation.series.overview.ProductSeriesOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val taskPresentationModule = module {
    viewModelOf(::ProductDetailsViewModel)
    viewModelOf(::ProductEditViewModel)
    viewModelOf(::ProductOverviewViewModel)
    viewModelOf(::ProductSeriesOverviewViewModel)
}