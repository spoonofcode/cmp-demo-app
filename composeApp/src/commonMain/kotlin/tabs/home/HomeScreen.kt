package tabs.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class HomeScreen {

    @Composable
    fun Content(onNavigateToDetails: (id: Int) -> Unit) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Home")

            Button(onClick = {
                onNavigateToDetails(1)
            }) {
                Text(text = "Go to example details")
            }
        }
    }
}