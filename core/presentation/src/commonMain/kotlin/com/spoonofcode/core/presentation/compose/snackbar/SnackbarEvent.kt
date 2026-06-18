package com.spoonofcode.core.presentation.compose.snackbar

import androidx.compose.material3.SnackbarDuration
import com.spoonofcode.core.presentation.helpers.UiText

sealed class SnackbarEvent(
    val message: UiText,
    val actionLabel: String? = null,
    val duration: SnackbarDuration,
    val type: SnackbarType,
) {
    data object Offline : SnackbarEvent(
        message = UiText.DynamicString("No internet connection"),
        duration = SnackbarDuration.Indefinite,
        type = SnackbarType.ERROR
    )

    data object Online : SnackbarEvent(
        message = UiText.DynamicString("Internet connection restored"),
        duration = SnackbarDuration.Short,
        type = SnackbarType.INFO
    )

    class Error(
        message: UiText
    ) : SnackbarEvent(
        message = message,
        actionLabel = "OK",
        duration = SnackbarDuration.Indefinite,
        type = SnackbarType.ERROR
    )
    class Success(
        message: UiText
    ) : SnackbarEvent(
        message = message,
        actionLabel = "OK",
        duration = SnackbarDuration.Short,
        type = SnackbarType.SUCCESS
    )
}

enum class SnackbarType {
    INFO,
    ERROR,
    SUCCESS,
}