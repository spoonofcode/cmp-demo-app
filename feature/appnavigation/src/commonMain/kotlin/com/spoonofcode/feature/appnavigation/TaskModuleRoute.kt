package com.spoonofcode.feature.appnavigation

import kotlinx.serialization.Serializable

@Serializable
sealed class TaskModuleRoute : ModuleRoute() {
    @Serializable
    object TaskOverview : TaskModuleRoute()
}
