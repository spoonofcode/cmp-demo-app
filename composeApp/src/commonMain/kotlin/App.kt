import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import features.task.TaskOverviewScreen
import kotlinx.serialization.Serializable
import tabs.home.DetailsScreen
import tabs.settings.LegalScreen
import tabs.settings.SettingsScreen

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()
    @Serializable
    data object Settings : Screen()
    @Serializable
    data object Legal : Screen()
    @Serializable
    data class Details(val id: Int) : Screen()
}

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val items = listOf(
            Screen.Home,
            Screen.Settings,
        )

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        val isSelected = when (screen) {
                            is Screen.Home -> currentDestination?.hierarchy?.any { it.route?.contains("Home") == true } == true
                            is Screen.Settings -> currentDestination?.hierarchy?.any { it.route?.contains("Settings") == true } == true
                            else -> false
                        }
                        
                        NavigationBarItem(
                            icon = {
                                val icon = when (screen) {
                                    is Screen.Home -> Icons.Default.Home
                                    is Screen.Settings -> Icons.Default.Settings
                                    else -> Icons.Default.Home
                                }
                                Icon(icon, contentDescription = null)
                            },
                            label = {
                                val title = when (screen) {
                                    is Screen.Home -> "Home"
                                    is Screen.Settings -> "Settings"
                                    else -> ""
                                }
                                Text(title)
                            },
                            selected = isSelected,
                            onClick = {
                                navController.navigate(screen) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable<Screen.Home> {
                    TaskOverviewScreen().Content()
                }
                composable<Screen.Settings> {
                    SettingsScreen().Content(
                        onNavigateToLegal = { navController.navigate(Screen.Legal) }
                    )
                }
                composable<Screen.Legal> {
                    LegalScreen().Content(
                        onBack = { navController.popBackStack() }
                    )
                }
                composable<Screen.Details> { backStackEntry ->
                    val details: Screen.Details = backStackEntry.toRoute()
                    DetailsScreen(id = details.id).Content(
                        onBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}
