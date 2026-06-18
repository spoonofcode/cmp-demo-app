package com.spoonofcode.feature.task.presentation.details

import androidx.compose.runtime.Immutable
import com.spoonofcode.core.presentation.base.BaseViewState

@Immutable
internal data class TaskDetailsViewState(
    val title:String = "TASK DETAILS"
) : BaseViewState()
