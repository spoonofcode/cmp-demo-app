package com.spoonofcode.feature.profile.presentation.details

import com.spoonofcode.core.presentation.base.BaseViewModel

internal class ProfileDetailsViewModel(
) : BaseViewModel<ProfileDetailsViewState, ProfileDetailsViewAction, Nothing>(
) {

    override fun onAction(action: ProfileDetailsViewAction) {
        when (action) {
            ProfileDetailsViewAction.InitView -> initView()
        }
    }

    private fun initView() {
    }
}