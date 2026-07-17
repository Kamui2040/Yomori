# Cross-series reader compile validation

Commit before validation: `c8c3a01872897f4762b5c0568fbe2bbc77326276`

## spotlessApply

Exit code: `0`

```text
Starting a Gradle Daemon (subsequent builds will be faster)
Configuration on demand is an incubating feature.
Type-safe project accessors is an incubating feature.
> Task :build-logic:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :build-logic:compileKotlin FROM-CACHE
> Task :build-logic:compileJava NO-SOURCE
> Task :build-logic:pluginDescriptors
> Task :build-logic:processResources
> Task :build-logic:classes
> Task :build-logic:jar
> Task :spotlessKotlin FROM-CACHE
> Task :core-metadata:spotlessKotlin FROM-CACHE
> Task :core-metadata:spotlessKotlinApply UP-TO-DATE
> Task :spotlessKotlinApply UP-TO-DATE
> Task :spotlessKotlinGradle FROM-CACHE
> Task :core-metadata:spotlessKotlinGradle FROM-CACHE
> Task :spotlessKotlinGradleApply UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradleApply UP-TO-DATE
> Task :spotlessXml FROM-CACHE
> Task :spotlessXmlApply UP-TO-DATE
> Task :core-metadata:spotlessXml FROM-CACHE
> Task :core-metadata:spotlessXmlApply UP-TO-DATE
> Task :core-metadata:spotlessApply UP-TO-DATE
> Task :build-logic:spotlessKotlin FROM-CACHE
> Task :i18n:spotlessKotlin FROM-CACHE
> Task :i18n:spotlessKotlinApply UP-TO-DATE
> Task :i18n:spotlessKotlinGradle FROM-CACHE
> Task :i18n:spotlessKotlinGradleApply UP-TO-DATE
> Task :i18n:spotlessXml FROM-CACHE
> Task :i18n:spotlessXmlApply UP-TO-DATE
> Task :i18n:spotlessApply UP-TO-DATE
> Task :presentation-core:spotlessKotlin FROM-CACHE
> Task :presentation-core:spotlessKotlinApply UP-TO-DATE
> Task :presentation-core:spotlessKotlinGradle FROM-CACHE
> Task :presentation-core:spotlessKotlinGradleApply UP-TO-DATE
> Task :presentation-core:spotlessXml FROM-CACHE
> Task :presentation-core:spotlessXmlApply UP-TO-DATE
> Task :presentation-core:spotlessApply UP-TO-DATE
> Task :presentation-widget:spotlessKotlin FROM-CACHE
> Task :presentation-widget:spotlessKotlinApply UP-TO-DATE
> Task :presentation-widget:spotlessKotlinGradle FROM-CACHE
> Task :presentation-widget:spotlessKotlinGradleApply UP-TO-DATE
> Task :presentation-widget:spotlessXml FROM-CACHE
> Task :presentation-widget:spotlessXmlApply UP-TO-DATE
> Task :presentation-widget:spotlessApply UP-TO-DATE
> Task :source-api:spotlessKotlin FROM-CACHE
> Task :source-api:spotlessKotlinApply UP-TO-DATE
> Task :source-api:spotlessKotlinGradle FROM-CACHE
> Task :source-api:spotlessKotlinGradleApply UP-TO-DATE
> Task :source-api:spotlessXml FROM-CACHE
> Task :source-api:spotlessXmlApply UP-TO-DATE
> Task :source-api:spotlessApply UP-TO-DATE
> Task :source-local:spotlessKotlin FROM-CACHE
> Task :source-local:spotlessKotlinApply UP-TO-DATE
> Task :source-local:spotlessKotlinGradle FROM-CACHE
> Task :source-local:spotlessKotlinGradleApply UP-TO-DATE
> Task :source-local:spotlessXml FROM-CACHE
> Task :source-local:spotlessXmlApply UP-TO-DATE
> Task :source-local:spotlessApply UP-TO-DATE
> Task :telemetry:spotlessKotlin FROM-CACHE
> Task :telemetry:spotlessKotlinApply UP-TO-DATE
> Task :telemetry:spotlessKotlinGradle FROM-CACHE
> Task :telemetry:spotlessKotlinGradleApply UP-TO-DATE
> Task :telemetry:spotlessXml FROM-CACHE
> Task :telemetry:spotlessXmlApply UP-TO-DATE
> Task :telemetry:spotlessApply UP-TO-DATE
> Task :core:archive:spotlessKotlin FROM-CACHE
> Task :core:archive:spotlessKotlinApply UP-TO-DATE
> Task :core:archive:spotlessKotlinGradle FROM-CACHE
> Task :core:archive:spotlessKotlinGradleApply UP-TO-DATE
> Task :core:archive:spotlessXml FROM-CACHE
> Task :core:archive:spotlessXmlApply UP-TO-DATE
> Task :core:archive:spotlessApply UP-TO-DATE
> Task :core:common:spotlessKotlin FROM-CACHE
> Task :core:common:spotlessKotlinApply UP-TO-DATE
> Task :core:common:spotlessKotlinGradle FROM-CACHE
> Task :core:common:spotlessKotlinGradleApply UP-TO-DATE
> Task :core:common:spotlessXml FROM-CACHE
> Task :core:common:spotlessXmlApply UP-TO-DATE
> Task :core:common:spotlessApply UP-TO-DATE
> Task :build-logic:spotlessKotlinApply UP-TO-DATE
> Task :build-logic:spotlessKotlinGradle FROM-CACHE
> Task :build-logic:spotlessKotlinGradleApply UP-TO-DATE
> Task :build-logic:spotlessApply UP-TO-DATE
> Task :spotlessApply UP-TO-DATE
> Task :data:spotlessKotlin
> Task :data:spotlessKotlinApply
> Task :data:spotlessKotlinGradle FROM-CACHE
> Task :data:spotlessKotlinGradleApply UP-TO-DATE
> Task :data:spotlessXml FROM-CACHE
> Task :data:spotlessXmlApply UP-TO-DATE
> Task :data:spotlessApply
> Task :domain:spotlessKotlin
> Task :domain:spotlessKotlinApply
> Task :domain:spotlessKotlinGradle FROM-CACHE
> Task :domain:spotlessKotlinGradleApply UP-TO-DATE
> Task :domain:spotlessXml FROM-CACHE
> Task :domain:spotlessXmlApply UP-TO-DATE
> Task :domain:spotlessApply
> Task :app:spotlessKotlin
> Task :app:spotlessKotlinApply
> Task :app:spotlessKotlinGradle FROM-CACHE
> Task :app:spotlessKotlinGradleApply UP-TO-DATE
> Task :app:spotlessXml
> Task :app:spotlessXmlApply
> Task :app:spotlessApply
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784247709733.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 33s
86 actionable tasks: 11 executed, 38 from cache, 37 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## spotlessCheck

Exit code: `0`

```text
Configuration on demand is an incubating feature.
Type-safe project accessors is an incubating feature.
> Task :build-logic:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :build-logic:compileKotlin UP-TO-DATE
> Task :build-logic:compileJava NO-SOURCE
> Task :build-logic:pluginDescriptors UP-TO-DATE
> Task :build-logic:processResources UP-TO-DATE
> Task :build-logic:classes UP-TO-DATE
> Task :build-logic:jar UP-TO-DATE
> Task :core-metadata:spotlessKotlin UP-TO-DATE
> Task :core-metadata:spotlessKotlinCheck UP-TO-DATE
> Task :spotlessKotlin UP-TO-DATE
> Task :spotlessKotlinCheck UP-TO-DATE
> Task :data:spotlessKotlin UP-TO-DATE
> Task :data:spotlessKotlinCheck UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradle UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradleCheck UP-TO-DATE
> Task :spotlessKotlinGradle UP-TO-DATE
> Task :spotlessKotlinGradleCheck UP-TO-DATE
> Task :data:spotlessKotlinGradle UP-TO-DATE
> Task :build-logic:spotlessKotlin UP-TO-DATE
> Task :data:spotlessKotlinGradleCheck UP-TO-DATE
> Task :core-metadata:spotlessXml UP-TO-DATE
> Task :core-metadata:spotlessXmlCheck UP-TO-DATE
> Task :core-metadata:spotlessCheck UP-TO-DATE
> Task :spotlessXml UP-TO-DATE
> Task :spotlessXmlCheck UP-TO-DATE
> Task :build-logic:spotlessKotlinCheck UP-TO-DATE
> Task :app:spotlessKotlin UP-TO-DATE
> Task :app:spotlessKotlinCheck UP-TO-DATE
> Task :data:spotlessXml UP-TO-DATE
> Task :build-logic:spotlessKotlinGradle UP-TO-DATE
> Task :build-logic:spotlessKotlinGradleCheck UP-TO-DATE
> Task :build-logic:spotlessCheck UP-TO-DATE
> Task :data:spotlessXmlCheck UP-TO-DATE
> Task :app:spotlessKotlinGradle UP-TO-DATE
> Task :spotlessCheck UP-TO-DATE
> Task :data:spotlessCheck UP-TO-DATE
> Task :app:spotlessKotlinGradleCheck UP-TO-DATE
> Task :domain:spotlessKotlin UP-TO-DATE
> Task :domain:spotlessKotlinCheck UP-TO-DATE
> Task :i18n:spotlessKotlin UP-TO-DATE
> Task :i18n:spotlessKotlinCheck UP-TO-DATE
> Task :i18n:spotlessKotlinGradle UP-TO-DATE
> Task :i18n:spotlessKotlinGradleCheck UP-TO-DATE
> Task :domain:spotlessKotlinGradle UP-TO-DATE
> Task :domain:spotlessKotlinGradleCheck UP-TO-DATE
> Task :presentation-core:spotlessKotlin UP-TO-DATE
> Task :presentation-core:spotlessKotlinCheck UP-TO-DATE
> Task :i18n:spotlessXml UP-TO-DATE
> Task :i18n:spotlessXmlCheck UP-TO-DATE
> Task :i18n:spotlessCheck UP-TO-DATE
> Task :presentation-core:spotlessKotlinGradle UP-TO-DATE
> Task :presentation-core:spotlessKotlinGradleCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlin UP-TO-DATE
> Task :presentation-widget:spotlessKotlinCheck UP-TO-DATE
> Task :presentation-core:spotlessXml UP-TO-DATE
> Task :app:spotlessXml UP-TO-DATE
> Task :presentation-core:spotlessXmlCheck UP-TO-DATE
> Task :presentation-core:spotlessCheck UP-TO-DATE
> Task :app:spotlessXmlCheck UP-TO-DATE
> Task :app:spotlessCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlinGradle UP-TO-DATE
> Task :domain:spotlessXml UP-TO-DATE
> Task :domain:spotlessXmlCheck UP-TO-DATE
> Task :domain:spotlessCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlinGradleCheck UP-TO-DATE
> Task :source-api:spotlessKotlin UP-TO-DATE
> Task :source-api:spotlessKotlinCheck UP-TO-DATE
> Task :presentation-widget:spotlessXml UP-TO-DATE
> Task :presentation-widget:spotlessXmlCheck UP-TO-DATE
> Task :presentation-widget:spotlessCheck UP-TO-DATE
> Task :source-api:spotlessKotlinGradle UP-TO-DATE
> Task :source-api:spotlessKotlinGradleCheck UP-TO-DATE
> Task :telemetry:spotlessKotlin UP-TO-DATE
> Task :source-local:spotlessKotlin UP-TO-DATE
> Task :source-api:spotlessXml UP-TO-DATE
> Task :source-local:spotlessKotlinCheck UP-TO-DATE
> Task :telemetry:spotlessKotlinCheck UP-TO-DATE
> Task :source-api:spotlessXmlCheck UP-TO-DATE
> Task :source-api:spotlessCheck UP-TO-DATE
> Task :telemetry:spotlessKotlinGradle UP-TO-DATE
> Task :telemetry:spotlessKotlinGradleCheck UP-TO-DATE
> Task :source-local:spotlessKotlinGradle UP-TO-DATE
> Task :source-local:spotlessKotlinGradleCheck UP-TO-DATE
> Task :core:archive:spotlessKotlin UP-TO-DATE
> Task :core:archive:spotlessKotlinCheck UP-TO-DATE
> Task :source-local:spotlessXml UP-TO-DATE
> Task :source-local:spotlessXmlCheck UP-TO-DATE
> Task :source-local:spotlessCheck UP-TO-DATE
> Task :telemetry:spotlessXml UP-TO-DATE
> Task :telemetry:spotlessXmlCheck UP-TO-DATE
> Task :core:archive:spotlessKotlinGradle UP-TO-DATE
> Task :telemetry:spotlessCheck UP-TO-DATE
> Task :core:archive:spotlessKotlinGradleCheck UP-TO-DATE
> Task :core:archive:spotlessXml UP-TO-DATE
> Task :core:archive:spotlessXmlCheck UP-TO-DATE
> Task :core:archive:spotlessCheck UP-TO-DATE
> Task :core:common:spotlessKotlin UP-TO-DATE
> Task :core:common:spotlessKotlinCheck UP-TO-DATE
> Task :core:common:spotlessKotlinGradle UP-TO-DATE
> Task :core:common:spotlessKotlinGradleCheck UP-TO-DATE
> Task :core:common:spotlessXml UP-TO-DATE
> Task :core:common:spotlessXmlCheck UP-TO-DATE
> Task :core:common:spotlessCheck UP-TO-DATE
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784247738412.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 2s
86 actionable tasks: 86 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## dataCompile

