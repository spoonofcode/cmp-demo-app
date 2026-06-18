package com.spoonofcode.feature.profile.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.StandardScreen
import com.spoonofcode.core.presentation.base.StandardScreenPreview
import com.spoonofcode.feature.profile.domain.model.Profile
import com.spoonofcode.feature.profile.presentation.ProfilePreviewParameterProvider
import com.spoonofcode.feature.profile.presentation.Res
import com.spoonofcode.feature.profile.presentation.profile
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun ProfileDetailsScreen(
    viewModel: ProfileDetailsViewModel = koinViewModel(),
    backNavigationEnable: Boolean = false,
) {
    StandardScreen(
        viewModel = viewModel,
        title = stringResource(Res.string.profile),
        backNavigationEnable = backNavigationEnable,
    ) { _, _ ->
        Texts.BL("PROFILE")
    }
}

// region previews
@Preview
@Composable
private fun ProfileScreenContentPreview(
    @PreviewParameter(ProfilePreviewParameterProvider::class)
    profile: Profile,
) {
    StandardScreenPreview(
        viewState = ProfileDetailsViewState(profile = profile),
        title = "Profile",
        backNavigationEnable = false
    ) {
        Texts.BL("PROFILE")
    }
}
// endregion
