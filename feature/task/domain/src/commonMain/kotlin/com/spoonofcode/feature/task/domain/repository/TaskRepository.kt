package com.spoonofcode.feature.task.domain.repository

import com.spoonofcode.feature.task.domain.model.Task

interface TaskRepository {
    suspend fun getTask(): Result<Task>
    suspend fun getTasks(): Result<List<Task>>
//    suspend fun addTask(task: Task): Result<Unit>
//    suspend fun updateTask(task: Task): Result<Unit>
//    suspend fun deleTask(task: Task): Result<Unit>
}
