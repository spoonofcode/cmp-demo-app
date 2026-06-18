package com.spoonofcode.feature.home.presentation

import com.spoonofcode.core.presentation.base.BaseViewAction

internal sealed interface HomeViewAction: BaseViewAction {
    data object InitView : HomeViewAction
}