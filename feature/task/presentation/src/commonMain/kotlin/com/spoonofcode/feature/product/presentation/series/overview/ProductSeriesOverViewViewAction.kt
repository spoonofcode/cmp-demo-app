package com.spoonofcode.feature.task.presentation.series.overview

import com.spoonofcode.core.presentation.base.BaseViewAction

sealed interface ProductSeriesOverViewViewAction : BaseViewAction {
    data class CheckedProductSeries(val name: String) : ProductSeriesOverViewViewAction
    data object InitView : ProductSeriesOverViewViewAction
    data object NavigateToNotification : ProductSeriesOverViewViewAction
}