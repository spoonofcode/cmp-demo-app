package com.spoonofcode.feature.task.presentation.overview

import com.spoonofcode.core.presentation.base.BaseViewAction

internal sealed interface TaskOverviewViewAction: BaseViewAction {
    data object InitView : TaskOverviewViewAction
}