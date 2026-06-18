package com.spoonofcode.feature.task.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class TaskRequest(
    val name: String,
    val description: String,
)