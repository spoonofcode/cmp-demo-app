package com.spoonofcode.feature.task.domain.usecase

import com.spoonofcode.feature.task.domain.model.Task
import com.spoonofcode.feature.task.domain.repository.TaskRepository

class GetTaskUseCase(
    private val taskRepository: TaskRepository,
) {
    suspend operator fun invoke(id: String): Result<Task> = taskRepository.getTask(id = id)
}