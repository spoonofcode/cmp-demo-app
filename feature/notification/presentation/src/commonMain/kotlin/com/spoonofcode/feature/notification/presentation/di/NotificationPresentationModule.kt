package com.spoonofcode.feature.notification.presentation.di

import com.spoonofcode.feature.notification.presentation.overview.NotificationOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val notificationPresentationModule = module {
    viewModelOf(::NotificationOverviewViewModel)
}