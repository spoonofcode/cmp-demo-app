package com.spoonofcode.feature.task.presentation.edit

import androidx.compose.runtime.Immutable
import com.spoonofcode.feature.task.domain.model.Product
import com.spoonofcode.core.presentation.base.BaseViewState

@Immutable
internal data class ProductEditViewState(
    val product: Product? = null
) : BaseViewState()