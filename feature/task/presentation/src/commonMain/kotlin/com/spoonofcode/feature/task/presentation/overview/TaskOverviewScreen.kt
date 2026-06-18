package com.spoonofcode.feature.task.presentation.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spoonofcode.core.designsystem.components.Paddings.spaceBetweenListElements
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.card.Cards
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.BaseScreen
import com.spoonofcode.feature.task.domain.model.Task
import org.koin.compose.viewmodel.koinViewModel

internal class TaskOverviewScreen(
    override val backNavigationEnable: Boolean = false,
    override val verticalScrollEnable: Boolean = false,
) : BaseScreen<TaskOverviewViewModel, TaskOverviewViewState, TaskOverviewViewAction, Nothing>() {

    @Composable
    override fun provideTopAppBarTitle() = "TaskOverview"

    @Composable
    override fun provideViewModel() = koinViewModel<TaskOverviewViewModel>()

    @Composable
    override fun provideContent(
        viewState: TaskOverviewViewState,
        onAction: (TaskOverviewViewAction) -> Unit,
    ): @Composable (ColumnScope.() -> Unit) {
        return {
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
}

@Preview
@Composable
private fun TaskOverviewScreenContentPreview() {
    TaskOverviewScreen().PreviewContent(
        TaskOverviewViewState(
            tasks = emptyList()
        )
    )
}
