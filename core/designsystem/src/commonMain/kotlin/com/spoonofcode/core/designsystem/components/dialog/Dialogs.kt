package com.spoonofcode.core.designsystem.components.dialog

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.spoonofcode.core.designsystem.components.button.Buttons
import com.spoonofcode.core.designsystem.components.text.Texts

object Dialogs {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AlertDialog(
        title: String,
        text: String,
        confirmButtonText: String,
        dismissButtonText: String,
        confirmAction: () -> Unit,
        dismissAction: () -> Unit,
    ) {
        androidx.compose.material3.AlertDialog(
            onDismissRequest = dismissAction,
            title = { Texts.TLB(title) },
            text = { Texts.BM(text) },
            confirmButton = {
                Buttons.PrimaryButton(
                    text = confirmButtonText,
                    onClick = confirmAction
                )
            },
            dismissButton = {
                Buttons.SecondaryButton(
                    text = dismissButtonText,
                    onClick = dismissAction
                )
            }
        )
    }
}