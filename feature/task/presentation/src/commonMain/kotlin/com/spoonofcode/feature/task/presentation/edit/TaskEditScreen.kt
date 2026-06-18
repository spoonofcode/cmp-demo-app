package com.spoonofcode.feature.task.presentation.edit

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.StandardScreen
import com.spoonofcode.core.presentation.base.StandardScreenPreview

@Composable
internal fun TaskEditScreen(
    viewModel: TaskEditViewModel,
) {
    StandardScreen(
        viewModel = viewModel,
        title = "TaskEdit",
        topBarActions = { onAction -> TopBarActions(onAction) },
        dialogs = { viewState, onAction -> Dialogs(viewState, onAction) }
    ) { viewState, onAction ->
        Content(viewState, onAction)
    }
}

@Composable
private fun Content(
    viewState: TaskEditViewState,
    onAction: (TaskEditViewAction) -> Unit,
) {
    Texts.BL("TASK Edit")
}

@Composable
private fun Dialogs(
    viewState: TaskEditViewState,
    onAction: (TaskEditViewAction) -> Unit,
) {
}

private fun TopBarActions(
    onAction: (TaskEditViewAction) -> Unit,
): List<TopBarAction> = emptyList()

@Preview
@Composable
private fun ScreenContentPreview() {
    StandardScreenPreview(
        viewState = TaskEditViewState(),
        title = "TaskEdit"
    ) { viewState ->
        Content(
            viewState = viewState,
            onAction = {}
        )
    }
}
