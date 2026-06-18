package com.spoonofcode.feature.home.presentation

import androidx.lifecycle.viewModelScope
import com.spoonofcode.core.presentation.base.BaseViewModel
import com.spoonofcode.feature.appnavigation.NotificationModuleRoute
import kotlinx.coroutines.launch

internal class HomeViewModel : BaseViewModel<HomeViewState, HomeViewAction, Nothing>() {

    override fun onAction(action: HomeViewAction) {
        when (action) {
            HomeViewAction.InitView -> initView()
            HomeViewAction.NavigateToNotifications -> navigateToNotifications()
        }
    }

    private fun initView() {
    }

    private fun navigateToNotifications() {
        viewModelScope.launch {
            viewModelNavigator.push(NotificationModuleRoute.NotificationOverview)
        }
    }
}
