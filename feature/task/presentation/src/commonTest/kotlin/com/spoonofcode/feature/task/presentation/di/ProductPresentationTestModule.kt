package com.spoonofcode.feature.task.presentation.di

import com.spoonofcode.feature.task.data.test.di.productDataTestModule
import com.spoonofcode.feature.task.domain.di.productDomainModule
import org.koin.dsl.module

val productPresentationTestModule = module {
    includes(
        productDataTestModule,
        productDomainModule,
        taskPresentationModule,
    )
}