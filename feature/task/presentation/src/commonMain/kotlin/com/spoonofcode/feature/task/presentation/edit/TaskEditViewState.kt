package com.spoonofcode.feature.task.presentation.edit

import androidx.compose.runtime.Immutable
import com.spoonofcode.core.presentation.base.BaseViewState

@Immutable
internal data class TaskEditViewState(
    val title:String = "TASK EDIT"
) : BaseViewState()
