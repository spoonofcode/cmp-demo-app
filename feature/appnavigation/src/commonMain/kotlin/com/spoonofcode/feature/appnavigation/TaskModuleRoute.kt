package com.spoonofcode.feature.appnavigation

sealed class TaskModuleRoute : ModuleRoute() {
    object TaskOverview : TaskModuleRoute()
}
