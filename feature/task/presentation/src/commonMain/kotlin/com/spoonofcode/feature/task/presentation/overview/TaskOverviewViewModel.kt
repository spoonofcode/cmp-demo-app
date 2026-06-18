package com.spoonofcode.feature.product.presentation.overview

import com.spoonofcode.core.presentation.base.BaseViewModel

internal class TaskOverviewViewModel(
) : BaseViewModel<TaskOverviewViewState, TaskOverviewViewAction, Nothing>() {

    override fun onAction(action: TaskOverviewViewAction) {
        when (action) {
            TaskOverviewViewAction.InitView -> initView()
        }
    }

    private fun initView() {
    }
}
