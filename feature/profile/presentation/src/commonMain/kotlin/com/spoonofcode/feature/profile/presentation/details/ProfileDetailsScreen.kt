package com.spoonofcode.feature.profile.presentation.details

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.spoonofcode.core.designsystem.components.text.Texts
import com.spoonofcode.core.presentation.base.BaseScreen
import com.spoonofcode.feature.profile.domain.model.Profile
import com.spoonofcode.feature.profile.presentation.ProfilePreviewParameterProvider
import com.spoonofcode.feature.profile.presentation.Res
import com.spoonofcode.feature.profile.presentation.profile
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

internal class ProfileDetailsScreen(
    override val backNavigationEnable: Boolean = false,
) : BaseScreen<ProfileDetailsViewModel, ProfileDetailsViewState, ProfileDetailsViewAction, Nothing>() {

    @Composable
    override fun provideTopAppBarTitle() = stringResource(Res.string.profile)

    @Composable
    override fun provideViewModel() = koinViewModel<ProfileDetailsViewModel>()

    @Composable
    override fun ColumnScope.ScreenContent(
        viewState: ProfileDetailsViewState,
        onAction: (ProfileDetailsViewAction) -> Unit,
    ) {
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
    ProfileDetailsScreen().PreviewContent(
        ProfileDetailsViewState(
            profile = profile,
        )
    )
}
// endregion
