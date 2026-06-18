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
import androidx.compose.ui.Modifier
import androidx.navigation3.NavDisplay
import androidx.navigation3.rememberNavBackStack
import androidx.navigation3.entryProvider
import androidx.navigation3.runtime.NavKey
import com.spoonofcode.feature.home.presentation.homeModuleRouteResolver
import com.spoonofcode.feature.profile.presentation.profileModuleRouteResolver
import com.spoonofcode.feature.task.presentation.taskModuleRouteResolver
import com.spoonofcode.feature.appnavigation.HomeModuleRoute
import com.spoonofcode.feature.appnavigation.ProfileModuleRoute
import com.spoonofcode.feature.appnavigation.TaskModuleRoute

@Composable
fun MainAppScreen() {
    // 1. Inicjalizacja back stacku z ekranem startowym (Home)
    val backStack = rememberNavBackStack(initialDestination = HomeModuleRoute.Home as NavKey)

    // Pobieramy aktualny ekran (ostatni element na stosie)
    val currentScreen = backStack.lastOrNull() ?: HomeModuleRoute.Home

    Scaffold(
        bottomBar = {
            NavigationBar {
                // TAB 1: HOME
                NavigationBarItem(
                    selected = currentScreen is HomeModuleRoute.Home,
                    onClick = {
                        // W nawigacji dolnej czyścimy stos i ustawiamy dany ekran jako jedyny root
                        backStack.clear()
                        backStack.add(HomeModuleRoute.Home)
                    },
                    label = { Text("Home") },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
                )

                // TAB 2: TASK OVERVIEW
                NavigationBarItem(
                    selected = currentScreen is TaskModuleRoute.TaskOverview,
                    onClick = {
                        backStack.clear()
                        backStack.add(TaskModuleRoute.TaskOverview)
                    },
                    label = { Text("Tasks") },
                    icon = { Icon(Icons.Default.List, contentDescription = "Tasks") }
                )

                // TAB 3: PROFILE
                NavigationBarItem(
                    selected = currentScreen is ProfileModuleRoute.Home,
                    onClick = {
                        backStack.clear()
                        backStack.add(ProfileModuleRoute.Home)
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
            modifier = Modifier.padding(innerPadding),
            entryProvider = entryProvider {
                homeModuleRouteResolver()
                profileModuleRouteResolver()
                taskModuleRouteResolver()
            }
        )
    }
}
