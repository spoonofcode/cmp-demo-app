package com.spoonofcode.feature.task.data.repository

import com.spoonofcode.feature.task.data.mappers.toTask
import com.spoonofcode.feature.task.data.remote.RemoteTaskDataSource
import com.spoonofcode.feature.task.domain.model.Task
import com.spoonofcode.feature.task.domain.repository.TaskRepository

class TaskRepositoryImpl(
    private val remoteTaskDataSource: RemoteTaskDataSource,
) : TaskRepository {
    override suspend fun getTask(id: String): Result<Task> =
        remoteTaskDataSource.readTask(id).map { it.toTask() }

    override suspend fun getTasks(): Result<List<Task>> =
        remoteTaskDataSource.readTasks().map { list -> list.map { it.toTask() } }
}