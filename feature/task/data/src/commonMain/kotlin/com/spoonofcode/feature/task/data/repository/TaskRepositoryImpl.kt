package com.spoonofcode.feature.task.data.repository

import com.spoonofcode.feature.task.data.remote.RemoteTaskDataSource
import com.spoonofcode.feature.task.domain.repository.TaskRepository

class TaskRepositoryImpl(
    private val remoteTaskDataSource: RemoteTaskDataSource,
) : TaskRepository {

}