package com.spoonofcode.feature.task.data.test.di

import org.koin.dsl.module

val taskDataTestModule = module {
    includes(
        module {
//            single { productRepositoryMock() }
        },
    )
}