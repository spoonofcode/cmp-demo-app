package com.spoonofcode.feature.home.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mohamedrejeb.calf.permissions.ExperimentalPermissionsApi
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.StandardScreen
import com.spoonofcode.core.presentation.base.StandardScreenPreview
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalPermissionsApi::class)
@Composable
internal fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    backNavigationEnable: Boolean = false,
) {
    StandardScreen(
        viewModel = viewModel,
        title = "Home",
        backNavigationEnable = backNavigationEnable,
        topBarActions = { onAction ->
            listOf(
                TopBarAction(
                    icon = Icons.Default.Notifications,
                    description = "Notification",
                    badgeCount = 9,
                    onClick = { onAction(HomeViewAction.NavigateToNotifications) }
                )
            )
        }
    ) { _, _ ->
        Texts.BL("HOME")
    }
}

@Preview
@Composable
private fun HomeScreenContentPreview() {
    StandardScreenPreview(
        viewState = HomeViewState(),
        title = "Home",
        backNavigationEnable = false
    ) {
        Texts.BL("HOME")
    }
}
