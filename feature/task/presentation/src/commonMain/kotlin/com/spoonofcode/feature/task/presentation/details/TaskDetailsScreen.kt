package com.spoonofcode.feature.task.presentation.details

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.dialog.Dialogs
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.StandardScreen
import com.spoonofcode.core.presentation.base.StandardScreenPreview
import com.spoonofcode.feature.task.domain.model.Task

@Composable
internal fun TaskDetailsScreen(
    viewModel: TaskDetailsViewModel,
) {
    StandardScreen(
        viewModel = viewModel,
        title = "TaskDetails",
        topBarActions = { onAction -> TopBarActions(onAction) },
        dialogs = { viewState, onAction -> Dialogs(viewState.isDeleteTaskDialogVisible, onAction) }
    ) { viewState, _ ->
        Content(viewState)
    }
}

@Composable
private fun Content(viewState: TaskDetailsViewState) {
    Texts.BL(viewState.task.id)
    Texts.BL(viewState.task.name)
    Texts.BL(viewState.task.description)
}

@Composable
private fun Dialogs(
    isDeleteTaskDialogVisible: Boolean,
    onAction: (TaskDetailsViewAction) -> Unit,
) {
    if (isDeleteTaskDialogVisible) {
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

private fun TopBarActions(
    onAction: (TaskDetailsViewAction) -> Unit,
): List<TopBarAction> = listOf(
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

@Preview
@Composable
private fun TaskDetailsScreenContentPreview() {
    StandardScreenPreview(
        viewState = TaskDetailsViewState(
            task = Task(
                id = "1",
                name = "Task 1",
                description = "Description 1",
            )
        ),
        title = "TaskDetails"
    ) { viewState ->
        Content(viewState)
    }
}
