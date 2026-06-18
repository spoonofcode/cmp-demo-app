package com.spoonofcode.feature.profile.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.spoonofcode.core.designsystem.components.appbar.TopBarAction
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.StandardScreen
import com.spoonofcode.core.presentation.base.StandardScreenPreview
import com.spoonofcode.feature.profile.domain.model.Profile
import com.spoonofcode.feature.profile.presentation.ProfilePreviewParameterProvider
import com.spoonofcode.feature.profile.presentation.Res
import com.spoonofcode.feature.profile.presentation.profile
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun ProfileDetailsScreen(
    viewModel: ProfileDetailsViewModel,
    backNavigationEnable: Boolean = false,
) {
    StandardScreen(
        viewModel = viewModel,
        title = stringResource(Res.string.profile),
        backNavigationEnable = backNavigationEnable,
        topBarActions = { onAction -> TopBarActions(onAction) },
        dialogs = { viewState, onAction -> Dialogs(viewState, onAction) }
    ) { viewState, onAction ->
        Content(viewState, onAction)
    }
}

@Composable
private fun Content(
    viewState: ProfileDetailsViewState,
    onAction: (ProfileDetailsViewAction) -> Unit,
) {
    Texts.BL("PROFILE")
}

@Composable
private fun Dialogs(
    viewState: ProfileDetailsViewState,
    onAction: (ProfileDetailsViewAction) -> Unit,
) {
}

private fun TopBarActions(
    onAction: (ProfileDetailsViewAction) -> Unit,
): List<TopBarAction> = emptyList()

// region previews
@Preview
@Composable
private fun ScreenContentPreview(
    @PreviewParameter(ProfilePreviewParameterProvider::class)
    profile: Profile,
) {
    StandardScreenPreview(
        viewState = ProfileDetailsViewState(profile = profile),
        title = "Profile",
        backNavigationEnable = false
    ) { viewState ->
        Content(
            viewState = viewState,
            onAction = {}
        )
    }
}
// endregion
