package com.spoonofcode.feature.task.domain.di

import com.spoonofcode.feature.task.domain.usecase.GetTasksUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val taskDomainModule = module {
    factoryOf(::GetTasksUseCase)
}