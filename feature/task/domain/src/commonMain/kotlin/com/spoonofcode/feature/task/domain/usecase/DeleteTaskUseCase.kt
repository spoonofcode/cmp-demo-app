package com.spoonofcode.feature.task.domain.usecase

import com.spoonofcode.feature.task.domain.repository.TaskRepository

class DeleteTaskUseCase(
    private val taskRepository: TaskRepository,
) {
    suspend operator fun invoke(id: String): Result<Unit> = taskRepository.deleteTask(id)
}