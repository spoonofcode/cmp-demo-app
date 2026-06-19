package com.spoonofcode.feature.notification.presentation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.spoonofcode.feature.appnavigation.NotificationModuleRoute
import com.spoonofcode.feature.notification.presentation.overview.NotificationOverviewScreen
import org.koin.compose.viewmodel.koinViewModel


fun EntryProviderScope<NavKey>.notificationModuleRouteResolver() {
    entry<NotificationModuleRoute.NotificationOverview> {
        NotificationOverviewScreen(
            viewModel = koinViewModel()
        )
    }
}