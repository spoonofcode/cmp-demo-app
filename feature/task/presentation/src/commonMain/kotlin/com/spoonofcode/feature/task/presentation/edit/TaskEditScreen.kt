package com.spoonofcode.feature.task.presentation.edit

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.StandardScreen
import com.spoonofcode.core.presentation.base.StandardScreenPreview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun TaskEditScreen(
    viewModel: TaskEditViewModel = koinViewModel(),
) {
    StandardScreen(
        viewModel = viewModel,
        title = "TaskEdit",
    ) { _, _ ->
        Texts.BL("TASK Edit")
    }
}

@Preview
@Composable
private fun TaskEditScreenContentPreview() {
    StandardScreenPreview(
        viewState = TaskEditViewState(),
        title = "TaskEdit"
    ) {
        Texts.BL("TASK Edit")
    }
}
