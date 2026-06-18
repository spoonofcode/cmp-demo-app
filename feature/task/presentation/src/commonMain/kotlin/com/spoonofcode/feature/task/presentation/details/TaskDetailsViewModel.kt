package com.spoonofcode.feature.task.presentation.details

import androidx.lifecycle.viewModelScope
import com.spoonofcode.core.designsystem.helpers.UiText
import com.spoonofcode.core.presentation.base.BaseViewModel
import com.spoonofcode.feature.task.domain.usecase.DeleteTaskUseCase
import com.spoonofcode.feature.task.domain.usecase.GetTaskUseCase
import kotlinx.coroutines.launch

internal class TaskDetailsViewModel(
    private val taskId: String,
    private val getTaskUseCase: GetTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : BaseViewModel<TaskDetailsViewState, TaskDetailsViewAction, Nothing>() {

    override val startAction = {
        loadTask(taskId)
    }

    override fun onAction(action: TaskDetailsViewAction) {
        when (action) {
            TaskDetailsViewAction.EditTask -> editTask()
            TaskDetailsViewAction.DeleteTask -> deleteTask()
            TaskDetailsViewAction.CancelDeleteTask -> cancelDeleteTask()
            TaskDetailsViewAction.ConfirmDeleteTask -> confirmDeleteTask()
        }
    }

    private fun loadTask(id: String) {
        showLoadingView()
        viewModelScope.launch {
            getTaskUseCase(id)
                .onSuccess {
                    setContentState(
                        TaskDetailsViewState(
                            task = it,
                        )
                    )
                    showContentView()
                }
                .onFailure {
                    showErrorView()
                }
        }
    }

    private fun editTask() {
    }

    private fun deleteTask() {
        updateContentState {
            copy(
                isDeleteTaskDialogVisible = true
            )
        }
    }

    private fun cancelDeleteTask() {
        updateContentState {
            copy(
                isDeleteTaskDialogVisible = false
            )
        }
    }

    private fun confirmDeleteTask() {
        showLoadingView()
        viewModelScope.launch {
            deleteTaskUseCase(currentContentState().task.id)
                .onSuccess {
                    viewModelNavigator.pop()
                }
                .onFailure {
                    showContentView()
                    showErrorSnackbar(UiText.DynamicString("Something went wrong"))
                }
        }
    }
}
