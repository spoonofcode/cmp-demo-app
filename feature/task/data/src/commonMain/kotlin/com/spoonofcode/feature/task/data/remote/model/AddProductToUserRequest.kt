package com.spoonofcode.feature.task.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class AddProductToUserRequest(
    val productId: String,
)