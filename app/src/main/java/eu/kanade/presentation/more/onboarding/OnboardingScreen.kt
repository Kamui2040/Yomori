package eu.kanade.presentation.more.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.RocketLaunch
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material.icons.outlined.VisibilityOff
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource as androidStringResource
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

@Composable
fun OnboardingScreen(
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

    if (currentStep == 0) {
        YomoriWelcomeScreen(
            onContinue = { currentStep = 1 },
            onExit = onExit,
        )
        return
    }

    val setupStepIndex = currentStep - 1
    val isLastStep = setupStepIndex == setupSteps.lastIndex

    BackHandler(enabled = currentStep > 0) {
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
        canAccept = setupSteps[setupStepIndex].isComplete,
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
                targetState = setupStepIndex,
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
    var versionExpanded by rememberSaveable { mutableStateOf(false) }
    var legalExpanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            DeveloperAvatarPlaceholder()

            Text(
                text = androidStringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

            Text(
                text = androidStringResource(R.string.yomori_welcome_description),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.surfaceContainerHigh,
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    TrustRow(
                        icon = Icons.Outlined.Shield,
                        text = androidStringResource(R.string.yomori_welcome_trust_local),
                    )
                    TrustRow(
                        icon = Icons.Outlined.VisibilityOff,
                        text = androidStringResource(R.string.yomori_welcome_trust_sources),
                    )
                }
            }

            WelcomeExpandableSection(
                title = androidStringResource(
                    R.string.yomori_welcome_version,
                    BuildConfig.VERSION_NAME,
                ),
                expanded = versionExpanded,
                expandDescription = androidStringResource(R.string.yomori_welcome_expand_version),
                collapseDescription = androidStringResource(R.string.yomori_welcome_collapse_version),
                onToggle = { versionExpanded = !versionExpanded },
            ) {
                Text(
                    text = androidStringResource(
                        R.string.yomori_welcome_version_details,
                        BuildConfig.COMMIT_COUNT,
                        BuildConfig.COMMIT_SHA,
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

            WelcomeExpandableSection(
                title = androidStringResource(R.string.yomori_welcome_legal_title),
                expanded = legalExpanded,
                expandDescription = androidStringResource(R.string.yomori_welcome_expand_legal),
                collapseDescription = androidStringResource(R.string.yomori_welcome_collapse_legal),
                onToggle = { legalExpanded = !legalExpanded },
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        TextButton(
                            onClick = { uriHandler.openUri("https://github.com/Kamui2040/Yomori") },
                        ) {
                            Text(androidStringResource(R.string.yomori_welcome_source_code))
                        }
                        TextButton(
                            onClick = { uriHandler.openUri("https://github.com/Kamui2040/Yomori/blob/main/PRIVACY.md") },
                        ) {
                            Text(androidStringResource(R.string.yomori_welcome_privacy))
                        }
                    }
                }
            }

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { uriHandler.openUri("https://ko-fi.com/k2040") },
            ) {
                Text(androidStringResource(R.string.yomori_welcome_support))
            }

            Text(
                text = androidStringResource(R.string.yomori_welcome_thanks),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }

        HorizontalDivider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onExit,
            ) {
                Text(androidStringResource(R.string.yomori_welcome_exit))
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = onContinue,
            ) {
                Text(androidStringResource(R.string.yomori_welcome_continue))
            }
        }
    }
}

@Composable
private fun DeveloperAvatarPlaceholder() {
    Surface(
        shape = CircleShape,
        color = MaterialTheme.colorScheme.surfaceContainerHigh,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Box(
            modifier = Modifier.size(136.dp),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = androidStringResource(R.string.yomori_welcome_avatar_pending),
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(72.dp),
            )
        }
    }
}

@Composable
private fun TrustRow(
    icon: ImageVector,
    text: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(28.dp),
        )
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
private fun WelcomeExpandableSection(
    title: String,
    expanded: Boolean,
    expandDescription: String,
    collapseDescription: String,
    onToggle: () -> Unit,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
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
                ) {
                    content()
                }
            }
        }
    }
}
