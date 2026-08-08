package eu.kanade.presentation.more.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.RocketLaunch
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import eu.kanade.tachiyomi.BuildConfig
import eu.kanade.tachiyomi.R
import soup.compose.material.motion.animation.materialSharedAxisX
import soup.compose.material.motion.animation.rememberSlideDistance
import tachiyomi.i18n.MR
import tachiyomi.presentation.core.components.material.padding
import tachiyomi.presentation.core.i18n.stringResource
import tachiyomi.presentation.core.screens.InfoScreen
import androidx.compose.ui.res.stringResource as androidStringResource

@Composable
fun OnboardingScreen(
    showWelcome: Boolean,
    onWelcomeComplete: () -> Unit,
    onComplete: () -> Unit,
    onExit: () -> Unit,
    onRestoreBackup: () -> Unit,
) {
    val slideDistance = rememberSlideDistance()

    var currentStep by rememberSaveable { mutableIntStateOf(0) }
    val setupSteps = remember {
        listOf(
            ThemeStep(),
            StorageStep(),
            PermissionStep(),
            GuidesStep(onRestoreBackup = onRestoreBackup),
        )
    }

    if (showWelcome) {
        YomoriWelcomeScreen(
            onContinue = onWelcomeComplete,
            onExit = onExit,
        )
        return
    }

    val isLastStep = currentStep == setupSteps.lastIndex

    BackHandler(enabled = currentStep != 0) {
        currentStep--
    }

    InfoScreen(
        icon = Icons.Outlined.RocketLaunch,
        headingText = stringResource(MR.strings.onboarding_heading),
        subtitleText = stringResource(MR.strings.onboarding_description),
        acceptText = stringResource(
            if (isLastStep) {
                MR.strings.onboarding_action_finish
            } else {
                MR.strings.onboarding_action_next
            },
        ),
        canAccept = setupSteps[currentStep].isComplete,
        onAcceptClick = {
            if (isLastStep) {
                onComplete()
            } else {
                currentStep++
            }
        },
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = MaterialTheme.padding.small)
                .clip(MaterialTheme.shapes.small)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceVariant),
        ) {
            AnimatedContent(
                targetState = currentStep,
                transitionSpec = {
                    materialSharedAxisX(
                        forward = targetState > initialState,
                        slideDistance = slideDistance,
                    )
                },
                label = "stepContent",
            ) {
                setupSteps[it].Content()
            }
        }
    }
}

