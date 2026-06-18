package com.spoonofcode.feature.task.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class TaskResponse(
    val id: String,
    val name: String,
    val description: String,
)