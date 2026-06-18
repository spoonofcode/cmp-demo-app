package com.spoonofcode.feature.task.presentation.edit

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.BaseScreen
import org.koin.compose.viewmodel.koinViewModel

internal class TaskEditScreen(
) : BaseScreen<TaskEditViewModel, TaskEditViewState, TaskEditViewAction, Nothing>() {

    @Composable
    override fun provideTopAppBarTitle() = "TaskEdit"

    @Composable
    override fun provideViewModel() = koinViewModel<TaskEditViewModel>()

    @Composable
    override fun ColumnScope.ScreenContent(
        viewState: TaskEditViewState,
        onAction: (TaskEditViewAction) -> Unit,
    ) {
        Texts.BL("TASK Edit")
    }

}

@Preview
@Composable
private fun TaskEditScreenContentPreview() {
    TaskEditScreen().PreviewContent(TaskEditViewState())
}
