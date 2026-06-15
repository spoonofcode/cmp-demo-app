package features.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.Task
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

class TaskOverviewScreen {

    @OptIn(KoinExperimentalAPI::class)
    @Composable
    fun Content() {
        val viewModel = koinViewModel<TaskOverviewViewModel>()
        val viewState by viewModel.viewState.collectAsState()

        LaunchedEffect(viewModel) {
            viewModel.updateTasks()
        }

        ContentView(
            viewState = viewState
        )
    }

    @Composable
    internal fun ContentView(
        viewState: TaskOverviewViewState,
    ) {
        var inputText by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = inputText,
                    onValueChange = {
                        inputText = it
                    })
                Button(onClick = {
//                    viewModel.addTask(inputText)
                    inputText = ""
                }) {
                    Text(text = "Add")
                }
            }

            viewState.tasks?.let {
                LazyColumn(
                    content = {
                        itemsIndexed(it) { index: Int, item: Task ->
                            TaskItem(item = item)
                        }
                    }
                )
            } ?: Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "No items yet",
                fontSize = 16.sp
            )


        }
    }
}


@Composable
fun TaskItem(item: Task) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.creationDate.toString(),
                fontSize = 12.sp,
                color = Color.LightGray
            )
            Text(
                text = item.description,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

// region Previews
@Composable
private fun PreviewContentView(viewState: TaskOverviewViewState = TaskOverviewViewState()) {
    TaskOverviewScreen().ContentView(viewState)
}


@Composable
@Preview
private fun TaskOverviewScreenPreview() {
    PreviewContentView()
}
// endregion