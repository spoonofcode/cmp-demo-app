package com.spoonofcode.feature.task.data.remote

import com.spoonofcode.core.network.base.RemoteBaseDataSource
import com.spoonofcode.feature.task.data.remote.model.TaskResponse
import kotlinx.coroutines.delay

class RemoteTaskDataSource : RemoteBaseDataSource(
    collectionName = "api/tasks",
) {

    suspend fun readTask(id: String): Result<TaskResponse> {
        delay(3000)
        return Result.success(
            TaskResponse(
                id = "1",
                name = "Task 1",
                description = "Description 1",
            )
        )
    }

    suspend fun readTasks(): Result<List<TaskResponse>> {
        delay(3000)
        return Result.success(
            listOf(
                TaskResponse(
                    id = "1",
                    name = "Task 1",
                    description = "Description 1",
                ),
                TaskResponse(
                    id = "2",
                    name = "Task 2",
                    description = "Description 2",
                ),
                TaskResponse(
                    id = "3",
                    name = "Task 3",
                    description = "Description 3",
                )
            )
        )
    }

    suspend fun deleteTask(id: String): Result<Unit> {
        delay(3000)
        return Result.success(Unit)
    }

}