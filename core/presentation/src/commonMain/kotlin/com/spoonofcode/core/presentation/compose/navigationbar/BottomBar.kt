package com.spoonofcode.core.presentation.compose.navigationbar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.spoonofcode.core.presentation.compose.text.Texts

data class BottomNavItem(
    val icon: ImageVector,
    val title: String,
)

@Composable
fun BottomBar(
    items: Map<NavKey, BottomNavItem>,
    selectedKey: NavKey,
    onSelectKey: (NavKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    BottomAppBar(
        modifier = modifier,
    ) {
        items.forEach { (topLevelDestination, data) ->
            NavigationBarItem(
                selected = topLevelDestination == selectedKey,
                onClick = {
                    onSelectKey(topLevelDestination)
                },
                icon = {
                    Icon(
                        imageVector = data.icon,
                        contentDescription = data.title,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(width = 24.dp, height = 24.dp)
                    )
                },
                label = {
                    Texts.LM(
                        text = data.title,
                        color = MaterialTheme.colorScheme.secondary,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis,
//                        modifier = Modifier.height(16.dp)
                    )
                }
            )
        }
    }
}