Exit code: `0`

```text
Configuration on demand is an incubating feature.
Type-safe project accessors is an incubating feature.
> Task :build-logic:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :build-logic:compileKotlin UP-TO-DATE
> Task :build-logic:compileJava NO-SOURCE
> Task :build-logic:pluginDescriptors UP-TO-DATE
> Task :build-logic:processResources UP-TO-DATE
> Task :build-logic:classes UP-TO-DATE
> Task :build-logic:jar UP-TO-DATE
> Task :domain:preBuild UP-TO-DATE
> Task :domain:preDebugBuild UP-TO-DATE
> Task :i18n:androidPreBuild UP-TO-DATE
> Task :core:common:preBuild UP-TO-DATE
> Task :i18n:preAndroidMainBuild UP-TO-DATE
> Task :core:common:preDebugBuild UP-TO-DATE
> Task :domain:generateDebugResources FROM-CACHE
> Task :domain:packageDebugResources FROM-CACHE
> Task :core:common:generateDebugResources FROM-CACHE
> Task :domain:processDebugNavigationResources FROM-CACHE
> Task :core:common:packageDebugResources FROM-CACHE
> Task :i18n:generateAndroidMainEmptyResourceFiles
> Task :core:common:processDebugNavigationResources FROM-CACHE
> Task :i18n:generateAndroidMainLocalesConfig
> Task :data:preBuild UP-TO-DATE
> Task :data:preDebugBuild UP-TO-DATE
> Task :data:generateDebugResources FROM-CACHE
> Task :data:packageDebugResources FROM-CACHE
> Task :data:processDebugNavigationResources FROM-CACHE
> Task :core:common:parseDebugLocalResources FROM-CACHE
> Task :i18n:generateMRcommonTest FROM-CACHE
> Task :i18n:generateMRandroidHostTest FROM-CACHE
> Task :domain:parseDebugLocalResources FROM-CACHE
> Task :data:parseDebugLocalResources FROM-CACHE
> Task :core:common:preReleaseBuild UP-TO-DATE
> Task :source-api:kmpPartiallyResolvedDependenciesChecker
> Task :source-api:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :source-api:androidPreBuild UP-TO-DATE
> Task :source-api:preAndroidMainBuild UP-TO-DATE
> Task :core:common:generateReleaseResources FROM-CACHE
> Task :domain:javaPreCompileDebug FROM-CACHE
> Task :core:common:packageReleaseResources FROM-CACHE
> Task :core:common:processReleaseNavigationResources FROM-CACHE
> Task :core:common:parseReleaseLocalResources FROM-CACHE
> Task :i18n:generateMRcommonMain FROM-CACHE
> Task :core:common:javaPreCompileRelease FROM-CACHE
> Task :core:common:javaPreCompileDebug FROM-CACHE
> Task :i18n:generateMRandroidMain FROM-CACHE
> Task :i18n:packageAndroidMainResources FROM-CACHE
> Task :i18n:parseAndroidMainLocalResources FROM-CACHE
> Task :i18n:generateAndroidMainRFile FROM-CACHE
> Task :i18n:kmpPartiallyResolvedDependenciesChecker
> Task :i18n:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:compileAndroidMain FROM-CACHE
> Task :i18n:bundleAndroidMainClassesToCompileJar
> Task :core:common:generateDebugRFile FROM-CACHE
> Task :core:common:generateReleaseRFile FROM-CACHE
> Task :domain:generateDebugRFile FROM-CACHE
> Task :data:generateDebugRFile FROM-CACHE
> Task :core:common:compileReleaseKotlin FROM-CACHE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarRelease
> Task :core:common:compileDebugKotlin FROM-CACHE
> Task :core:common:compileDebugJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarDebug
> Task :source-api:compileAndroidMain FROM-CACHE
> Task :source-api:bundleAndroidMainClassesToCompileJar
> Task :data:generateDebugDatabaseInterface
> Task :domain:compileDebugKotlin
> Task :domain:compileDebugJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarDebug
> Task :data:compileDebugKotlin
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784247741312.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 36s
50 actionable tasks: 12 executed, 34 from cache, 4 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## appCompile

Exit code: `1`

```text
Configuration on demand is an incubating feature.
Type-safe project accessors is an incubating feature.
> Task :build-logic:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :build-logic:compileKotlin UP-TO-DATE
> Task :build-logic:compileJava NO-SOURCE
> Task :build-logic:pluginDescriptors UP-TO-DATE
> Task :build-logic:processResources UP-TO-DATE
> Task :build-logic:classes UP-TO-DATE
> Task :build-logic:jar UP-TO-DATE
> Task :app:preBuild UP-TO-DATE
> Task :data:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :data:preDebugBuild UP-TO-DATE
> Task :core-metadata:preBuild UP-TO-DATE
> Task :core-metadata:preDebugBuild UP-TO-DATE
> Task :domain:preBuild UP-TO-DATE
> Task :domain:preDebugBuild UP-TO-DATE
> Task :data:generateDebugResources UP-TO-DATE
> Task :domain:generateDebugResources UP-TO-DATE
> Task :core-metadata:generateDebugResources FROM-CACHE
> Task :domain:packageDebugResources UP-TO-DATE
> Task :data:packageDebugResources UP-TO-DATE
> Task :presentation-core:preBuild UP-TO-DATE
> Task :i18n:generateAndroidMainLocalesConfig UP-TO-DATE
> Task :presentation-core:preDebugBuild UP-TO-DATE
> Task :i18n:generateMRcommonTest UP-TO-DATE
> Task :i18n:generateMRandroidHostTest UP-TO-DATE
> Task :i18n:generateMRcommonMain UP-TO-DATE
> Task :i18n:generateMRandroidMain UP-TO-DATE
> Task :i18n:androidPreBuild UP-TO-DATE
> Task :i18n:preAndroidMainBuild UP-TO-DATE
> Task :i18n:packageAndroidMainResources UP-TO-DATE
> Task :core-metadata:packageDebugResources FROM-CACHE
> Task :presentation-widget:preBuild UP-TO-DATE
> Task :presentation-widget:preDebugBuild UP-TO-DATE
> Task :source-api:androidPreBuild UP-TO-DATE
> Task :source-api:preAndroidMainBuild UP-TO-DATE
> Task :presentation-widget:generateDebugResources FROM-CACHE
> Task :presentation-core:generateDebugResources FROM-CACHE
> Task :source-api:generateAndroidMainEmptyResourceFiles
> Task :source-local:androidPreBuild UP-TO-DATE
> Task :source-local:preAndroidMainBuild UP-TO-DATE
> Task :source-local:generateAndroidMainEmptyResourceFiles
> Task :telemetry:preBuild UP-TO-DATE
> Task :telemetry:preDebugBuild UP-TO-DATE
> Task :presentation-widget:packageDebugResources FROM-CACHE
> Task :core:archive:preBuild UP-TO-DATE
> Task :core:archive:preDebugBuild UP-TO-DATE
> Task :presentation-core:packageDebugResources FROM-CACHE
> Task :telemetry:generateDebugResources FROM-CACHE
> Task :core:common:preBuild UP-TO-DATE
> Task :core:common:preDebugBuild UP-TO-DATE
> Task :core:common:generateDebugResources UP-TO-DATE
> Task :core:archive:generateDebugResources FROM-CACHE
> Task :core:common:packageDebugResources UP-TO-DATE
> Task :core-metadata:processDebugNavigationResources FROM-CACHE
> Task :telemetry:packageDebugResources FROM-CACHE
> Task :data:processDebugNavigationResources UP-TO-DATE
> Task :domain:processDebugNavigationResources UP-TO-DATE
> Task :i18n:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :presentation-widget:processDebugNavigationResources FROM-CACHE
> Task :telemetry:processDebugNavigationResources FROM-CACHE
> Task :core:archive:packageDebugResources FROM-CACHE
> Task :core:common:processDebugNavigationResources UP-TO-DATE
> Task :core:archive:processDebugNavigationResources FROM-CACHE
> Task :presentation-core:processDebugNavigationResources FROM-CACHE
> Task :data:parseDebugLocalResources UP-TO-DATE
> Task :domain:parseDebugLocalResources UP-TO-DATE
> Task :core-metadata:parseDebugLocalResources FROM-CACHE
> Task :i18n:parseAndroidMainLocalResources UP-TO-DATE
> Task :core:common:parseDebugLocalResources UP-TO-DATE
> Task :presentation-core:parseDebugLocalResources FROM-CACHE
> Task :i18n:generateAndroidMainRFile UP-TO-DATE
> Task :presentation-widget:parseDebugLocalResources FROM-CACHE
> Task :telemetry:parseDebugLocalResources FROM-CACHE
> Task :core:archive:parseDebugLocalResources FROM-CACHE
> Task :core:archive:generateDebugRFile FROM-CACHE
> Task :source-api:kmpPartiallyResolvedDependenciesChecker
> Task :source-api:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:kmpPartiallyResolvedDependenciesChecker
> Task :i18n:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:common:generateDebugRFile UP-TO-DATE
> Task :core-metadata:generateDebugRFile FROM-CACHE
> Task :i18n:compileAndroidMain UP-TO-DATE
> Task :domain:generateDebugRFile UP-TO-DATE
> Task :data:generateDebugRFile UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :core:common:preReleaseBuild UP-TO-DATE
> Task :core:common:generateReleaseResources UP-TO-DATE
> Task :core:common:packageReleaseResources UP-TO-DATE
> Task :core:common:processReleaseNavigationResources UP-TO-DATE
> Task :core:common:parseReleaseLocalResources UP-TO-DATE
> Task :telemetry:generateDebugRFile FROM-CACHE
> Task :core:common:generateReleaseRFile UP-TO-DATE
> Task :core-metadata:javaPreCompileDebug FROM-CACHE
> Task :data:generateDebugDatabaseInterface UP-TO-DATE
> Task :domain:javaPreCompileDebug UP-TO-DATE
> Task :data:javaPreCompileDebug FROM-CACHE
> Task :presentation-widget:javaPreCompileDebug FROM-CACHE
> Task :core-metadata:preReleaseBuild UP-TO-DATE
> Task :core-metadata:generateReleaseResources FROM-CACHE
> Task :core:common:compileReleaseKotlin UP-TO-DATE
> Task :core:common:javaPreCompileRelease UP-TO-DATE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarRelease UP-TO-DATE
> Task :core-metadata:packageReleaseResources FROM-CACHE
> Task :core:common:compileDebugKotlin UP-TO-DATE
> Task :core:common:javaPreCompileDebug UP-TO-DATE
> Task :core:common:compileDebugJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core-metadata:processReleaseNavigationResources FROM-CACHE
> Task :core-metadata:parseReleaseLocalResources FROM-CACHE
> Task :source-api:compileAndroidMain UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :core-metadata:generateReleaseRFile FROM-CACHE
> Task :domain:compileDebugKotlin UP-TO-DATE
> Task :domain:compileDebugJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core-metadata:compileDebugKotlin FROM-CACHE
> Task :core-metadata:compileDebugJavaWithJavac NO-SOURCE
> Task :data:compileDebugKotlin UP-TO-DATE
> Task :data:compileDebugJavaWithJavac NO-SOURCE
> Task :core-metadata:bundleLibCompileToJarDebug
> Task :data:bundleLibCompileToJarDebug
> Task :domain:preReleaseBuild UP-TO-DATE
> Task :domain:generateReleaseResources FROM-CACHE
> Task :domain:packageReleaseResources FROM-CACHE
> Task :presentation-core:generateDebugRFile FROM-CACHE
> Task :domain:processReleaseNavigationResources FROM-CACHE
> Task :core-metadata:compileReleaseKotlin FROM-CACHE
> Task :core-metadata:javaPreCompileRelease FROM-CACHE
> Task :core-metadata:compileReleaseJavaWithJavac NO-SOURCE
> Task :app:compileDebugAidl FROM-CACHE
> Task :core-metadata:bundleLibCompileToJarRelease
> Task :domain:parseReleaseLocalResources FROM-CACHE
> Task :domain:generateReleaseRFile FROM-CACHE
> Task :presentation-widget:generateDebugRFile FROM-CACHE
> Task :domain:javaPreCompileRelease FROM-CACHE
> Task :source-local:kmpPartiallyResolvedDependenciesChecker
> Task :source-local:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:archive:preReleaseBuild UP-TO-DATE
> Task :core:archive:generateReleaseResources FROM-CACHE
> Task :core:archive:packageReleaseResources FROM-CACHE
> Task :core:archive:processReleaseNavigationResources FROM-CACHE
> Task :core:archive:parseReleaseLocalResources FROM-CACHE
> Task :core:archive:generateReleaseRFile FROM-CACHE
> Task :presentation-core:compileDebugKotlin FROM-CACHE
> Task :presentation-core:javaPreCompileDebug FROM-CACHE
> Task :presentation-core:compileDebugJavaWithJavac NO-SOURCE
> Task :core:archive:compileReleaseKotlin FROM-CACHE
> Task :app:dataBindingMergeDependencyArtifactsDebug
> Task :core:archive:javaPreCompileRelease FROM-CACHE
> Task :core:archive:compileReleaseJavaWithJavac NO-SOURCE
> Task :app:generateDebugResources
> Task :core:archive:bundleLibCompileToJarRelease
> Task :presentation-core:bundleLibCompileToJarDebug
> Task :telemetry:compileDebugKotlin FROM-CACHE
> Task :telemetry:javaPreCompileDebug FROM-CACHE
> Task :telemetry:compileDebugJavaWithJavac NO-SOURCE
> Task :telemetry:bundleLibCompileToJarDebug
> Task :core:archive:compileDebugKotlin FROM-CACHE
> Task :core:archive:javaPreCompileDebug FROM-CACHE
> Task :core:archive:compileDebugJavaWithJavac NO-SOURCE
> Task :core:archive:bundleLibCompileToJarDebug
> Task :app:prepareLibraryDefinitionsDebug FROM-CACHE
> Task :app:replaceDebugShortcutPlaceholder
> Task :presentation-widget:compileDebugKotlin
> Task :presentation-widget:compileDebugJavaWithJavac NO-SOURCE
> Task :presentation-widget:bundleLibCompileToJarDebug
> Task :app:generateDebugBuildConfig
> Task :app:packageDebugResources
> Task :app:processDebugNavigationResources
> Task :app:parseDebugLocalResources
> Task :domain:compileReleaseKotlin
> Task :domain:compileReleaseJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarRelease
> Task :app:generateDebugRFile
> Task :app:mergeDebugResources
> Task :app:dataBindingGenBaseClassesDebug FROM-CACHE
> Task :source-local:compileAndroidMain
> Task :source-local:bundleAndroidMainClassesToCompileJar

