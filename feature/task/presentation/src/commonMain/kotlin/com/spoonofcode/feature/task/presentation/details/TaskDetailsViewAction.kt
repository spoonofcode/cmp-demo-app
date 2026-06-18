package com.spoonofcode.feature.task.presentation.details

import com.spoonofcode.core.presentation.base.BaseViewAction

internal sealed interface TaskDetailsViewAction: BaseViewAction {
    data object InitView : TaskDetailsViewAction
}