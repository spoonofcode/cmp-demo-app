package com.spoonofcode.feature.home.presentation

import com.spoonofcode.core.presentation.base.BaseViewModel

internal class HomeViewModel(
) : BaseViewModel<HomeViewState, HomeViewAction, Nothing>() {

    override fun onAction(action: HomeViewAction) {
        when (action) {
            HomeViewAction.InitView -> initView()
        }
    }

    private fun initView() {
    }
}
