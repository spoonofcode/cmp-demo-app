package com.spoonofcode.feature.home.presentation

import androidx.compose.runtime.Immutable
import com.spoonofcode.core.presentation.base.BaseViewState

@Immutable
internal data class HomeViewState(
    val title:String = "HOME"
) : BaseViewState()
