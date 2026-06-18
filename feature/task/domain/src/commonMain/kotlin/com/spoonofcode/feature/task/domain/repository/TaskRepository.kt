package com.spoonofcode.feature.task.domain.repository

import com.spoonofcode.feature.task.domain.model.Task

interface TaskRepository {
    suspend fun getTask(id: String): Result<Task>
    suspend fun getTasks(): Result<List<Task>>
    suspend fun deleteTask(id: String): Result<Unit>
//    suspend fun addTask(task: Task): Result<Unit>
//    suspend fun updateTask(task: Task): Result<Unit>

}