> Task :app:compileDebugKotlin FAILED
e: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/reader/ReadingListReaderActivity.kt:118:17 None of the following candidates is applicable:

fun Context.toast(resource: StringResource, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'StringResource' was expected.

fun Context.toast(text: String?, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'String?' was expected.
e: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/reader/ReadingListReaderActivity.kt:145:17 None of the following candidates is applicable:

fun Context.toast(resource: StringResource, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'StringResource' was expected.

fun Context.toast(text: String?, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'String?' was expected.
e: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/reader/ReadingListReaderActivity.kt:202:17 None of the following candidates is applicable:

fun Context.toast(resource: StringResource, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'StringResource' was expected.

fun Context.toast(text: String?, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'String?' was expected.
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784247777430.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:compileDebugKotlin' (registered by plugin 'com.android.internal.application').
> A failure occurred while executing org.jetbrains.kotlin.compilerRunner.btapi.BuildToolsApiCompilationWork
   > Compilation error. See log for more details

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights from a Build Scan (powered by Develocity).
> Get more help at https://help.gradle.org.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD FAILED in 42s
134 actionable tasks: 28 executed, 58 from cache, 48 up-to-date

```

## focusedNavigatorTests

Exit code: `1`

```text
Configuration on demand is an incubating feature.
Type-safe project accessors is an incubating feature.
> Task :build-logic:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :build-logic:compileKotlin UP-TO-DATE
> Task :build-logic:compileJava NO-SOURCE
> Task :build-logic:pluginDescriptors UP-TO-DATE
> Task :build-logic:processResources UP-TO-DATE
> Task :build-logic:classes UP-TO-DATE
> Task :build-logic:jar UP-TO-DATE
> Task :app:preBuild UP-TO-DATE
> Task :domain:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :domain:preDebugBuild UP-TO-DATE
> Task :domain:generateDebugResources UP-TO-DATE
> Task :data:preBuild UP-TO-DATE
> Task :data:preDebugBuild UP-TO-DATE
> Task :data:generateDebugResources UP-TO-DATE
> Task :data:packageDebugResources UP-TO-DATE
> Task :i18n:generateAndroidMainLocalesConfig UP-TO-DATE
> Task :core-metadata:preBuild UP-TO-DATE
> Task :i18n:generateMRcommonTest UP-TO-DATE
> Task :core-metadata:preDebugBuild UP-TO-DATE
> Task :core-metadata:generateDebugResources UP-TO-DATE
> Task :i18n:generateMRandroidHostTest UP-TO-DATE
> Task :domain:packageDebugResources UP-TO-DATE
> Task :i18n:generateMRcommonMain UP-TO-DATE
> Task :presentation-core:preBuild UP-TO-DATE
> Task :presentation-core:preDebugBuild UP-TO-DATE
> Task :presentation-core:generateDebugResources UP-TO-DATE
> Task :i18n:generateMRandroidMain UP-TO-DATE
> Task :i18n:androidPreBuild UP-TO-DATE
> Task :i18n:preAndroidMainBuild UP-TO-DATE
> Task :i18n:packageAndroidMainResources UP-TO-DATE
> Task :presentation-widget:preBuild UP-TO-DATE
> Task :presentation-widget:preDebugBuild UP-TO-DATE
> Task :presentation-core:packageDebugResources UP-TO-DATE
> Task :source-api:androidPreBuild UP-TO-DATE
> Task :source-api:preAndroidMainBuild UP-TO-DATE
> Task :core-metadata:packageDebugResources UP-TO-DATE
> Task :source-local:androidPreBuild UP-TO-DATE
> Task :source-local:preAndroidMainBuild UP-TO-DATE
> Task :source-local:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :telemetry:preBuild UP-TO-DATE
> Task :telemetry:preDebugBuild UP-TO-DATE
> Task :telemetry:generateDebugResources UP-TO-DATE
> Task :presentation-widget:generateDebugResources UP-TO-DATE
> Task :source-api:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :telemetry:packageDebugResources UP-TO-DATE
> Task :presentation-widget:packageDebugResources UP-TO-DATE
> Task :core:archive:preBuild UP-TO-DATE
> Task :core:archive:preDebugBuild UP-TO-DATE
> Task :core-metadata:processDebugNavigationResources UP-TO-DATE
> Task :core:archive:generateDebugResources UP-TO-DATE
> Task :data:processDebugNavigationResources UP-TO-DATE
> Task :core:archive:packageDebugResources UP-TO-DATE
> Task :domain:processDebugNavigationResources UP-TO-DATE
> Task :core:common:preBuild UP-TO-DATE
> Task :core:common:preDebugBuild UP-TO-DATE
> Task :core:common:generateDebugResources UP-TO-DATE
> Task :core:common:packageDebugResources UP-TO-DATE
> Task :presentation-core:processDebugNavigationResources UP-TO-DATE
> Task :presentation-widget:processDebugNavigationResources UP-TO-DATE
> Task :telemetry:processDebugNavigationResources UP-TO-DATE
> Task :i18n:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :core:archive:processDebugNavigationResources UP-TO-DATE
> Task :core:common:processDebugNavigationResources UP-TO-DATE
> Task :domain:parseDebugLocalResources UP-TO-DATE
> Task :data:parseDebugLocalResources UP-TO-DATE
> Task :core-metadata:parseDebugLocalResources UP-TO-DATE
> Task :i18n:parseAndroidMainLocalResources UP-TO-DATE
> Task :core:common:parseDebugLocalResources UP-TO-DATE
> Task :presentation-core:parseDebugLocalResources UP-TO-DATE
> Task :presentation-widget:parseDebugLocalResources UP-TO-DATE
> Task :i18n:generateAndroidMainRFile UP-TO-DATE
> Task :telemetry:parseDebugLocalResources UP-TO-DATE
> Task :core:archive:parseDebugLocalResources UP-TO-DATE
> Task :app:compileDebugAidl UP-TO-DATE
> Task :core:archive:generateDebugRFile UP-TO-DATE
> Task :source-api:kmpPartiallyResolvedDependenciesChecker
> Task :source-api:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:kmpPartiallyResolvedDependenciesChecker
> Task :i18n:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:compileAndroidMain UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :core-metadata:generateDebugRFile UP-TO-DATE
> Task :core:common:generateDebugRFile UP-TO-DATE
> Task :data:generateDebugDatabaseInterface UP-TO-DATE
> Task :core-metadata:javaPreCompileDebug UP-TO-DATE
> Task :telemetry:generateDebugRFile UP-TO-DATE
> Task :core:common:preReleaseBuild UP-TO-DATE
> Task :core:common:generateReleaseResources UP-TO-DATE
> Task :domain:generateDebugRFile UP-TO-DATE
> Task :app:dataBindingMergeDependencyArtifactsDebug UP-TO-DATE
> Task :core:common:packageReleaseResources UP-TO-DATE
> Task :app:generateDebugResources UP-TO-DATE
> Task :core:common:processReleaseNavigationResources UP-TO-DATE
> Task :presentation-core:generateDebugRFile UP-TO-DATE
> Task :core:common:parseReleaseLocalResources UP-TO-DATE
> Task :core:common:generateReleaseRFile UP-TO-DATE
> Task :data:generateDebugRFile UP-TO-DATE
> Task :domain:javaPreCompileDebug UP-TO-DATE
> Task :data:javaPreCompileDebug UP-TO-DATE
> Task :presentation-core:javaPreCompileDebug UP-TO-DATE
> Task :core-metadata:preReleaseBuild UP-TO-DATE
> Task :core-metadata:generateReleaseResources UP-TO-DATE
> Task :core-metadata:packageReleaseResources UP-TO-DATE
> Task :core-metadata:processReleaseNavigationResources UP-TO-DATE
> Task :core-metadata:parseReleaseLocalResources UP-TO-DATE
> Task :presentation-widget:generateDebugRFile UP-TO-DATE
> Task :presentation-widget:javaPreCompileDebug UP-TO-DATE
> Task :domain:preReleaseBuild UP-TO-DATE
> Task :domain:generateReleaseResources UP-TO-DATE
> Task :core-metadata:generateReleaseRFile UP-TO-DATE
> Task :core-metadata:javaPreCompileRelease UP-TO-DATE
> Task :domain:packageReleaseResources UP-TO-DATE
> Task :domain:processReleaseNavigationResources UP-TO-DATE
> Task :source-local:kmpPartiallyResolvedDependenciesChecker
> Task :source-local:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:archive:preReleaseBuild UP-TO-DATE
> Task :domain:parseReleaseLocalResources UP-TO-DATE
> Task :core:archive:generateReleaseResources UP-TO-DATE
> Task :core:common:compileReleaseKotlin UP-TO-DATE
> Task :core:common:javaPreCompileRelease UP-TO-DATE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:archive:packageReleaseResources UP-TO-DATE
> Task :core:archive:processReleaseNavigationResources UP-TO-DATE
> Task :core:archive:parseReleaseLocalResources UP-TO-DATE
> Task :core:common:bundleLibCompileToJarRelease UP-TO-DATE
> Task :core:archive:generateReleaseRFile UP-TO-DATE
> Task :domain:generateReleaseRFile UP-TO-DATE
> Task :domain:javaPreCompileRelease UP-TO-DATE
> Task :core:archive:compileReleaseKotlin UP-TO-DATE
> Task :core:archive:javaPreCompileRelease UP-TO-DATE
> Task :core:archive:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:archive:bundleLibCompileToJarRelease UP-TO-DATE
> Task :core:common:compileDebugKotlin UP-TO-DATE
> Task :telemetry:javaPreCompileDebug UP-TO-DATE
> Task :core:common:javaPreCompileDebug UP-TO-DATE
> Task :core:common:compileDebugJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core:archive:compileDebugKotlin UP-TO-DATE
> Task :source-api:compileAndroidMain UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :telemetry:compileDebugKotlin UP-TO-DATE
> Task :presentation-core:compileDebugKotlin UP-TO-DATE
> Task :presentation-core:compileDebugJavaWithJavac NO-SOURCE
> Task :presentation-core:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core-metadata:compileDebugKotlin UP-TO-DATE
> Task :core-metadata:compileDebugJavaWithJavac NO-SOURCE
> Task :telemetry:compileDebugJavaWithJavac NO-SOURCE
> Task :telemetry:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core-metadata:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core:archive:javaPreCompileDebug UP-TO-DATE
> Task :core:archive:compileDebugJavaWithJavac NO-SOURCE
> Task :core:archive:bundleLibCompileToJarDebug UP-TO-DATE
> Task :domain:compileDebugKotlin UP-TO-DATE
> Task :app:prepareLibraryDefinitionsDebug UP-TO-DATE
> Task :app:replaceDebugShortcutPlaceholder UP-TO-DATE
> Task :domain:compileDebugJavaWithJavac NO-SOURCE
> Task :core-metadata:compileReleaseKotlin UP-TO-DATE
> Task :domain:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core-metadata:compileReleaseJavaWithJavac NO-SOURCE
> Task :core-metadata:bundleLibCompileToJarRelease UP-TO-DATE
> Task :data:writeDebugAarMetadata
> Task :app:mergeDebugResources UP-TO-DATE
> Task :domain:compileReleaseKotlin UP-TO-DATE
> Task :presentation-widget:compileDebugKotlin UP-TO-DATE
> Task :presentation-widget:compileDebugJavaWithJavac NO-SOURCE
> Task :domain:compileReleaseJavaWithJavac NO-SOURCE
> Task :presentation-widget:bundleLibCompileToJarDebug UP-TO-DATE
> Task :domain:bundleLibCompileToJarRelease UP-TO-DATE
> Task :app:dataBindingGenBaseClassesDebug UP-TO-DATE
> Task :core-metadata:writeDebugAarMetadata
> Task :app:generateDebugBuildConfig
> Task :app:packageDebugResources UP-TO-DATE
> Task :domain:writeDebugAarMetadata
> Task :data:compileDebugKotlin UP-TO-DATE
> Task :data:compileDebugJavaWithJavac NO-SOURCE
> Task :data:bundleLibCompileToJarDebug UP-TO-DATE
> Task :i18n:writeAndroidMainAarMetadata
> Task :presentation-core:writeDebugAarMetadata
> Task :presentation-widget:writeDebugAarMetadata
> Task :source-api:writeAndroidMainAarMetadata
> Task :telemetry:writeDebugAarMetadata
> Task :source-local:compileAndroidMain UP-TO-DATE
> Task :source-local:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :app:processDebugNavigationResources UP-TO-DATE
> Task :core:common:writeDebugAarMetadata
> Task :app:parseDebugLocalResources UP-TO-DATE
> Task :core-metadata:extractDeepLinksDebug FROM-CACHE
> Task :core:archive:writeDebugAarMetadata
> Task :source-local:writeAndroidMainAarMetadata
> Task :domain:extractDeepLinksDebug FROM-CACHE
> Task :data:extractDeepLinksDebug FROM-CACHE
> Task :core-metadata:processDebugManifest FROM-CACHE
> Task :app:generateDebugRFile UP-TO-DATE
> Task :domain:processDebugManifest FROM-CACHE
> Task :data:processDebugManifest FROM-CACHE
> Task :i18n:processAndroidMainManifest FROM-CACHE
> Task :presentation-core:extractDeepLinksDebug FROM-CACHE
> Task :presentation-widget:extractDeepLinksDebug FROM-CACHE
> Task :presentation-core:processDebugManifest FROM-CACHE
> Task :source-api:processAndroidMainManifest FROM-CACHE
> Task :presentation-widget:processDebugManifest FROM-CACHE
> Task :telemetry:extractDeepLinksDebug FROM-CACHE
> Task :source-local:processAndroidMainManifest FROM-CACHE
> Task :core:archive:extractDeepLinksDebug FROM-CACHE
> Task :core:common:extractDeepLinksDebug FROM-CACHE
> Task :core:common:processDebugManifest FROM-CACHE
> Task :telemetry:processDebugManifest FROM-CACHE
> Task :core:archive:processDebugManifest FROM-CACHE
> Task :core-metadata:mapDebugSourceSetPaths
> Task :data:mapDebugSourceSetPaths
> Task :domain:mapDebugSourceSetPaths
> Task :core-metadata:compileDebugLibraryResources FROM-CACHE
> Task :data:compileDebugLibraryResources FROM-CACHE
> Task :domain:compileDebugLibraryResources FROM-CACHE
> Task :i18n:mapAndroidMainSourceSetPaths
> Task :presentation-core:mapDebugSourceSetPaths
> Task :i18n:compileAndroidMainLibraryResources FROM-CACHE
> Task :presentation-widget:mapDebugSourceSetPaths
> Task :presentation-core:compileDebugLibraryResources FROM-CACHE
> Task :telemetry:mapDebugSourceSetPaths
> Task :telemetry:compileDebugLibraryResources FROM-CACHE
> Task :core:archive:mapDebugSourceSetPaths
> Task :presentation-widget:compileDebugLibraryResources FROM-CACHE
> Task :core:archive:compileDebugLibraryResources FROM-CACHE
> Task :core:common:mapDebugSourceSetPaths
> Task :core:common:compileDebugLibraryResources FROM-CACHE
> Task :core-metadata:bundleLibRuntimeToJarDebug
> Task :core-metadata:processDebugJavaRes
> Task :data:processDebugJavaRes
> Task :data:bundleLibRuntimeToJarDebug
> Task :i18n:bundleAndroidMainClassesToRuntimeJar
> Task :i18n:processAndroidMainJavaRes
> Task :domain:bundleLibRuntimeToJarDebug
> Task :domain:processDebugJavaRes
> Task :presentation-core:bundleLibRuntimeToJarDebug
> Task :presentation-widget:bundleLibRuntimeToJarDebug
> Task :presentation-widget:processDebugJavaRes
> Task :presentation-core:processDebugJavaRes
> Task :source-api:bundleAndroidMainClassesToRuntimeJar
> Task :source-local:bundleAndroidMainClassesToRuntimeJar
> Task :telemetry:bundleLibRuntimeToJarDebug
> Task :source-local:processAndroidMainJavaRes
> Task :source-api:processAndroidMainJavaRes
> Task :telemetry:processDebugJavaRes
> Task :core:archive:bundleLibRuntimeToJarDebug
> Task :core:common:bundleLibRuntimeToJarDebug
> Task :core:archive:processDebugJavaRes
> Task :core:common:processDebugJavaRes
> Task :app:javaPreCompileDebug FROM-CACHE
> Task :app:mapDebugSourceSetPaths
> Task :app:compileDebugNavigationResources FROM-CACHE
> Task :app:createDebugCompatibleScreenManifests
> Task :app:checkDebugAarMetadata
> Task :app:extractDeepLinksDebug FROM-CACHE
> Task :app:processDebugMainManifest
> Task :app:processDebugManifest
> Task :app:preDebugUnitTestBuild UP-TO-DATE
> Task :app:javaPreCompileDebugUnitTest FROM-CACHE
> Task :app:processDebugManifestForPackage
> Task :app:processDebugResources

> Task :app:compileDebugKotlin FAILED
e: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/reader/ReadingListReaderActivity.kt:118:17 None of the following candidates is applicable:

fun Context.toast(resource: StringResource, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'StringResource' was expected.

fun Context.toast(text: String?, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'String?' was expected.
e: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/reader/ReadingListReaderActivity.kt:145:17 None of the following candidates is applicable:

fun Context.toast(resource: StringResource, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'StringResource' was expected.

fun Context.toast(text: String?, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'String?' was expected.
e: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/reader/ReadingListReaderActivity.kt:202:17 None of the following candidates is applicable:

fun Context.toast(resource: StringResource, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'StringResource' was expected.

fun Context.toast(text: String?, duration: Int = ..., block: (Toast) -> Unit = ...): Toast:
  Argument type mismatch: actual type is 'Int', but 'String?' was expected.
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784247820081.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:compileDebugKotlin' (registered by plugin 'com.android.internal.application').
> A failure occurred while executing org.jetbrains.kotlin.compilerRunner.btapi.BuildToolsApiCompilationWork
   > Compilation error. See log for more details

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights from a Build Scan (powered by Develocity).
> Get more help at https://help.gradle.org.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD FAILED in 21s
215 actionable tasks: 54 executed, 32 from cache, 129 up-to-date

```

## focusedRepositoryTests

Exit code: `0`

```text
Configuration on demand is an incubating feature.
Type-safe project accessors is an incubating feature.
> Task :build-logic:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :build-logic:compileKotlin UP-TO-DATE
> Task :build-logic:compileJava NO-SOURCE
> Task :build-logic:pluginDescriptors UP-TO-DATE
> Task :build-logic:processResources UP-TO-DATE
> Task :build-logic:classes UP-TO-DATE
> Task :build-logic:jar UP-TO-DATE
> Task :i18n:androidPreBuild UP-TO-DATE
> Task :core:common:preBuild UP-TO-DATE
> Task :core:common:preDebugBuild UP-TO-DATE
> Task :domain:preBuild UP-TO-DATE
> Task :core:common:generateDebugResources UP-TO-DATE
> Task :domain:preDebugBuild UP-TO-DATE
> Task :i18n:preAndroidMainBuild UP-TO-DATE
> Task :domain:generateDebugResources UP-TO-DATE
> Task :i18n:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :core:common:packageDebugResources UP-TO-DATE
> Task :i18n:generateAndroidMainLocalesConfig UP-TO-DATE
> Task :i18n:generateMRcommonTest UP-TO-DATE
> Task :core:common:processDebugNavigationResources UP-TO-DATE
> Task :core:common:parseDebugLocalResources UP-TO-DATE
> Task :data:generateDebugDatabaseInterface UP-TO-DATE
> Task :data:preBuild UP-TO-DATE
> Task :data:preDebugBuild UP-TO-DATE
> Task :i18n:generateMRandroidHostTest UP-TO-DATE
> Task :data:generateDebugResources UP-TO-DATE
> Task :domain:packageDebugResources UP-TO-DATE
> Task :domain:processDebugNavigationResources UP-TO-DATE
> Task :source-api:kmpPartiallyResolvedDependenciesChecker
> Task :source-api:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:common:preReleaseBuild UP-TO-DATE
> Task :core:common:generateReleaseResources UP-TO-DATE
> Task :domain:parseDebugLocalResources UP-TO-DATE
> Task :i18n:generateMRcommonMain UP-TO-DATE
> Task :source-api:androidPreBuild UP-TO-DATE
> Task :source-api:preAndroidMainBuild UP-TO-DATE
> Task :data:packageDebugResources UP-TO-DATE
> Task :domain:javaPreCompileDebug UP-TO-DATE
> Task :i18n:generateMRandroidMain UP-TO-DATE
> Task :data:processDebugNavigationResources UP-TO-DATE
> Task :i18n:packageAndroidMainResources UP-TO-DATE
> Task :data:parseDebugLocalResources UP-TO-DATE
> Task :core:common:packageReleaseResources UP-TO-DATE
> Task :i18n:parseAndroidMainLocalResources UP-TO-DATE
> Task :data:javaPreCompileDebug UP-TO-DATE
> Task :data:preDebugUnitTestBuild UP-TO-DATE
> Task :core:common:processReleaseNavigationResources UP-TO-DATE
> Task :core:common:parseReleaseLocalResources UP-TO-DATE
> Task :core:common:javaPreCompileRelease UP-TO-DATE
> Task :data:javaPreCompileDebugUnitTest FROM-CACHE
> Task :core:common:javaPreCompileDebug UP-TO-DATE
> Task :i18n:generateAndroidMainRFile UP-TO-DATE
> Task :i18n:kmpPartiallyResolvedDependenciesChecker
> Task :i18n:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:common:generateDebugRFile UP-TO-DATE
> Task :i18n:compileAndroidMain UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :i18n:processAndroidMainJavaRes UP-TO-DATE
> Task :core:common:generateReleaseRFile UP-TO-DATE
> Task :domain:generateDebugRFile UP-TO-DATE
> Task :core:common:compileReleaseKotlin UP-TO-DATE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarRelease UP-TO-DATE
> Task :core:common:compileDebugKotlin UP-TO-DATE
> Task :core:common:compileDebugJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core:common:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :core:common:processDebugJavaRes UP-TO-DATE
> Task :data:generateDebugRFile UP-TO-DATE
> Task :source-api:compileAndroidMain UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :source-api:processAndroidMainJavaRes UP-TO-DATE
> Task :domain:compileDebugKotlin UP-TO-DATE
> Task :domain:compileDebugJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarDebug UP-TO-DATE
> Task :domain:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :domain:processDebugJavaRes UP-TO-DATE
> Task :data:generateDebugUnitTestStubRFile FROM-CACHE
> Task :data:compileDebugKotlin UP-TO-DATE
> Task :data:compileDebugJavaWithJavac NO-SOURCE
> Task :data:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :data:bundleLibCompileToJarDebug UP-TO-DATE
> Task :data:processDebugJavaRes UP-TO-DATE
> Task :data:compileDebugUnitTestKotlin
> Task :data:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :data:processDebugUnitTestJavaRes

> Task :data:testDebugUnitTest

ReadingListProgressRepositoryTest > completed list cannot retain a current position() PASSED

ReadingListProgressRepositoryTest > progress and completion remain list specific() PASSED

ReadingListProgressRepositoryTest > invalid position is refused without changing stored progress() PASSED

ReadingListProgressRepositoryTest > missing list progress update is refused() PASSED

ReadingListReaderStateRepositoryTest > reader failure preserves user confirmed mapping and clear restores protection() PASSED

ReadingListReaderStateRepositoryTest > skip preserves resolved identity and affects only the requested list entry() PASSED

ReadingListReaderStateRepositoryTest > reader failure clear restores automatic match when identity remains() PASSED

ReadingListReaderStateRepositoryTest > reader failure rejects non repairable states() PASSED
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784247842077.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 4s
67 actionable tasks: 5 executed, 2 from cache, 60 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## gitDiffCheck

Exit code: `0`

```text

```

