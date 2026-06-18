package com.spoonofcode.feature.task.presentation.edit

import com.spoonofcode.core.presentation.base.BaseViewModel

internal class TaskEditViewModel(
) : BaseViewModel<TaskEditViewState, TaskEditViewAction, Nothing>() {

    override fun onAction(action: TaskEditViewAction) {
        when (action) {
            TaskEditViewAction.InitView -> initView()
        }
    }

    private fun initView() {
    }
}
