package com.spoonofcode.core.designsystem.components.divider

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.spoonofcode.core.designsystem.components.text.Texts

object Dividers {

    @Composable
    fun LabeledDivider(
        text: String,
        modifier: Modifier = Modifier.Companion,
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
            )

            Texts.BM(text = text)

            HorizontalDivider(
                modifier = Modifier.weight(1f),
            )
        }
    }

}