package com.spoonofcode.feature.task.presentation.overview

import androidx.compose.runtime.Immutable
import com.spoonofcode.core.presentation.base.BaseViewState
import com.spoonofcode.feature.task.domain.model.Task

@Immutable
internal data class TaskOverviewViewState(
    val tasks: List<Task>,
) : BaseViewState()
