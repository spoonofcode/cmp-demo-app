package com.spoonofcode.core.designsystem.components.snackbar.ext

import androidx.compose.material3.SnackbarHostState
import com.spoonofcode.core.designsystem.components.snackbar.CustomSnackbarVisuals
import com.spoonofcode.core.designsystem.components.snackbar.SnackbarEvent

suspend fun SnackbarHostState.showSnackbar(
    snackbarEvent: SnackbarEvent,
) {
    showSnackbar(
        // TODO Fix this toString()
        CustomSnackbarVisuals(
            message = snackbarEvent.message.toString(),
            actionLabel = snackbarEvent.actionLabel,
            duration = snackbarEvent.duration,
            type = snackbarEvent.type,
        )
    )
}