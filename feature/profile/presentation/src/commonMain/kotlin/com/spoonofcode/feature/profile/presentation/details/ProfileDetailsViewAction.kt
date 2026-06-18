package com.spoonofcode.feature.profile.presentation.details

import com.spoonofcode.core.presentation.base.BaseViewAction

internal sealed interface ProfileDetailsViewAction: BaseViewAction {
    data object InitView : ProfileDetailsViewAction
}