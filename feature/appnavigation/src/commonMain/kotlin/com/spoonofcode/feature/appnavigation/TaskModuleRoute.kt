package com.spoonofcode.feature.appnavigation

import kotlinx.serialization.Serializable

@Serializable
sealed class TaskModuleRoute : ModuleRoute() {
    @Serializable
    object TaskOverview : TaskModuleRoute()

    @Serializable
    data class TaskDetails(val taskId: String) : TaskModuleRoute()

    @Serializable
    object TaskEdit : TaskModuleRoute()
}
