import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.Navigator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.spoonofcode.core.presentation.navigation.NavigationHandler
import com.spoonofcode.core.presentation.navigation.ViewModelNavigator
import com.spoonofcode.feature.appnavigation.HomeModuleRoute
import com.spoonofcode.feature.appnavigation.ProfileModuleRoute
import com.spoonofcode.feature.appnavigation.TaskModuleRoute
import com.spoonofcode.feature.home.presentation.homeModuleRouteResolver
import com.spoonofcode.feature.notification.presentation.notificationModuleRouteResolver
import com.spoonofcode.feature.profile.presentation.profileModuleRouteResolver
import com.spoonofcode.feature.task.presentation.taskModuleRouteResolver
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import org.koin.compose.getKoin

private val navSavedStateConfiguration = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(HomeModuleRoute.Home::class)
            subclass(ProfileModuleRoute.Home::class)
            subclass(ProfileModuleRoute.ProfileDetails::class)
            subclass(ProfileModuleRoute.ProfileEdit::class)
            subclass(TaskModuleRoute.TaskOverview::class)
        }
    }
}

@Composable
fun MainAppScreen() {
    // 1. Inicjalizacja back stacku z ekranem startowym (Home)
    val backStack = rememberNavBackStack(
        configuration = navSavedStateConfiguration,
        HomeModuleRoute.Home
    )

    val navigator = remember { Navigator(backStack) }

    val viewModelNavigator: ViewModelNavigator by getKoin().inject()
    NavigationHandler(
        navigationFlow = viewModelNavigator.navigationEvents,
        navigator = navigator,
    )

    // Pobieramy aktualny ekran (ostatni element na stosie)
    val currentScreen = backStack.lastOrNull() ?: HomeModuleRoute.Home

    Scaffold(
        containerColor = Color.Red,
        bottomBar = {
            NavigationBar(
                windowInsets = WindowInsets(0, 0, 0, 0)
            ) {
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
                    icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Tasks") }
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
            modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()),
            entryProvider = entryProvider {
                homeModuleRouteResolver()
                profileModuleRouteResolver()
                notificationModuleRouteResolver()
                taskModuleRouteResolver()
            }
        )
    }
}
