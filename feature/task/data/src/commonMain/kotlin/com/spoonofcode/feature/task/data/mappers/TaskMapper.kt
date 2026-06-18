package com.spoonofcode.feature.task.data.mappers

import com.spoonofcode.feature.task.data.remote.model.TaskResponse
import com.spoonofcode.feature.task.domain.model.Task

fun TaskResponse.toTask(): Task {
    return Task(
        id = id,
        name = name,
        description = description,
    )
}