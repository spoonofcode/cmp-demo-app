package com.spoonofcode.feature.appnavigation

sealed class ProfileModuleRoute : ModuleRoute() {
    object Home : ProfileModuleRoute()
    object ProfileDetails : ProfileModuleRoute()
    object ProfileEdit : ProfileModuleRoute()
}
