package com.spoonofcode.feature.task.presentation.overview

import androidx.lifecycle.viewModelScope
import com.spoonofcode.core.presentation.base.BaseViewModel
import com.spoonofcode.feature.appnavigation.TaskModuleRoute
import com.spoonofcode.feature.task.domain.usecase.GetTasksUseCase
import kotlinx.coroutines.launch

internal class TaskOverviewViewModel(
    private val getTasksUseCase: GetTasksUseCase,
) : BaseViewModel<TaskOverviewViewState, TaskOverviewViewAction, Nothing>() {

    override val startAction = {
        loadTasks()
    }

    override fun onAction(action: TaskOverviewViewAction) {
        when (action) {
            is TaskOverviewViewAction.SelectTask -> selectTask(action.id)
        }
    }

    private fun loadTasks() {
        showLoadingView()
        viewModelScope.launch {
            getTasksUseCase()
                .onSuccess {
                    setContentState(
                        TaskOverviewViewState(
                            tasks = it,
                        )
                    )
                    showContentView()
                }
                .onFailure {
                    showErrorView()
                }
        }
    }

    private fun selectTask(id: String) {
        viewModelScope.launch {
            viewModelNavigator.push(TaskModuleRoute.TaskDetails(taskId = id))
        }
    }
}
