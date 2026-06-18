package com.spoonofcode.feature.task.presentation.details

import androidx.compose.runtime.Immutable
import com.spoonofcode.core.presentation.base.BaseViewState
import com.spoonofcode.feature.task.domain.model.Task

@Immutable
internal data class TaskDetailsViewState(
    val task: Task,
    val isDeleteTaskDialogVisible: Boolean = false,
) : BaseViewState()
