package com.spoonofcode.feature.task.presentation.details

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.BaseScreen
import org.koin.compose.viewmodel.koinViewModel

internal class TaskDetailsScreen(
) : BaseScreen<TaskDetailsViewModel, TaskDetailsViewState, TaskDetailsViewAction, Nothing>() {

    @Composable
    override fun provideTopAppBarTitle() = "TaskDetails"

    @Composable
    override fun provideViewModel() = koinViewModel<TaskDetailsViewModel>()

    @Composable
    override fun provideContent(
        viewState: TaskDetailsViewState,
        onAction: (TaskDetailsViewAction) -> Unit,
    ): @Composable (ColumnScope.() -> Unit) {
        return {
            Texts.BL("TASK OVERVIEW")
        }
    }

}

@Preview
@Composable
private fun TaskDetailsScreenContentPreview() {
    TaskDetailsScreen().PreviewContent(TaskDetailsViewState())
}
