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
                ),
                TaskResponse(
                    id = "4",
                    name = "Task 4",
                    description = "Description 4",
                ),
                TaskResponse(
                    id = "5",
                    name = "Task 5",
                    description = "Description 5",
                ),
                TaskResponse(
                    id = "6",
                    name = "Task 6",
                    description = "Description 6",
                ),
                TaskResponse(
                    id = "7",
                    name = "Task 7",
                    description = "Description 7",
                ),
                TaskResponse(
                    id = "8",
                    name = "Task 8",
                    description = "Description 8",
                ),
                TaskResponse(
                    id = "9",
                    name = "Task 9",
                    description = "Description 9",
                ),
                TaskResponse(
                    id = "10",
                    name = "Task 10",
                    description = "Description 10",
                ),
            )
        )
    }

    suspend fun deleteTask(id: String): Result<Unit> {
        delay(3000)
        return Result.success(Unit)
    }

}