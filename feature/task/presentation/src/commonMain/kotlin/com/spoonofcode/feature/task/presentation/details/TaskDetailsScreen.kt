package com.spoonofcode.feature.task.presentation.details

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.dialog.Dialogs
import com.spoonofcode.core.designsystem.components.previews.DevicePreviews
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.BaseScreen
import com.spoonofcode.feature.task.domain.model.Task
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

internal class TaskDetailsScreen(
    val taskId: String
) : BaseScreen<TaskDetailsViewModel, TaskDetailsViewState, TaskDetailsViewAction, Nothing>() {

    @Composable
    override fun provideTopAppBarTitle() = "TaskDetails"

    @Composable
    override fun provideViewModel() = koinViewModel<TaskDetailsViewModel> {
        parametersOf(taskId)
    }

    @Composable
    override fun provideTopBarActions(
        onAction: (TaskDetailsViewAction) -> Unit,
    ) = listOf(
        TopBarAction(
            icon = Icons.Default.Edit,
            description = "Edit",
            onClick = { onAction(TaskDetailsViewAction.EditTask) },
        ),
        TopBarAction(
            icon = Icons.Default.Delete,
            description = "Delete",
            onClick = {
                onAction(TaskDetailsViewAction.DeleteTask)
            }
        )
    )

    @Composable
    override fun provideDialogs(
        viewState: TaskDetailsViewState,
        onAction: (TaskDetailsViewAction) -> Unit
    ) {
        if (viewState.isDeleteTaskDialogVisible) {
            Dialogs.AlertDialog(
                title = "Delete Task",
                text = "Are you sure you want to delete this task?",
                confirmButtonText = "confirm",
                dismissButtonText = "cancel",
                confirmAction = { onAction(TaskDetailsViewAction.ConfirmDeleteTask) },
                dismissAction = { onAction(TaskDetailsViewAction.CancelDeleteTask) }
            )
        }
    }

    @Composable
    override fun ColumnScope.ScreenContent(
        viewState: TaskDetailsViewState,
        onAction: (TaskDetailsViewAction) -> Unit,
    ) {
        Texts.BL(
            viewState.task.id
        )
        Texts.BL(
            viewState.task.name
        )
        Texts.BL(
            viewState.task.description
        )
    }

}

@Preview
@Composable
private fun TaskDetailsScreenContentPreview() {
    TaskDetailsScreen(
        taskId = "1",
    ).PreviewContent(
        TaskDetailsViewState(
            task = Task(
                id = "1",
                name = "Task 1",
                description = "Description 1",
            )
        )
    )
}
