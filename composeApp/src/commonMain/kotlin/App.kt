import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.NavDisplay
import androidx.navigation3.NavEntry
import androidx.navigation3.rememberNavBackStack
import com.spoonofcode.feature.home.presentation.HomeScreen
import features.task.TaskOverviewScreen
import kotlinx.serialization.Serializable

// Definiujemy interfejs lub sealed class dla naszych ekranów
sealed interface Screen {
    @Serializable data object Home : Screen
    @Serializable data object TaskOverview : Screen
    @Serializable data object Profile : Screen
}
@Composable
fun MainAppScreen() {
    // 1. Inicjalizacja back stacku z ekranem startowym (Home)
    val backStack = rememberNavBackStack(initialDestination = Screen.Home)

    // Pobieramy aktualny ekran (ostatni element na stosie)
    val currentScreen = backStack.lastOrNull() ?: Screen.Home

    Scaffold(
        bottomBar = {
            NavigationBar {
                // TAB 1: HOME
                NavigationBarItem(
                    selected = currentScreen is Screen.Home,
                    onClick = {
                        // W nawigacji dolnej czyścimy stos i ustawiamy dany ekran jako jedyny root
                        backStack.clear()
                        backStack.add(Screen.Home)
                    },
                    label = { Text("Home") },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
                )

                // TAB 2: TASK OVERVIEW
                NavigationBarItem(
                    selected = currentScreen is Screen.TaskOverview,
                    onClick = {
                        backStack.clear()
                        backStack.add(Screen.TaskOverview)
                    },
                    label = { Text("Tasks") },
                    icon = { Icon(Icons.Default.List, contentDescription = "Tasks") }
                )

                // TAB 3: PROFILE
                NavigationBarItem(
                    selected = currentScreen is Screen.Profile,
                    onClick = {
                        backStack.clear()
                        backStack.add(Screen.Profile)
                    },
                    label = { Text("Profile") },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") }
                )
            }
        }
    ) { innerPadding ->
        // 2. NavDisplay odpowiada za renderowanie UI na podstawie zawartości back stacku
        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding)
            entryProvider = entryProvider {
                homeModuleRouteResolver()
                profileModuleRouteResolver()
                taskModuleRouteResolver()
            }
        )
    }
}
