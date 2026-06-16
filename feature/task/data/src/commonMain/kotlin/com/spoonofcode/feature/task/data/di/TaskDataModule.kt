package com.spoonofcode.feature.task.data.di

import com.spoonofcode.feature.task.data.repository.TaskRepositoryImpl
import com.spoonofcode.feature.task.data.remote.RemoteTaskDataSource
import com.spoonofcode.feature.task.domain.repository.TaskRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val taskDataModule = module {
    singleOf(::RemoteTaskDataSource)

    singleOf(::TaskRepositoryImpl).bind<TaskRepository>()
}