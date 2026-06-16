package com.spoonofcode.feature.task.data.di

import com.spoonofcode.feature.task.data.repository.ProductRepositoryImpl
import com.spoonofcode.feature.task.data.remote.RemoteProductDataSource
import com.spoonofcode.feature.task.domain.repository.ProductRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val productDataModule = module {
    singleOf(::RemoteProductDataSource)

    singleOf(::ProductRepositoryImpl).bind<ProductRepository>()
}