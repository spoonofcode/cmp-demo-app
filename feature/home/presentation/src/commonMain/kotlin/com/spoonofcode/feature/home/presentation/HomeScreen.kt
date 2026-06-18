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
        topBarActions = { onAction -> TopBarActions(onAction) },
        dialogs = { viewState, onAction -> Dialogs(viewState, onAction) }
    ) { _, _ ->
        Content()
    }
}

@Composable
private fun Content() {
    Texts.BL("HOME")
}

@Composable
private fun Dialogs(
    viewState: HomeViewState,
    onAction: (HomeViewAction) -> Unit,
) {
}

private fun TopBarActions(
    onAction: (HomeViewAction) -> Unit,
): List<TopBarAction> = listOf(
    TopBarAction(
        icon = Icons.Default.Notifications,
        description = "Notification",
        badgeCount = 9,
        onClick = { onAction(HomeViewAction.NavigateToNotifications) }
    )
)

@Preview
@Composable
private fun ScreenContentPreview() {
    StandardScreenPreview(
        viewState = HomeViewState(),
        title = "Home",
        backNavigationEnable = false
    ) {
        Content()
    }
}
