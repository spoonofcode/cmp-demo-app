package com.spoonofcode.feature.product.presentation.overview

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spoonofcode.core.presentation.base.BaseScreen
import com.spoonofcode.core.presentation.compose.text.Texts
import com.spoonofcode.core.presentation.compose.appbar.TopBarAction
import org.koin.compose.viewmodel.koinViewModel

internal class TaskOverviewScreen(
    override val backNavigationEnable: Boolean = false,
) : BaseScreen<TaskOverviewViewModel, TaskOverviewViewState, TaskOverviewViewAction, Nothing>() {

    @Composable
    override fun provideTopAppBarTitle() = "TaskOverview"

    @Composable
    override fun provideTopBarActions(
        onAction: (TaskOverviewViewAction) -> Unit
    ) = listOf(
        TopBarAction(
            icon = Icons.Default.Notifications,
            description = "Notification",
            badgeCount = 9,
            onClick = {}
        )
    )

    @Composable
    override fun provideViewModel() = koinViewModel<TaskOverviewViewModel>()

    @Composable
    override fun provideContent(
        viewState: TaskOverviewViewState,
        onAction: (TaskOverviewViewAction) -> Unit,
    ): @Composable (ColumnScope.() -> Unit) {
        return {
            Texts.BL("TASK OVERVIEW")
        }
    }

}

@Preview
@Composable
private fun TaskOverviewScreenContentPreview() {
    TaskOverviewScreen().PreviewContent(TaskOverviewViewState())
}
