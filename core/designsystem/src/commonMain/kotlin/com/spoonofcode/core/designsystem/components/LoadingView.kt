package com.spoonofcode.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.spoonofcode.core.designsystem.Res
import com.spoonofcode.core.designsystem.components.icons.CustomIcons
import com.spoonofcode.core.designsystem.taggy_go_logo
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun LoadingView(
    iconRes: DrawableResource = Res.drawable.taggy_go_logo,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(Paddings.screenPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomIcons.PulsatingIcon(iconRes = iconRes)
    }
}
