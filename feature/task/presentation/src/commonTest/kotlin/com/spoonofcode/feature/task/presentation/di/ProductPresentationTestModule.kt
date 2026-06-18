package com.spoonofcode.feature.task.presentation.di

import com.spoonofcode.feature.task.data.test.di.taskDataTestModule
import com.spoonofcode.feature.task.domain.di.taskDomainModule
import org.koin.dsl.module

val productPresentationTestModule = module {
    includes(
        taskDataTestModule,
        taskDomainModule,
        taskPresentationModule,
    )
}