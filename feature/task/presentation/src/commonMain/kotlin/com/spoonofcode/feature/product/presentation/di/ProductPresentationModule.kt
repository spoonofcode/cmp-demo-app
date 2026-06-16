package com.spoonofcode.feature.task.presentation.di

import com.spoonofcode.core.presentation.navigation.route.ModuleRouteResolver
import com.spoonofcode.feature.appnavigation.ProductModuleRoute
import com.spoonofcode.feature.task.presentation.ProductModuleRouteResolver
import com.spoonofcode.feature.task.presentation.details.ProductDetailsViewModel
import com.spoonofcode.feature.task.presentation.edit.ProductEditViewModel
import com.spoonofcode.feature.task.presentation.overview.ProductOverviewViewModel
import com.spoonofcode.feature.task.presentation.series.overview.ProductSeriesOverviewViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val productPresentationModule = module {
    factoryOf(::ProductModuleRouteResolver) { bind<ModuleRouteResolver<ProductModuleRoute>>() }

    viewModelOf(::ProductDetailsViewModel)
    viewModelOf(::ProductEditViewModel)
    viewModelOf(::ProductOverviewViewModel)
    viewModelOf(::ProductSeriesOverviewViewModel)
}