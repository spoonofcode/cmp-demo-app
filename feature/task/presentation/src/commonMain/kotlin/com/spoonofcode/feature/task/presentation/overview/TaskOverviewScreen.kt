package com.spoonofcode.feature.task.presentation.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spoonofcode.core.designsystem.components.Paddings.spaceBetweenListElements
import com.spoonofcode.core.designsystem.components.card.Cards
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.StandardScreen
import com.spoonofcode.core.presentation.base.StandardScreenPreview
import com.spoonofcode.feature.task.domain.model.Task
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun TaskOverviewScreen(
    viewModel: TaskOverviewViewModel = koinViewModel(),
    backNavigationEnable: Boolean = false,
) {
    StandardScreen(
        viewModel = viewModel,
        title = "TaskOverview",
        backNavigationEnable = backNavigationEnable,
        verticalScrollEnable = false,
    ) { viewState, onAction ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(spaceBetweenListElements)
        ) {
            items(viewState.tasks) { task ->
                TaskItem(
                    item = task,
                    onClick = { onAction(TaskOverviewViewAction.SelectTask(task.id)) }
                )
            }
        }
    }
}

@Composable
fun TaskItem(
    item: Task,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Cards.ElevatedCard(
            onClick = onClick
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Texts.TM(
                        text = item.id,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Texts.TM(
                        text = item.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Texts.BM(
                        text = item.description,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun TaskOverviewScreenContentPreview() {
    StandardScreenPreview(
        viewState = TaskOverviewViewState(tasks = emptyList()),
        title = "TaskOverview",
        backNavigationEnable = false
    ) { viewState ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(spaceBetweenListElements)
        ) {
            items(viewState.tasks) { task ->
                TaskItem(
                    item = task,
                    onClick = { }
                )
            }
        }
    }
}
