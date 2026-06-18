package com.spoonofcode.feature.task.domain.usecase

import com.spoonofcode.feature.task.domain.model.Task
import com.spoonofcode.feature.task.domain.repository.TaskRepository


class GetTasksUseCase(
    private val taskRepository: TaskRepository,
) {
    suspend operator fun invoke(): Result<List<Task>> = taskRepository.getTasks()
}