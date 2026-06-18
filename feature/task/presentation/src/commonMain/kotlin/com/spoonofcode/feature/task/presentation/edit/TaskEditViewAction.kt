package com.spoonofcode.feature.task.presentation.edit

import com.spoonofcode.core.presentation.base.BaseViewAction

internal sealed interface TaskEditViewAction: BaseViewAction {
    data object InitView : TaskEditViewAction
}