@Composable
private fun YomoriWelcomeScreen(
    onContinue: () -> Unit,
    onExit: () -> Unit,
) {
    val uriHandler = LocalUriHandler.current
    var aboutExpanded by rememberSaveable { mutableStateOf(false) }
    var creditsExpanded by rememberSaveable { mutableStateOf(false) }
    var detailCard by rememberSaveable { mutableIntStateOf(0) }

    BackHandler(enabled = true) {
        if (detailCard != 0) {
            detailCard = 0
        }
    }

    if (detailCard != 0) {
        WelcomeDedicatedDetailCard(
            title = when (detailCard) {
                1 -> androidStringResource(
                    R.string.yomori_welcome_changelog_title,
                    BuildConfig.VERSION_NAME,
                )
                2 -> androidStringResource(R.string.yomori_welcome_license_usage_title)
                else -> error("Unknown welcome detail card")
            },
            onBack = { detailCard = 0 },
        ) {
            when (detailCard) {
                1 -> Text(
                    text = androidStringResource(R.string.yomori_welcome_changelog_content),
                    style = MaterialTheme.typography.bodyLarge,
                )
                2 -> {
                    Text(
                        text = androidStringResource(R.string.yomori_welcome_legal_sources),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Text(
                        text = androidStringResource(R.string.yomori_welcome_legal_privacy),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Text(
                        text = androidStringResource(R.string.yomori_welcome_legal_license),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    WelcomeLink(
                        label = androidStringResource(R.string.yomori_welcome_project_license),
                        onClick = { uriHandler.openUri(PROJECT_LICENSE_URL) },
                    )
                    WelcomeLink(
                        label = androidStringResource(R.string.yomori_welcome_privacy),
                        onClick = { uriHandler.openUri(PRIVACY_URL) },
                    )
                    WelcomeLink(
                        label = androidStringResource(R.string.yomori_welcome_security),
                        onClick = { uriHandler.openUri(SECURITY_URL) },
                    )
                    WelcomeLink(
                        label = androidStringResource(R.string.yomori_welcome_avatar_license),
                        onClick = { uriHandler.openUri(AVATAR_LICENSE_URL) },
                    )
                }
            }
        }
        return
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.88f)
                .fillMaxHeight(0.90f)
                .widthIn(max = 520.dp),
            shape = MaterialTheme.shapes.extraLarge,
            color = MaterialTheme.colorScheme.surfaceContainer,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            tonalElevation = 6.dp,
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(top = 24.dp, bottom = 18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.k2040_wolf_avatar),
                        contentDescription = androidStringResource(R.string.yomori_welcome_avatar_content_description),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth(0.30f)
                            .aspectRatio(1f),
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth(0.86f)
                            .padding(bottom = 4.dp),
                        text = androidStringResource(R.string.app_name),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )

                    WelcomeExpandableSection(
                        modifier = Modifier.fillMaxWidth(0.84f),
                        title = androidStringResource(R.string.yomori_welcome_about_title),
                        expanded = aboutExpanded,
                        expandDescription = androidStringResource(R.string.yomori_welcome_expand_about),
                        collapseDescription = androidStringResource(R.string.yomori_welcome_collapse_about),
                        onToggle = { aboutExpanded = !aboutExpanded },
                    ) {
                        Text(
                            text = androidStringResource(R.string.yomori_welcome_description),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                        Text(
                            text = androidStringResource(R.string.yomori_welcome_trust_local),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        Text(
                            text = androidStringResource(R.string.yomori_welcome_trust_sources),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }

                    WelcomeNavigationRow(
                        modifier = Modifier.fillMaxWidth(0.84f),
                        title = androidStringResource(
                            R.string.yomori_welcome_changelog_title,
                            BuildConfig.VERSION_NAME,
                        ),
                        contentDescription = androidStringResource(R.string.yomori_welcome_open_changelog),
                        onClick = { detailCard = 1 },
                    )

                    WelcomeNavigationRow(
                        modifier = Modifier.fillMaxWidth(0.84f),
                        title = androidStringResource(R.string.yomori_welcome_license_usage_title),
                        contentDescription = androidStringResource(R.string.yomori_welcome_open_license_usage),
                        onClick = { detailCard = 2 },
                    )

                    WelcomeNavigationRow(
                        modifier = Modifier.fillMaxWidth(0.84f),
                        title = androidStringResource(R.string.yomori_welcome_support_title),
                        contentDescription = androidStringResource(R.string.yomori_welcome_open_support),
                        onClick = { uriHandler.openUri(KOFI_URL) },
                    )

                    WelcomeExpandableSection(
                        modifier = Modifier.fillMaxWidth(0.84f),
                        title = androidStringResource(R.string.yomori_welcome_credits_title),
                        expanded = creditsExpanded,
                        expandDescription = androidStringResource(R.string.yomori_welcome_expand_credits),
                        collapseDescription = androidStringResource(R.string.yomori_welcome_collapse_credits),
                        onToggle = { creditsExpanded = !creditsExpanded },
                    ) {
                        Text(
                            text = androidStringResource(R.string.yomori_welcome_thanks),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        Text(
                            text = androidStringResource(R.string.yomori_welcome_credits_upstream),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        Text(
                            text = androidStringResource(R.string.yomori_welcome_avatar_attribution),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        WelcomeLink(
                            label = androidStringResource(R.string.yomori_welcome_source_code),
                            onClick = { uriHandler.openUri(SOURCE_URL) },
                        )
                        WelcomeLink(
                            label = androidStringResource(R.string.yomori_welcome_support_scope),
                            onClick = { uriHandler.openUri(SUPPORT_URL) },
                        )
                    }
                }

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(0.90f),
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.84f)
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 14.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(min = 48.dp),
                        onClick = onExit,
                    ) {
                        Text(androidStringResource(R.string.yomori_welcome_exit))
                    }
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(min = 48.dp),
                        onClick = onContinue,
                    ) {
                        Text(androidStringResource(R.string.yomori_welcome_continue))
                    }
                }
            }
        }
    }
}

@Composable
private fun WelcomeNavigationRow(
    modifier: Modifier,
    title: String,
    contentDescription: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceContainer,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
            Icon(
                imageVector = Icons.Outlined.ChevronRight,
                contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Composable
private fun WelcomeDedicatedDetailCard(
    title: String,
    onBack: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.88f)
                .fillMaxHeight(0.90f)
                .widthIn(max = 520.dp),
            shape = MaterialTheme.shapes.extraLarge,
            color = MaterialTheme.colorScheme.surfaceContainer,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            tonalElevation = 6.dp,
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 12.dp, top = 12.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = title,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )
                    TextButton(
                        modifier = Modifier.heightIn(min = 48.dp),
                        onClick = onBack,
                    ) {
                        Text(androidStringResource(R.string.yomori_welcome_detail_back))
                    }
                }

                HorizontalDivider()

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
private fun WelcomeExpandableSection(
    modifier: Modifier = Modifier,
    title: String,
    expanded: Boolean,
    expandDescription: String,
    collapseDescription: String,
    onToggle: () -> Unit,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceContainer,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onToggle)
                    .padding(horizontal = 20.dp, vertical = 18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                )
                Icon(
                    imageVector = if (expanded) Icons.Outlined.ExpandLess else Icons.Outlined.ExpandMore,
                    contentDescription = if (expanded) collapseDescription else expandDescription,
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
            AnimatedVisibility(visible = expanded) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 18.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
private fun WelcomeLink(
    label: String,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp),
        onClick = onClick,
    ) {
        Text(label)
    }
}

private const val SOURCE_URL = "https://github.com/Kamui2040/Yomori"
private const val PROJECT_LICENSE_URL = "https://github.com/Kamui2040/Yomori/blob/main/LICENSE"
private const val PRIVACY_URL = "https://github.com/Kamui2040/Yomori/blob/main/PRIVACY.md"
private const val SECURITY_URL = "https://github.com/Kamui2040/Yomori/blob/main/SECURITY.md"
private const val SUPPORT_URL = "https://github.com/Kamui2040/Yomori/blob/main/SUPPORT.md"
private const val AVATAR_LICENSE_URL = "https://creativecommons.org/licenses/by/4.0/"
private const val KOFI_URL = "https://ko-fi.com/k2040"
