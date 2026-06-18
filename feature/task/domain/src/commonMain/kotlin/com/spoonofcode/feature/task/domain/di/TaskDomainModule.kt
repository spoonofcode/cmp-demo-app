package com.spoonofcode.feature.task.domain.di

import com.spoonofcode.feature.task.domain.usecase.DeleteTaskUseCase
import com.spoonofcode.feature.task.domain.usecase.GetTaskUseCase
import com.spoonofcode.feature.task.domain.usecase.GetTasksUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val taskDomainModule = module {
    factoryOf(::GetTasksUseCase)
    factoryOf(::GetTaskUseCase)
    factoryOf(::DeleteTaskUseCase)
}