package com.spoonofcode.feature.notification.presentation.overview

import com.spoonofcode.core.presentation.base.BaseViewModel
import com.spoonofcode.feature.notification.domain.usecase.GetNotificationsUseCase

internal class NotificationOverviewViewModel(
    private val getNotificationsUseCase: GetNotificationsUseCase,
) : BaseViewModel<NotificationOverviewViewState, NotificationOverviewViewAction, Nothing>() {

    override fun onAction(action: NotificationOverviewViewAction) {
        when (action) {
            NotificationOverviewViewAction.InitView -> initView()
            is NotificationOverviewViewAction.SelectNotification -> selectNotification(
                notificationId = action.notificationId
            )
        }
    }

    private fun initView() {
//        showLoadingView()
//        viewModelScope.launch {
//            getNotificationsUseCase()
//                .onSuccess {
//                    showContentView {
//                    }
//                }
//                .onFailure {
//                    showErrorView()
//                }
//        }
    }

    private fun selectNotification(notificationId: String) {
//        viewModelScope.launch {
//            viewModelNavigator.push(
//                NotificationDetailsScreen(
//                    notificationId = notificationId
//                )
//            )
//        }
    }
}