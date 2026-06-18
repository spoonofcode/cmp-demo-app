package com.spoonofcode.feature.product.presentation.overview

import androidx.compose.runtime.Immutable
import com.spoonofcode.core.presentation.base.BaseViewState

@Immutable
internal data class TaskOverviewViewState(
    val title:String = "TASK OVERVIEW"
) : BaseViewState()
