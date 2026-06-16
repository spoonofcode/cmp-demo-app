package com.spoonofcode.feature.task.data.test.di

import com.spoonofcode.feature.task.data.test.productRepositoryMock
import org.koin.dsl.module

val productDataTestModule = module {
    includes(
        module {
            single { productRepositoryMock() }
        },
    )
}