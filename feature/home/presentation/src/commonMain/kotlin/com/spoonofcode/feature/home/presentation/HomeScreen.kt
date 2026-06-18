package com.spoonofcode.feature.home.presentation

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mohamedrejeb.calf.permissions.ExperimentalPermissionsApi
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.BaseScreen
import org.koin.compose.viewmodel.koinViewModel

internal class HomeScreen(
    override val backNavigationEnable: Boolean = false,
) : BaseScreen<HomeViewModel, HomeViewState, HomeViewAction, Nothing>() {

    @Composable
    override fun provideTopAppBarTitle() = "Home"

    @Composable
    override fun provideTopBarActions(
        onAction: (HomeViewAction) -> Unit
    ) = listOf(
        TopBarAction(
            icon = Icons.Default.Notifications,
            description = "Notification",
            badgeCount = 9,
            onClick = {}
        )
    )

    @Composable
    override fun provideViewModel() = koinViewModel<HomeViewModel>()

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun provideContent(
        viewState: HomeViewState,
        onAction: (HomeViewAction) -> Unit,
    ): @Composable (ColumnScope.() -> Unit) {
        return {
            Texts.BL("HOME")
        }
    }

}

@Preview
@Composable
private fun HomeScreenContentPreview() {
    HomeScreen().PreviewContent(HomeViewState())
}
