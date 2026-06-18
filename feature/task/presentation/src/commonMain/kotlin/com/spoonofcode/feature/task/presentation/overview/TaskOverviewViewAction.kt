package com.spoonofcode.feature.product.presentation.overview

import com.spoonofcode.core.presentation.base.BaseViewAction

internal sealed interface TaskOverviewViewAction: BaseViewAction {
    data object InitView : TaskOverviewViewAction
}