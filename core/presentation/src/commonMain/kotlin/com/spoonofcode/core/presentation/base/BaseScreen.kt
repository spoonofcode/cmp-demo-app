package com.spoonofcode.core.presentation.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.spoonofcode.core.designsystem.components.ErrorView
import com.spoonofcode.core.designsystem.components.LoadingView
import com.spoonofcode.core.designsystem.components.Paddings
import com.spoonofcode.core.designsystem.components.appbar.TopBar
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.snackbar.Snackbar
import com.spoonofcode.core.designsystem.components.snackbar.setSnackbarHostState
import com.spoonofcode.core.designsystem.ext.addIf
import com.spoonofcode.core.designsystem.theme.AppTheme
import kotlinx.coroutines.flow.SharedFlow

abstract class BaseScreen<VM : BaseViewModel<VS, VA, VE>, VS : BaseViewState, VA : BaseViewAction, VE : BaseViewEvent>(
    protected open val backNavigationEnable: Boolean = true,
    protected open val verticalScrollEnable: Boolean = true,
    protected open val respectScaffoldImePadding: Boolean = false,
    protected open val customBottomScaffoldInnerPadding: Dp? = null,
) {
    protected open fun provideContentPadding(): PaddingValues = PaddingValues(
        start = Paddings.screenPadding,
        end = Paddings.screenPadding,
        bottom = Paddings.screenPadding,
    )

    protected open fun provideNavigationBackAction(
        onAction: (VA) -> Unit,
    ): (() -> Unit)? = null

    @Composable
    protected open fun provideTopAppBarTitle(): String? = null

    @Composable
    protected open fun provideTopBar(
        onAction: (VA) -> Unit,
        navigationBackAction: () -> Unit,
    ) {
        TopBar(
            backNavigationEnable = backNavigationEnable,
            topAppBarTitle = provideTopAppBarTitle() ?: "",
            navigationBackAction = navigationBackAction,
            iconBarActions = provideTopBarActions(onAction)
        )
    }

    @Composable
    protected open fun provideContentBackgroundColor(): Color = MaterialTheme.colorScheme.background

    @Composable
    protected open fun provideTopBarActions(
        onAction: (VA) -> Unit,
    ): List<TopBarAction> = emptyList()

    @Composable
    protected open fun provideLoadingView() {
        LoadingView()
    }

    @Composable
    protected open fun provideDialogs(viewState: VS, onAction: (VA) -> Unit) {}

    @Composable
    protected open fun provideBottomSheets(viewState: VS, onAction: (VA) -> Unit) {}

    @Composable
    protected open fun provideBottomBar(viewState: VS, onAction: (VA) -> Unit) {}

    @Composable
    protected open fun provideViewEvents(viewEvent: SharedFlow<VE>, onAction: (VA) -> Unit) {}

    @Composable
    protected abstract fun provideViewModel(): VM

    @Composable
    protected abstract fun ColumnScope.ScreenContent(viewState: VS, onAction: (VA) -> Unit)

    @Composable
    fun Content() {
        val viewModel = provideViewModel()
        val viewState by viewModel.viewState.collectAsStateWithLifecycle()
        val snackbarHostState = remember { SnackbarHostState() }

        setSnackbarHostState(snackbarHostState, viewModel.snackbarEvent)
        provideViewEvents(viewModel.viewEvent, viewModel::onAction)

        val navigationBackAction = provideNavigationBackAction(viewModel::onAction) ?: { viewModel.navigateBack() }

        Scaffold(
            modifier = Modifier
                .addIf(respectScaffoldImePadding) { imePadding() }
                .fillMaxSize(),
            topBar = {
                provideTopBar(
                    onAction = viewModel::onAction,
                    navigationBackAction = navigationBackAction
                )
            },
            bottomBar = {
                (viewState as? ViewState.Content)?.data?.let {
                    provideBottomBar(it, viewModel::onAction)
                }
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState) {
                    Snackbar(snackbarData = it)
                }
            }
        ) { innerPadding ->
            val layoutDirection = LocalLayoutDirection.current
            Box(
                modifier = Modifier
                    .padding(
                        start = innerPadding.calculateStartPadding(layoutDirection),
                        top = innerPadding.calculateTopPadding(),
                        end = innerPadding.calculateEndPadding(layoutDirection),
                        bottom = customBottomScaffoldInnerPadding ?: innerPadding.calculateBottomPadding()
                    )
                    .fillMaxSize()
            ) {
                when (val state = viewState) {
                    ViewState.Initial -> {}
                    ViewState.Loading -> provideLoadingView()
                    ViewState.Error -> ErrorView(reload = { viewModel.onStartAction() })
                    is ViewState.Content -> {
                        provideDialogs(state.data, viewModel::onAction)
                        provideBottomSheets(state.data, viewModel::onAction)

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(provideContentBackgroundColor())
                                .addIf(verticalScrollEnable) {
                                    verticalScroll(rememberScrollState())
                                }
                                .padding(provideContentPadding()),
                            verticalArrangement = Arrangement.spacedBy(Paddings.fieldsPadding)
                        ) {
                            ScreenContent(state.data, viewModel::onAction)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun PreviewContent(viewState: VS) {
        AppTheme {
            Scaffold(
                topBar = {
                    TopBar(
                        backNavigationEnable = backNavigationEnable,
                        topAppBarTitle = provideTopAppBarTitle() ?: "",
                        navigationBackAction = {},
                        iconBarActions = emptyList()
                    )
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(provideContentBackgroundColor())
                            .padding(provideContentPadding()),
                        verticalArrangement = Arrangement.spacedBy(Paddings.fieldsPadding)
                    ) {
                        ScreenContent(viewState, {})
                    }
                }
            }
        }
    }
}
