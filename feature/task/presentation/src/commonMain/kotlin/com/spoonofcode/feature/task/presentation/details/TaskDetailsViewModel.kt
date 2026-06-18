package com.spoonofcode.feature.task.presentation.details

import com.spoonofcode.core.presentation.base.BaseViewModel

internal class TaskDetailsViewModel(
) : BaseViewModel<TaskDetailsViewState, TaskDetailsViewAction, Nothing>() {

    override fun onAction(action: TaskDetailsViewAction) {
        when (action) {
            TaskDetailsViewAction.InitView -> initView()
        }
    }

    private fun initView() {
    }
}
