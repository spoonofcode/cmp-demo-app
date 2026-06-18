package com.spoonofcode.core.designsystem.components.appbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.spoonofcode.core.designsystem.components.icons.CustomIcons
import com.spoonofcode.core.designsystem.components.text.Texts

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(
    backNavigationEnable: Boolean,
    topAppBarTitle: String,
    navigationBackAction: () -> Unit,
    iconBarActions: List<TopBarAction>,
) {
    CenterAlignedTopAppBar(
        title = { Texts.TLB(topAppBarTitle) },
        navigationIcon = if (backNavigationEnable) {
            {
                IconButton(onClick = navigationBackAction) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            {}
        },
        actions = {
            iconBarActions.forEach { iconBarAction ->
                if (iconBarAction.badgeCount == null || iconBarAction.badgeCount == 0) {
                    IconButton(onClick = iconBarAction.onClick) {
                        Icon(
                            imageVector = iconBarAction.icon,
                            contentDescription = iconBarAction.description
                        )
                    }
                } else {
                    CustomIcons.IconWithBadge(
                        icon = iconBarAction.icon,
                        contentDescription = iconBarAction.description,
                        count = iconBarAction.badgeCount,
                        onClick = iconBarAction.onClick
                    )
                }
            }
        }
    )
}

@Immutable
data class TopBarAction(
    val icon: ImageVector,
    val description: String,
    val badgeCount: Int? = null,
    val onClick: () -> Unit
)
