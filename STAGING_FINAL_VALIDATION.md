# Final cross-series reader staging validation

Commit before validation: `dc121f1465ed23b8602e1275c484b31d58fa0cbd`

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
> Task :spotlessKotlinApply UP-TO-DATE
> Task :core-metadata:spotlessKotlinApply UP-TO-DATE
> Task :spotlessKotlinGradle FROM-CACHE
> Task :spotlessKotlinGradleApply UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradle FROM-CACHE
> Task :core-metadata:spotlessKotlinGradleApply UP-TO-DATE
> Task :spotlessXml FROM-CACHE
> Task :spotlessXmlApply UP-TO-DATE
> Task :core-metadata:spotlessXml FROM-CACHE
> Task :core-metadata:spotlessXmlApply UP-TO-DATE
> Task :build-logic:spotlessKotlin FROM-CACHE
> Task :core-metadata:spotlessApply UP-TO-DATE
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
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784246706962.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 35s
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
> Task :spotlessKotlin UP-TO-DATE
> Task :build-logic:spotlessKotlin UP-TO-DATE
> Task :spotlessKotlinCheck UP-TO-DATE
> Task :core-metadata:spotlessKotlin UP-TO-DATE
> Task :core-metadata:spotlessKotlinCheck UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradle UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradleCheck UP-TO-DATE
> Task :spotlessKotlinGradle UP-TO-DATE
> Task :spotlessKotlinGradleCheck UP-TO-DATE
> Task :app:spotlessKotlin UP-TO-DATE
> Task :app:spotlessKotlinCheck UP-TO-DATE
> Task :spotlessXml UP-TO-DATE
> Task :core-metadata:spotlessXml UP-TO-DATE
> Task :spotlessXmlCheck UP-TO-DATE
> Task :core-metadata:spotlessXmlCheck UP-TO-DATE
> Task :core-metadata:spotlessCheck UP-TO-DATE
> Task :app:spotlessKotlinGradle UP-TO-DATE
> Task :data:spotlessKotlin UP-TO-DATE
> Task :data:spotlessKotlinCheck UP-TO-DATE
> Task :app:spotlessKotlinGradleCheck UP-TO-DATE
> Task :data:spotlessKotlinGradle UP-TO-DATE
> Task :data:spotlessKotlinGradleCheck UP-TO-DATE
> Task :data:spotlessXml UP-TO-DATE
> Task :data:spotlessXmlCheck UP-TO-DATE
> Task :data:spotlessCheck UP-TO-DATE
> Task :i18n:spotlessKotlin UP-TO-DATE
> Task :i18n:spotlessKotlinCheck UP-TO-DATE
> Task :domain:spotlessKotlin UP-TO-DATE
> Task :i18n:spotlessKotlinGradle UP-TO-DATE
> Task :i18n:spotlessKotlinGradleCheck UP-TO-DATE
> Task :domain:spotlessKotlinCheck UP-TO-DATE
> Task :app:spotlessXml UP-TO-DATE
> Task :domain:spotlessKotlinGradle UP-TO-DATE
> Task :app:spotlessXmlCheck UP-TO-DATE
> Task :domain:spotlessKotlinGradleCheck UP-TO-DATE
> Task :app:spotlessCheck UP-TO-DATE
> Task :presentation-core:spotlessKotlin UP-TO-DATE
> Task :presentation-core:spotlessKotlinCheck UP-TO-DATE
> Task :i18n:spotlessXml UP-TO-DATE
> Task :i18n:spotlessXmlCheck UP-TO-DATE
> Task :i18n:spotlessCheck UP-TO-DATE
> Task :domain:spotlessXml UP-TO-DATE
> Task :presentation-core:spotlessKotlinGradle UP-TO-DATE
> Task :presentation-core:spotlessKotlinGradleCheck UP-TO-DATE
> Task :domain:spotlessXmlCheck UP-TO-DATE
> Task :domain:spotlessCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlin UP-TO-DATE
> Task :presentation-core:spotlessXml UP-TO-DATE
> Task :presentation-core:spotlessXmlCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlinCheck UP-TO-DATE
> Task :presentation-core:spotlessCheck UP-TO-DATE
> Task :source-api:spotlessKotlin UP-TO-DATE
> Task :source-api:spotlessKotlinCheck UP-TO-DATE
> Task :source-local:spotlessKotlin UP-TO-DATE
> Task :source-local:spotlessKotlinCheck UP-TO-DATE
> Task :source-api:spotlessKotlinGradle UP-TO-DATE
> Task :presentation-widget:spotlessKotlinGradle UP-TO-DATE
> Task :source-local:spotlessKotlinGradle UP-TO-DATE
> Task :presentation-widget:spotlessKotlinGradleCheck UP-TO-DATE
> Task :source-local:spotlessKotlinGradleCheck UP-TO-DATE
> Task :source-api:spotlessKotlinGradleCheck UP-TO-DATE
> Task :presentation-widget:spotlessXml UP-TO-DATE
> Task :presentation-widget:spotlessXmlCheck UP-TO-DATE
> Task :presentation-widget:spotlessCheck UP-TO-DATE
> Task :telemetry:spotlessKotlin UP-TO-DATE
> Task :source-local:spotlessXml UP-TO-DATE
> Task :source-local:spotlessXmlCheck UP-TO-DATE
> Task :source-api:spotlessXml UP-TO-DATE
> Task :source-api:spotlessXmlCheck UP-TO-DATE
> Task :source-api:spotlessCheck UP-TO-DATE
> Task :source-local:spotlessCheck UP-TO-DATE
> Task :telemetry:spotlessKotlinCheck UP-TO-DATE
> Task :build-logic:spotlessKotlinCheck UP-TO-DATE
> Task :telemetry:spotlessKotlinGradle UP-TO-DATE
> Task :build-logic:spotlessKotlinGradle UP-TO-DATE
> Task :telemetry:spotlessKotlinGradleCheck UP-TO-DATE
> Task :build-logic:spotlessKotlinGradleCheck UP-TO-DATE
> Task :build-logic:spotlessCheck UP-TO-DATE
> Task :spotlessCheck UP-TO-DATE
> Task :core:archive:spotlessKotlin UP-TO-DATE
> Task :core:archive:spotlessKotlinCheck UP-TO-DATE
> Task :telemetry:spotlessXml UP-TO-DATE
> Task :telemetry:spotlessXmlCheck UP-TO-DATE
> Task :telemetry:spotlessCheck UP-TO-DATE
> Task :core:common:spotlessKotlin UP-TO-DATE
> Task :core:archive:spotlessKotlinGradle UP-TO-DATE
> Task :core:common:spotlessKotlinCheck UP-TO-DATE
> Task :core:archive:spotlessKotlinGradleCheck UP-TO-DATE
> Task :core:archive:spotlessXml UP-TO-DATE
> Task :core:common:spotlessKotlinGradle UP-TO-DATE
> Task :core:archive:spotlessXmlCheck UP-TO-DATE
> Task :core:common:spotlessKotlinGradleCheck UP-TO-DATE
> Task :core:archive:spotlessCheck UP-TO-DATE
> Task :core:common:spotlessXml UP-TO-DATE
> Task :core:common:spotlessXmlCheck UP-TO-DATE
> Task :core:common:spotlessCheck UP-TO-DATE
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784246736539.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 2s
86 actionable tasks: 86 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

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
> Task :data:preBuild UP-TO-DATE
> Task :app:preBuild UP-TO-DATE
> Task :domain:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :domain:preDebugBuild UP-TO-DATE
> Task :data:preDebugBuild UP-TO-DATE
> Task :core-metadata:preBuild UP-TO-DATE
> Task :core-metadata:preDebugBuild UP-TO-DATE
> Task :core-metadata:generateDebugResources FROM-CACHE
> Task :domain:generateDebugResources FROM-CACHE
> Task :data:generateDebugResources FROM-CACHE
> Task :data:packageDebugResources FROM-CACHE
> Task :domain:packageDebugResources FROM-CACHE
> Task :presentation-core:preBuild UP-TO-DATE
> Task :presentation-core:preDebugBuild UP-TO-DATE
> Task :core-metadata:packageDebugResources FROM-CACHE
> Task :presentation-widget:preBuild UP-TO-DATE
> Task :presentation-widget:preDebugBuild UP-TO-DATE
> Task :presentation-widget:generateDebugResources FROM-CACHE
> Task :presentation-core:generateDebugResources FROM-CACHE
> Task :presentation-widget:packageDebugResources FROM-CACHE
> Task :source-api:androidPreBuild UP-TO-DATE
> Task :source-api:preAndroidMainBuild UP-TO-DATE
> Task :presentation-core:packageDebugResources FROM-CACHE
> Task :source-local:androidPreBuild UP-TO-DATE
> Task :source-local:preAndroidMainBuild UP-TO-DATE
> Task :source-local:generateAndroidMainEmptyResourceFiles
> Task :telemetry:preBuild UP-TO-DATE
> Task :telemetry:preDebugBuild UP-TO-DATE
> Task :source-api:generateAndroidMainEmptyResourceFiles
> Task :core:archive:preBuild UP-TO-DATE
> Task :core:archive:preDebugBuild UP-TO-DATE
> Task :telemetry:generateDebugResources FROM-CACHE
> Task :core:archive:generateDebugResources FROM-CACHE
> Task :telemetry:packageDebugResources FROM-CACHE
> Task :core:common:preBuild UP-TO-DATE
> Task :core:common:preDebugBuild UP-TO-DATE
> Task :core:common:generateDebugResources FROM-CACHE
> Task :core:archive:packageDebugResources FROM-CACHE
> Task :i18n:generateAndroidMainLocalesConfig
> Task :core-metadata:processDebugNavigationResources FROM-CACHE
> Task :core:common:packageDebugResources FROM-CACHE
> Task :data:processDebugNavigationResources FROM-CACHE
> Task :i18n:generateMRcommonTest FROM-CACHE
> Task :domain:processDebugNavigationResources FROM-CACHE
> Task :presentation-core:processDebugNavigationResources FROM-CACHE
> Task :presentation-widget:processDebugNavigationResources FROM-CACHE
> Task :i18n:generateMRandroidHostTest FROM-CACHE
> Task :core:archive:processDebugNavigationResources FROM-CACHE
> Task :telemetry:processDebugNavigationResources FROM-CACHE
> Task :core:common:processDebugNavigationResources FROM-CACHE
> Task :i18n:generateMRcommonMain FROM-CACHE
> Task :i18n:generateMRandroidMain FROM-CACHE
> Task :i18n:androidPreBuild UP-TO-DATE
> Task :i18n:preAndroidMainBuild UP-TO-DATE
> Task :i18n:packageAndroidMainResources FROM-CACHE
> Task :i18n:generateAndroidMainEmptyResourceFiles
> Task :app:compileDebugAidl FROM-CACHE
> Task :app:dataBindingMergeDependencyArtifactsDebug
> Task :app:generateDebugResources
> Task :data:parseDebugLocalResources FROM-CACHE
> Task :i18n:parseAndroidMainLocalResources FROM-CACHE
> Task :core-metadata:parseDebugLocalResources FROM-CACHE
> Task :i18n:generateAndroidMainRFile FROM-CACHE
> Task :core:common:parseDebugLocalResources FROM-CACHE
> Task :domain:parseDebugLocalResources FROM-CACHE
> Task :presentation-core:parseDebugLocalResources FROM-CACHE
> Task :presentation-widget:parseDebugLocalResources FROM-CACHE
> Task :telemetry:parseDebugLocalResources FROM-CACHE
> Task :core:archive:parseDebugLocalResources FROM-CACHE
> Task :core:archive:generateDebugRFile FROM-CACHE
> Task :source-api:kmpPartiallyResolvedDependenciesChecker
> Task :source-api:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:kmpPartiallyResolvedDependenciesChecker
> Task :i18n:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:compileAndroidMain FROM-CACHE
> Task :app:prepareLibraryDefinitionsDebug FROM-CACHE
> Task :core-metadata:generateDebugRFile FROM-CACHE
> Task :core:common:generateDebugRFile FROM-CACHE
> Task :core-metadata:javaPreCompileDebug FROM-CACHE
> Task :app:replaceDebugShortcutPlaceholder
> Task :domain:generateDebugRFile FROM-CACHE
> Task :i18n:bundleAndroidMainClassesToCompileJar
> Task :data:generateDebugRFile FROM-CACHE
> Task :telemetry:generateDebugRFile FROM-CACHE
> Task :core:common:preReleaseBuild UP-TO-DATE
> Task :core:common:generateReleaseResources FROM-CACHE
> Task :core:common:packageReleaseResources FROM-CACHE
> Task :core:common:processReleaseNavigationResources FROM-CACHE
> Task :core:common:parseReleaseLocalResources FROM-CACHE
> Task :core:common:generateReleaseRFile FROM-CACHE
> Task :presentation-core:generateDebugRFile FROM-CACHE
> Task :presentation-widget:generateDebugRFile FROM-CACHE
> Task :domain:javaPreCompileDebug FROM-CACHE
> Task :data:javaPreCompileDebug FROM-CACHE
> Task :presentation-core:javaPreCompileDebug FROM-CACHE
> Task :presentation-widget:javaPreCompileDebug FROM-CACHE
> Task :core-metadata:preReleaseBuild UP-TO-DATE
> Task :core-metadata:generateReleaseResources FROM-CACHE
> Task :core-metadata:packageReleaseResources FROM-CACHE
> Task :core-metadata:processReleaseNavigationResources FROM-CACHE
> Task :core-metadata:parseReleaseLocalResources FROM-CACHE
> Task :core-metadata:generateReleaseRFile FROM-CACHE
> Task :core-metadata:javaPreCompileRelease FROM-CACHE
> Task :domain:preReleaseBuild UP-TO-DATE
> Task :domain:generateReleaseResources FROM-CACHE
> Task :domain:packageReleaseResources FROM-CACHE
> Task :domain:processReleaseNavigationResources FROM-CACHE
> Task :domain:parseReleaseLocalResources FROM-CACHE
> Task :core:common:compileReleaseKotlin FROM-CACHE
> Task :core:common:javaPreCompileRelease FROM-CACHE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :domain:generateReleaseRFile FROM-CACHE
> Task :core:common:bundleLibCompileToJarRelease
> Task :domain:javaPreCompileRelease FROM-CACHE
> Task :source-local:kmpPartiallyResolvedDependenciesChecker
> Task :source-local:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:archive:preReleaseBuild UP-TO-DATE
> Task :core:archive:generateReleaseResources FROM-CACHE
> Task :core:archive:packageReleaseResources FROM-CACHE
> Task :core:archive:processReleaseNavigationResources FROM-CACHE
> Task :core:archive:parseReleaseLocalResources FROM-CACHE
> Task :core:archive:generateReleaseRFile FROM-CACHE
> Task :core:common:compileDebugKotlin FROM-CACHE
> Task :core:archive:compileReleaseKotlin FROM-CACHE
> Task :core:common:javaPreCompileDebug FROM-CACHE
> Task :core:common:compileDebugJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarDebug
> Task :source-api:compileAndroidMain FROM-CACHE
> Task :source-api:bundleAndroidMainClassesToCompileJar
> Task :presentation-core:compileDebugKotlin FROM-CACHE
> Task :core-metadata:compileDebugKotlin FROM-CACHE
> Task :core-metadata:compileDebugJavaWithJavac NO-SOURCE
> Task :core-metadata:bundleLibCompileToJarDebug
> Task :presentation-core:compileDebugJavaWithJavac NO-SOURCE
> Task :presentation-core:bundleLibCompileToJarDebug
> Task :core-metadata:compileReleaseKotlin FROM-CACHE
> Task :core-metadata:compileReleaseJavaWithJavac NO-SOURCE
> Task :core-metadata:bundleLibCompileToJarRelease
> Task :core:archive:javaPreCompileRelease FROM-CACHE
> Task :core:archive:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:archive:bundleLibCompileToJarRelease
> Task :telemetry:compileDebugKotlin FROM-CACHE
> Task :telemetry:javaPreCompileDebug FROM-CACHE
> Task :telemetry:compileDebugJavaWithJavac NO-SOURCE
> Task :telemetry:bundleLibCompileToJarDebug
> Task :core:archive:compileDebugKotlin FROM-CACHE
> Task :core:archive:javaPreCompileDebug FROM-CACHE
> Task :core:archive:compileDebugJavaWithJavac NO-SOURCE
> Task :core:archive:bundleLibCompileToJarDebug
> Task :core-metadata:writeDebugAarMetadata
> Task :data:writeDebugAarMetadata
> Task :i18n:writeAndroidMainAarMetadata
> Task :presentation-core:writeDebugAarMetadata
> Task :presentation-widget:writeDebugAarMetadata
> Task :source-api:writeAndroidMainAarMetadata
> Task :source-local:writeAndroidMainAarMetadata
> Task :telemetry:writeDebugAarMetadata
> Task :core:archive:writeDebugAarMetadata
> Task :core:common:writeDebugAarMetadata
> Task :core-metadata:extractDeepLinksDebug FROM-CACHE
> Task :core-metadata:processDebugManifest FROM-CACHE
> Task :data:extractDeepLinksDebug FROM-CACHE
> Task :data:processDebugManifest FROM-CACHE
> Task :i18n:processAndroidMainManifest FROM-CACHE
> Task :presentation-core:extractDeepLinksDebug FROM-CACHE
> Task :presentation-core:processDebugManifest FROM-CACHE
> Task :presentation-widget:extractDeepLinksDebug FROM-CACHE
> Task :presentation-widget:processDebugManifest FROM-CACHE
> Task :source-api:processAndroidMainManifest FROM-CACHE
> Task :source-local:processAndroidMainManifest FROM-CACHE
> Task :telemetry:extractDeepLinksDebug FROM-CACHE
> Task :telemetry:processDebugManifest FROM-CACHE
> Task :core:archive:extractDeepLinksDebug FROM-CACHE
> Task :core:archive:processDebugManifest FROM-CACHE
> Task :core:common:extractDeepLinksDebug FROM-CACHE
> Task :core:common:processDebugManifest FROM-CACHE
> Task :core-metadata:mapDebugSourceSetPaths
> Task :core-metadata:compileDebugLibraryResources FROM-CACHE
> Task :data:mapDebugSourceSetPaths
> Task :data:compileDebugLibraryResources FROM-CACHE
> Task :i18n:mapAndroidMainSourceSetPaths
> Task :i18n:compileAndroidMainLibraryResources FROM-CACHE
> Task :presentation-core:mapDebugSourceSetPaths
> Task :data:generateDebugDatabaseInterface
> Task :app:generateDebugBuildConfig
> Task :app:packageDebugResources
> Task :app:processDebugNavigationResources
> Task :app:parseDebugLocalResources
> Task :app:generateDebugRFile
> Task :app:javaPreCompileDebug FROM-CACHE
> Task :domain:writeDebugAarMetadata
> Task :app:checkDebugAarMetadata
> Task :app:mapDebugSourceSetPaths
> Task :app:compileDebugNavigationResources FROM-CACHE
> Task :app:createDebugCompatibleScreenManifests
> Task :app:extractDeepLinksDebug FROM-CACHE
> Task :domain:extractDeepLinksDebug FROM-CACHE
> Task :domain:processDebugManifest FROM-CACHE
> Task :app:processDebugMainManifest
> Task :app:processDebugManifest
> Task :app:processDebugManifestForPackage
> Task :domain:mapDebugSourceSetPaths
> Task :domain:compileDebugLibraryResources FROM-CACHE
> Task :presentation-core:compileDebugLibraryResources FROM-CACHE
> Task :presentation-widget:mapDebugSourceSetPaths
> Task :presentation-widget:compileDebugLibraryResources FROM-CACHE
> Task :telemetry:mapDebugSourceSetPaths
> Task :telemetry:compileDebugLibraryResources FROM-CACHE
> Task :core:archive:mapDebugSourceSetPaths
> Task :core:archive:compileDebugLibraryResources FROM-CACHE
> Task :core:common:mapDebugSourceSetPaths
> Task :core:common:compileDebugLibraryResources FROM-CACHE
> Task :app:preDebugUnitTestBuild UP-TO-DATE
> Task :app:javaPreCompileDebugUnitTest FROM-CACHE
> Task :core-metadata:bundleLibRuntimeToJarDebug
> Task :core-metadata:processDebugJavaRes
> Task :i18n:bundleAndroidMainClassesToRuntimeJar
> Task :i18n:processAndroidMainJavaRes
> Task :presentation-core:bundleLibRuntimeToJarDebug
> Task :presentation-core:processDebugJavaRes
> Task :source-api:bundleAndroidMainClassesToRuntimeJar
> Task :source-api:processAndroidMainJavaRes
> Task :telemetry:bundleLibRuntimeToJarDebug
> Task :telemetry:processDebugJavaRes
> Task :core:archive:bundleLibRuntimeToJarDebug
> Task :core:archive:processDebugJavaRes
> Task :core:common:bundleLibRuntimeToJarDebug
> Task :core:common:processDebugJavaRes
> Task :app:mergeDebugResources
> Task :app:dataBindingGenBaseClassesDebug FROM-CACHE
> Task :app:processDebugResources
> Task :domain:compileDebugKotlin
> Task :domain:compileReleaseKotlin
> Task :domain:compileReleaseJavaWithJavac NO-SOURCE
> Task :domain:compileDebugJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarDebug
> Task :domain:processDebugJavaRes
> Task :domain:bundleLibCompileToJarRelease
> Task :domain:bundleLibRuntimeToJarDebug
> Task :presentation-widget:compileDebugKotlin
> Task :presentation-widget:compileDebugJavaWithJavac NO-SOURCE
> Task :presentation-widget:bundleLibRuntimeToJarDebug
> Task :presentation-widget:bundleLibCompileToJarDebug
> Task :presentation-widget:processDebugJavaRes
> Task :source-local:compileAndroidMain
> Task :source-local:bundleAndroidMainClassesToRuntimeJar
> Task :source-local:bundleAndroidMainClassesToCompileJar
> Task :source-local:processAndroidMainJavaRes

> Task :data:compileDebugKotlin FAILED
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:109:21 Overload resolution ambiguity between candidates:
fun CblReadingList.requireValidPersistenceOrder(): Unit
fun CblReadingList.requireValidPersistenceOrder(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:110:27 Overload resolution ambiguity between candidates:
fun List<Long>.requireValidSourceSelection(): Unit
fun List<Long>.requireValidSourceSelection(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:162:27 Overload resolution ambiguity between candidates:
fun List<Long>.requireValidSourceSelection(): Unit
fun List<Long>.requireValidSourceSelection(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:440:9 Conflicting overloads:
fun CblReadingList.requireValidPersistenceOrder(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:448:9 Conflicting overloads:
fun List<Long>.requireValidSourceSelection(): Unit
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784246738892.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':data:compileDebugKotlin' (registered by plugin 'com.android.internal.library').
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

BUILD FAILED in 48s
211 actionable tasks: 83 executed, 124 from cache, 4 up-to-date

```

## focusedRepositoryTests

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
> Task :domain:preBuild UP-TO-DATE
> Task :core:common:preBuild UP-TO-DATE
> Task :core:common:preDebugBuild UP-TO-DATE
> Task :i18n:androidPreBuild UP-TO-DATE
> Task :i18n:preAndroidMainBuild UP-TO-DATE
> Task :i18n:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :domain:preDebugBuild UP-TO-DATE
> Task :i18n:generateAndroidMainLocalesConfig UP-TO-DATE
> Task :core:common:generateDebugResources UP-TO-DATE
> Task :domain:generateDebugResources UP-TO-DATE
> Task :core:common:packageDebugResources UP-TO-DATE
> Task :domain:packageDebugResources UP-TO-DATE
> Task :i18n:generateMRcommonTest UP-TO-DATE
> Task :domain:processDebugNavigationResources UP-TO-DATE
> Task :core:common:processDebugNavigationResources UP-TO-DATE
> Task :i18n:generateMRandroidHostTest UP-TO-DATE
> Task :core:common:parseDebugLocalResources UP-TO-DATE
> Task :i18n:generateMRcommonMain UP-TO-DATE
> Task :domain:parseDebugLocalResources UP-TO-DATE
> Task :source-api:kmpPartiallyResolvedDependenciesChecker
> Task :source-api:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:common:preReleaseBuild UP-TO-DATE
> Task :source-api:androidPreBuild UP-TO-DATE
> Task :source-api:preAndroidMainBuild UP-TO-DATE
> Task :i18n:generateMRandroidMain UP-TO-DATE
> Task :domain:javaPreCompileDebug UP-TO-DATE
> Task :core:common:generateReleaseResources UP-TO-DATE
> Task :i18n:packageAndroidMainResources UP-TO-DATE
> Task :core:common:packageReleaseResources UP-TO-DATE
> Task :data:generateDebugDatabaseInterface UP-TO-DATE
> Task :data:preBuild UP-TO-DATE
> Task :data:preDebugBuild UP-TO-DATE
> Task :core:common:processReleaseNavigationResources UP-TO-DATE
> Task :data:generateDebugResources UP-TO-DATE
> Task :core:common:parseReleaseLocalResources UP-TO-DATE
> Task :i18n:parseAndroidMainLocalResources UP-TO-DATE
> Task :core:common:javaPreCompileRelease UP-TO-DATE
> Task :data:packageDebugResources UP-TO-DATE
> Task :core:common:javaPreCompileDebug UP-TO-DATE
> Task :data:processDebugNavigationResources UP-TO-DATE
> Task :data:parseDebugLocalResources UP-TO-DATE
> Task :data:javaPreCompileDebug UP-TO-DATE
> Task :data:preDebugUnitTestBuild UP-TO-DATE
> Task :data:javaPreCompileDebugUnitTest FROM-CACHE
> Task :i18n:generateAndroidMainRFile UP-TO-DATE
> Task :i18n:kmpPartiallyResolvedDependenciesChecker
> Task :i18n:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:compileAndroidMain UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :i18n:processAndroidMainJavaRes UP-TO-DATE
> Task :core:common:generateDebugRFile UP-TO-DATE
> Task :core:common:generateReleaseRFile UP-TO-DATE
> Task :domain:generateDebugRFile UP-TO-DATE
> Task :core:common:compileReleaseKotlin UP-TO-DATE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarRelease UP-TO-DATE
> Task :data:generateDebugRFile UP-TO-DATE
> Task :core:common:compileDebugKotlin UP-TO-DATE
> Task :core:common:compileDebugJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarDebug UP-TO-DATE
> Task :core:common:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :core:common:processDebugJavaRes UP-TO-DATE
> Task :source-api:compileAndroidMain UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :source-api:processAndroidMainJavaRes UP-TO-DATE
> Task :domain:compileDebugKotlin UP-TO-DATE
> Task :domain:compileDebugJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarDebug UP-TO-DATE
> Task :data:generateDebugUnitTestStubRFile FROM-CACHE
> Task :domain:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :domain:processDebugJavaRes UP-TO-DATE

> Task :data:compileDebugKotlin FAILED
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:109:21 Overload resolution ambiguity between candidates:
fun CblReadingList.requireValidPersistenceOrder(): Unit
fun CblReadingList.requireValidPersistenceOrder(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:110:27 Overload resolution ambiguity between candidates:
fun List<Long>.requireValidSourceSelection(): Unit
fun List<Long>.requireValidSourceSelection(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:162:27 Overload resolution ambiguity between candidates:
fun List<Long>.requireValidSourceSelection(): Unit
fun List<Long>.requireValidSourceSelection(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:440:9 Conflicting overloads:
fun CblReadingList.requireValidPersistenceOrder(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:448:9 Conflicting overloads:
fun List<Long>.requireValidSourceSelection(): Unit
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784246787999.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':data:compileDebugKotlin' (registered by plugin 'com.android.internal.library').
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

BUILD FAILED in 4s
61 actionable tasks: 3 executed, 2 from cache, 56 up-to-date

```

## testDebugUnitTest

Exit code: `1`

```text
> Task :app:mapDebugSourceSetPaths UP-TO-DATE
> Task :core-metadata:extractDeepLinksDebug UP-TO-DATE
> Task :source-local:writeAndroidMainAarMetadata UP-TO-DATE
> Task :app:compileDebugNavigationResources UP-TO-DATE
> Task :data:extractDeepLinksDebug UP-TO-DATE
> Task :data:processDebugManifest UP-TO-DATE
> Task :domain:extractDeepLinksDebug UP-TO-DATE
> Task :core-metadata:processDebugManifest UP-TO-DATE
> Task :domain:processDebugManifest UP-TO-DATE
> Task :presentation-core:extractDeepLinksDebug UP-TO-DATE
> Task :i18n:processAndroidMainManifest UP-TO-DATE
> Task :presentation-widget:extractDeepLinksDebug UP-TO-DATE
> Task :presentation-core:processDebugManifest UP-TO-DATE
> Task :source-api:processAndroidMainManifest UP-TO-DATE
> Task :presentation-widget:processDebugManifest UP-TO-DATE
> Task :source-local:processAndroidMainManifest UP-TO-DATE
> Task :telemetry:extractDeepLinksDebug UP-TO-DATE
> Task :core:archive:extractDeepLinksDebug UP-TO-DATE
> Task :telemetry:processDebugManifest UP-TO-DATE
> Task :core:common:extractDeepLinksDebug UP-TO-DATE
> Task :core:archive:processDebugManifest UP-TO-DATE
> Task :core:common:processDebugManifest UP-TO-DATE
> Task :data:mapDebugSourceSetPaths UP-TO-DATE
> Task :data:compileDebugLibraryResources UP-TO-DATE
> Task :core-metadata:mapDebugSourceSetPaths UP-TO-DATE
> Task :core-metadata:compileDebugLibraryResources UP-TO-DATE
> Task :domain:mapDebugSourceSetPaths UP-TO-DATE
> Task :i18n:mapAndroidMainSourceSetPaths UP-TO-DATE
> Task :domain:compileDebugLibraryResources UP-TO-DATE
> Task :i18n:compileAndroidMainLibraryResources UP-TO-DATE
> Task :presentation-core:mapDebugSourceSetPaths UP-TO-DATE
> Task :presentation-widget:mapDebugSourceSetPaths UP-TO-DATE
> Task :presentation-core:compileDebugLibraryResources UP-TO-DATE
> Task :presentation-widget:compileDebugLibraryResources UP-TO-DATE
> Task :telemetry:mapDebugSourceSetPaths UP-TO-DATE
> Task :core:archive:mapDebugSourceSetPaths UP-TO-DATE
> Task :core:archive:compileDebugLibraryResources UP-TO-DATE
> Task :telemetry:compileDebugLibraryResources UP-TO-DATE
> Task :core-metadata:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :app:checkDebugAarMetadata UP-TO-DATE
> Task :core:common:mapDebugSourceSetPaths UP-TO-DATE
> Task :app:createDebugCompatibleScreenManifests UP-TO-DATE
> Task :core:common:compileDebugLibraryResources UP-TO-DATE
> Task :app:extractDeepLinksDebug UP-TO-DATE
> Task :core-metadata:processDebugJavaRes UP-TO-DATE
> Task :domain:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :i18n:processAndroidMainJavaRes UP-TO-DATE
> Task :presentation-core:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :domain:processDebugJavaRes UP-TO-DATE
> Task :presentation-widget:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :presentation-core:processDebugJavaRes UP-TO-DATE
> Task :presentation-widget:processDebugJavaRes UP-TO-DATE
> Task :source-local:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :source-local:processAndroidMainJavaRes UP-TO-DATE
> Task :telemetry:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :telemetry:processDebugJavaRes UP-TO-DATE
> Task :core:archive:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :source-api:processAndroidMainJavaRes UP-TO-DATE
> Task :core:archive:processDebugJavaRes UP-TO-DATE
> Task :core-metadata:preDebugUnitTestBuild UP-TO-DATE
> Task :core:common:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :core:common:processDebugJavaRes UP-TO-DATE
> Task :data:preDebugUnitTestBuild UP-TO-DATE
> Task :app:processDebugMainManifest UP-TO-DATE
> Task :app:processDebugManifest UP-TO-DATE
> Task :app:processDebugManifestForPackage UP-TO-DATE
> Task :data:generateDebugUnitTestStubRFile UP-TO-DATE
> Task :data:javaPreCompileDebugUnitTest UP-TO-DATE
> Task :domain:preDebugUnitTestBuild UP-TO-DATE
> Task :core-metadata:generateDebugUnitTestStubRFile FROM-CACHE
> Task :core-metadata:compileDebugUnitTestKotlin NO-SOURCE
> Task :core-metadata:javaPreCompileDebugUnitTest FROM-CACHE
> Task :core-metadata:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :core-metadata:processDebugUnitTestJavaRes NO-SOURCE
> Task :core-metadata:testDebugUnitTest NO-SOURCE
> Task :presentation-core:preDebugUnitTestBuild UP-TO-DATE
> Task :domain:generateDebugUnitTestStubRFile FROM-CACHE
> Task :app:processDebugResources UP-TO-DATE
> Task :app:preDebugUnitTestBuild UP-TO-DATE
> Task :app:javaPreCompileDebugUnitTest UP-TO-DATE
> Task :presentation-widget:preDebugUnitTestBuild UP-TO-DATE
> Task :presentation-core:generateDebugUnitTestStubRFile FROM-CACHE
> Task :presentation-core:compileDebugUnitTestKotlin NO-SOURCE
> Task :presentation-core:javaPreCompileDebugUnitTest FROM-CACHE
> Task :presentation-core:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :presentation-core:processDebugUnitTestJavaRes NO-SOURCE
> Task :presentation-core:testDebugUnitTest NO-SOURCE
> Task :telemetry:preDebugUnitTestBuild UP-TO-DATE
> Task :telemetry:generateDebugUnitTestStubRFile FROM-CACHE
> Task :domain:javaPreCompileDebugUnitTest FROM-CACHE
> Task :telemetry:compileDebugUnitTestKotlin NO-SOURCE
> Task :telemetry:javaPreCompileDebugUnitTest FROM-CACHE
> Task :telemetry:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :telemetry:processDebugUnitTestJavaRes NO-SOURCE
> Task :telemetry:testDebugUnitTest NO-SOURCE
> Task :core:archive:preDebugUnitTestBuild UP-TO-DATE
> Task :core:archive:generateDebugUnitTestStubRFile FROM-CACHE
> Task :core:archive:compileDebugUnitTestKotlin NO-SOURCE
> Task :core:archive:javaPreCompileDebugUnitTest FROM-CACHE
> Task :core:archive:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :core:archive:processDebugUnitTestJavaRes NO-SOURCE
> Task :core:archive:testDebugUnitTest NO-SOURCE
> Task :presentation-widget:generateDebugUnitTestStubRFile FROM-CACHE
> Task :core:common:preDebugUnitTestBuild UP-TO-DATE
> Task :presentation-widget:compileDebugUnitTestKotlin NO-SOURCE
> Task :presentation-widget:javaPreCompileDebugUnitTest FROM-CACHE
> Task :presentation-widget:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :presentation-widget:processDebugUnitTestJavaRes NO-SOURCE
> Task :presentation-widget:testDebugUnitTest NO-SOURCE
> Task :core:common:generateDebugUnitTestStubRFile FROM-CACHE
> Task :core:common:compileDebugUnitTestKotlin FROM-CACHE
> Task :core:common:javaPreCompileDebugUnitTest FROM-CACHE
> Task :core:common:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :core:common:processDebugUnitTestJavaRes
> Task :core:common:testDebugUnitTest FROM-CACHE
> Task :domain:compileDebugUnitTestKotlin
> Task :domain:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :domain:processDebugUnitTestJavaRes

> Task :data:compileDebugKotlin FAILED
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:109:21 Overload resolution ambiguity between candidates:
fun CblReadingList.requireValidPersistenceOrder(): Unit
fun CblReadingList.requireValidPersistenceOrder(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:110:27 Overload resolution ambiguity between candidates:
fun List<Long>.requireValidSourceSelection(): Unit
fun List<Long>.requireValidSourceSelection(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:162:27 Overload resolution ambiguity between candidates:
fun List<Long>.requireValidSourceSelection(): Unit
fun List<Long>.requireValidSourceSelection(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:440:9 Conflicting overloads:
fun CblReadingList.requireValidPersistenceOrder(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:448:9 Conflicting overloads:
fun List<Long>.requireValidSourceSelection(): Unit

> Task :domain:testDebugUnitTest

ChapterRecognitionTest > Basic Ch prefix with decimal() PASSED

ChapterRecognitionTest > Basic Ch prefix() PASSED

ChapterRecognitionTest > Number after unwanted tag() PASSED

ChapterRecognitionTest > Chapter title containing special and vol() PASSED

ChapterRecognitionTest > Name containing one number and decimal() PASSED

ChapterRecognitionTest > Chapter containing dot v2() PASSED

ChapterRecognitionTest > Chapters ending with s() PASSED

ChapterRecognitionTest > Unparseable chapter() PASSED

ChapterRecognitionTest > Chapters containing season() PASSED

ChapterRecognitionTest > Chapter containing manga title and number decimal() PASSED

ChapterRecognitionTest > Extreme case() PASSED

ChapterRecognitionTest > Number in manga title() PASSED

ChapterRecognitionTest > Chapters containing ordinals() PASSED

ChapterRecognitionTest > Chapter title containing hyphens() PASSED

ChapterRecognitionTest > Chapter with version before number() PASSED

ChapterRecognitionTest > Chapter title containing extra and vol() PASSED

ChapterRecognitionTest > Basic Ch prefix with alpha postfix() PASSED

ChapterRecognitionTest > Name containing one number and alpha() PASSED

ChapterRecognitionTest > Extreme case with alpha() PASSED

ChapterRecognitionTest > Space between ch x() PASSED

ChapterRecognitionTest > Version attached to chapter number() PASSED

ChapterRecognitionTest > Chapter title with ch substring() PASSED

ChapterRecognitionTest > Chapter containing manga title and number alpha() PASSED

ChapterRecognitionTest > Chapter with alpha without dot() PASSED

ChapterRecognitionTest > Chapter title containing commas() PASSED

ChapterRecognitionTest > Chapter containing manga title and number() PASSED

ChapterRecognitionTest > Basic Ch prefix with space after period() PASSED

ChapterRecognitionTest > Chapter title containing omake (japanese extra) and vol() PASSED

ChapterRecognitionTest > Name containing one number() PASSED

ChapterRecognitionTest > Number after manga title with chapter in chapter title case() PASSED

ChapterRecognitionTest > Chapter with time in title() PASSED

ChapterRecognitionTest > Extreme case with decimal() PASSED

ChapterRecognitionTest > Chapters in format sx - chapter xx() PASSED

ChapterRecognitionTest > Chapter containing multiple zeros() PASSED

MissingChaptersTest > missingChaptersCount returns number of missing chapters() PASSED

MissingChaptersTest > missingChaptersCount returns 0 when all unknown chapter numbers() PASSED

MissingChaptersTest > calculateChapterGap returns 0 if either are not valid chapter numbers() PASSED

MissingChaptersTest > calculateChapterGap returns difference() PASSED

MissingChaptersTest > missingChaptersCount handles repeated base chapter numbers() PASSED

MissingChaptersTest > missingChaptersCount returns 0 when empty list() PASSED

LibraryFlagsTest > Test Flag plus operator (LibrarySort)() PASSED

LibraryFlagsTest > Test Flag plus operator with old flag as base() PASSED

LibraryFlagsTest > Test Flag plus operator() PASSED

LibraryFlagsTest > Check the amount of flags() PASSED

LibraryFlagsTest > Test default flags() PASSED

OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended

> Task :domain:testDebugUnitTest

FetchIntervalTest > returns interval of 1 day when chapters are released every 1 day() PASSED

FetchIntervalTest > returns interval based on more recent chapters() PASSED

FetchIntervalTest > returns interval based on smaller subset of recent chapters if very few chapters() PASSED

FetchIntervalTest > returns interval of 2 days when chapters are released just below every 2 days() PASSED

FetchIntervalTest > returns interval of 2 days when chapters are released every 2 days() PASSED

FetchIntervalTest > returns interval of 1 day when delta is less than 1 day() PASSED

FetchIntervalTest > returns interval of 7 days when multiple chapters in 2 days() PASSED

FetchIntervalTest > returns interval with floored value when interval is decimal() PASSED

FetchIntervalTest > returns interval of 7 days when multiple chapters in 1 day() PASSED

FetchIntervalTest > returns default interval of 7 days when not enough distinct days() PASSED

CblParserTest > allows missing optional book and database metadata() PASSED

CblParserTest > enforces configured input and entry limits() PASSED

CblParserTest > rejects malformed XML without returning a partial list() PASSED

CblParserTest > rejects a root other than ReadingList() PASSED

CblParserTest > preserves CBL book order and metadata() PASSED

CblParserTest > reports declared issue count mismatch() PASSED

CblParserTest > reports non-fatal list metadata warnings() PASSED

CblParserTest > rejects books without matching attributes() PASSED

CblParserTest > rejects DTD and entity declarations() PASSED

ReadingListChapterIssueExtractorTest > preserves annual issue identity() PASSED

ReadingListChapterIssueExtractorTest > preserves issue-kind markers in additional chapter-name positions() PASSED

ReadingListChapterIssueExtractorTest > special edition text does not become a special issue() PASSED

ReadingListChapterIssueExtractorTest > annual issue does not collapse to the regular chapter fallback() PASSED

ReadingListChapterIssueExtractorTest > preserves suffix issue identity() PASSED

ReadingListChapterIssueExtractorTest > extracts a labeled issue after the series title() PASSED

ReadingListChapterIssueExtractorTest > preserves fractional issue identity() PASSED

ReadingListChapterIssueExtractorTest > matching source chapter number beats an incidental trailing year() PASSED

ReadingListChapterIssueExtractorTest > uses the source chapter number as a fallback() PASSED

ReadingListChapterIssueExtractorTest > keeps opaque issue names when they match() PASSED

ReadingListChapterIssueExtractorTest > suffix issue does not collapse to the regular chapter fallback() PASSED

ReadingListMatchOrderingTest > reading-list source order breaks display ties without bypassing ambiguity() PASSED

ReadingListMatchOrderingTest > title similarity is available to series-first search() PASSED

ReadingListMatchScorerTest > a ten point lead is sufficient for automatic acceptance() PASSED

ReadingListMatchScorerTest > user confirmed candidate overrides automatic ranking() PASSED

ReadingListMatchScorerTest > no candidates is unresolved without a synthetic score() PASSED

ReadingListMatchScorerTest > multiple user confirmed candidates are rejected() PASSED

ReadingListMatchScorerTest > issue mismatch blocks automatic acceptance even with supporting evidence() PASSED

ReadingListMatchScorerTest > exact title and issue meet the default automatic threshold() PASSED

ReadingListMatchScorerTest > title edition metadata supplies separate year evidence() PASSED

ReadingListMatchScorerTest > metadata mismatch keeps an otherwise exact candidate in review() PASSED

ReadingListMatchScorerTest > score breakdown exposes external and history evidence() PASSED

ReadingListMatchScorerTest > weak candidates remain unresolved() PASSED

ReadingListMatchScorerTest > equal high scoring candidates remain ambiguous() PASSED

ReadingListMatchScorerTest > external identifier mismatch is a penalty rather than silent evidence() PASSED

ReadingListMatchScorerTest > source preferences follow the configured hierarchy() PASSED

ReadingListMatchScorerTest > weak title similarity blocks automatic acceptance() PASSED

ReadingListSeriesKeyTest > equivalent titles without edition metadata share one series key() PASSED

ReadingListSeriesKeyTest > title metadata and explicit metadata produce the same key() PASSED

ReadingListSeriesKeyTest > different publication years keep separate series keys() PASSED

ReadingListSeriesKeyTest > different volumes keep separate series keys() PASSED

ReadingListSeriesKeyTest > different series keep different keys() PASSED

ReadingListSeriesYearEvidenceTest > parenthetical title year matches year-like cbl volume without issue-year conflict() PASSED

ReadingListSeriesYearEvidenceTest > explicit issue year remains independent when it differs from parenthetical series year() PASSED

ReadingListSeriesYearEvidenceTest > different parenthetical series year remains conflicting edition evidence() PASSED

ReadingListAutomaticResolutionUpdateTest > source unavailable rejects a synthetic confidence() PASSED

ReadingListAutomaticResolutionUpdateTest > source unavailable accepts an empty automatic outcome() PASSED

ReadingListResolutionTest > candidate identity rejects blank stable IDs() PASSED

ReadingListResolutionTest > automatic match accepts a consistent candidate() PASSED

ReadingListResolutionTest > automatic matches require an accepted candidate() PASSED

ReadingListResolutionTest > ambiguous results cannot persist an accepted candidate() PASSED

ReadingListResolutionTest > candidate score is sourced from its persisted breakdown() PASSED

ReadingListResolutionTest > chapter entry overrides require a manga override() PASSED

IssueNumberNormalizerTest > retains annual and special semantics() PASSED

IssueNumberNormalizerTest > preserves opaque issue identifiers deterministically() PASSED

IssueNumberNormalizerTest > normalizes free comic book day and one shot labels() PASSED

IssueNumberNormalizerTest > normalizes common fractional issue numbers() PASSED

IssueNumberNormalizerTest > normalizes leading zeroes labels and issue counts() PASSED

IssueNumberNormalizerTest > normalizes decimal punctuation and trailing zeroes() PASSED

IssueNumberNormalizerTest > blank issue numbers are not usable or equivalent() PASSED

IssueNumberNormalizerTest > normalizes alphabetic variants without losing the suffix() PASSED

TitleNormalizerTest > extracts a roman numeral volume before a trailing year() PASSED

TitleNormalizerTest > keeps bare years and numeric titles as title content() PASSED

TitleNormalizerTest > normalizes punctuation case accents and common symbols() PASSED

TitleNormalizerTest > blank titles are deterministic but not usable for matching() PASSED

TitleNormalizerTest > edition metadata can match a title without the edition suffix() PASSED

TitleNormalizerTest > removes apostrophes without splitting possessives() PASSED

TitleNormalizerTest > leading articles are comparison variants rather than destructive normalization() PASSED

TitleNormalizerTest > extracts trailing year and numeric volume metadata() PASSED

GetApplicationReleaseTest > When has no update expect no new update() PASSED

GetApplicationReleaseTest > When has update expect new update() PASSED

GetApplicationReleaseTest > When now is before three days expect no new update() PASSED

GetApplicationReleaseTest > When has update but is preview expect new update() PASSED
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784246793066.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':data:compileDebugKotlin' (registered by plugin 'com.android.internal.library').
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

BUILD FAILED in 10s
233 actionable tasks: 9 executed, 16 from cache, 208 up-to-date

```

## verifySqlDelightMigration

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
> Task :data:verifyDebugDatabaseMigration
> Task :data:verifyReleaseDatabaseMigration
> Task :data:verifySqlDelightMigration
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784246803692.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 5s
6 actionable tasks: 2 executed, 4 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## assemblePreview

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
> Task :data:preBuild UP-TO-DATE
> Task :data:preReleaseBuild UP-TO-DATE
> Task :core-metadata:preBuild UP-TO-DATE
> Task :core-metadata:preReleaseBuild UP-TO-DATE
> Task :domain:preBuild UP-TO-DATE
> Task :app:preBuild UP-TO-DATE
> Task :app:prePreviewBuild UP-TO-DATE
> Task :domain:preReleaseBuild UP-TO-DATE
> Task :app:mergePreviewJniLibFolders
> Task :core-metadata:mergeReleaseJniLibFolders
> Task :i18n:androidPreBuild UP-TO-DATE
> Task :i18n:preAndroidMainBuild UP-TO-DATE
> Task :domain:mergeReleaseJniLibFolders
> Task :data:mergeReleaseJniLibFolders
> Task :core-metadata:mergeReleaseNativeLibs NO-SOURCE
> Task :domain:mergeReleaseNativeLibs NO-SOURCE
> Task :data:mergeReleaseNativeLibs NO-SOURCE
> Task :i18n:mergeAndroidMainJniLibFolders
> Task :i18n:mergeAndroidMainNativeLibs NO-SOURCE
> Task :data:copyReleaseJniLibsProjectOnly
> Task :domain:copyReleaseJniLibsProjectOnly
> Task :presentation-core:preBuild UP-TO-DATE
> Task :presentation-core:preReleaseBuild UP-TO-DATE
> Task :presentation-widget:preBuild UP-TO-DATE
> Task :presentation-widget:preReleaseBuild UP-TO-DATE
> Task :i18n:copyAndroidMainJniLibsProjectOnly
> Task :core-metadata:copyReleaseJniLibsProjectOnly
> Task :source-api:androidPreBuild UP-TO-DATE
> Task :source-api:preAndroidMainBuild UP-TO-DATE
> Task :source-local:androidPreBuild UP-TO-DATE
> Task :source-local:preAndroidMainBuild UP-TO-DATE
> Task :source-api:mergeAndroidMainJniLibFolders
> Task :source-local:mergeAndroidMainJniLibFolders
> Task :presentation-widget:mergeReleaseJniLibFolders
> Task :presentation-core:mergeReleaseJniLibFolders
> Task :source-api:mergeAndroidMainNativeLibs NO-SOURCE
> Task :source-local:mergeAndroidMainNativeLibs NO-SOURCE
> Task :presentation-widget:mergeReleaseNativeLibs NO-SOURCE
> Task :presentation-core:mergeReleaseNativeLibs NO-SOURCE
> Task :source-api:copyAndroidMainJniLibsProjectOnly
> Task :presentation-widget:copyReleaseJniLibsProjectOnly
> Task :source-local:copyAndroidMainJniLibsProjectOnly
> Task :telemetry:preBuild UP-TO-DATE
> Task :core:archive:preBuild UP-TO-DATE
> Task :telemetry:preReleaseBuild UP-TO-DATE
> Task :core:archive:preReleaseBuild UP-TO-DATE
> Task :presentation-core:copyReleaseJniLibsProjectOnly
> Task :core:common:preBuild UP-TO-DATE
> Task :core:common:preReleaseBuild UP-TO-DATE
> Task :core:archive:mergeReleaseJniLibFolders
> Task :core:common:mergeReleaseJniLibFolders
> Task :core-metadata:prepareReleaseArtProfile
> Task :core:common:mergeReleaseNativeLibs NO-SOURCE
> Task :core:archive:mergeReleaseNativeLibs NO-SOURCE
> Task :data:prepareReleaseArtProfile
> Task :telemetry:mergeReleaseJniLibFolders
> Task :telemetry:mergeReleaseNativeLibs NO-SOURCE
> Task :core:archive:copyReleaseJniLibsProjectOnly
> Task :core:common:copyReleaseJniLibsProjectOnly
> Task :i18n:prepareAndroidMainArtProfile
> Task :telemetry:copyReleaseJniLibsProjectOnly
> Task :presentation-core:prepareReleaseArtProfile
> Task :presentation-widget:prepareReleaseArtProfile
> Task :domain:prepareReleaseArtProfile
> Task :source-api:prepareAndroidMainArtProfile
> Task :telemetry:prepareReleaseArtProfile
> Task :source-local:prepareAndroidMainArtProfile
> Task :core-metadata:generateReleaseResources UP-TO-DATE
> Task :core:archive:prepareReleaseArtProfile
> Task :source-api:kmpPartiallyResolvedDependenciesChecker
> Task :source-api:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:kmpPartiallyResolvedDependenciesChecker
> Task :i18n:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:common:prepareReleaseArtProfile
> Task :core:common:generateReleaseResources UP-TO-DATE
> Task :i18n:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :i18n:generateAndroidMainLocalesConfig UP-TO-DATE
> Task :core-metadata:packageReleaseResources UP-TO-DATE
> Task :core-metadata:processReleaseNavigationResources UP-TO-DATE
> Task :core:common:packageReleaseResources UP-TO-DATE
> Task :i18n:generateMRcommonTest UP-TO-DATE
> Task :core:common:processReleaseNavigationResources UP-TO-DATE
> Task :core-metadata:parseReleaseLocalResources UP-TO-DATE
> Task :core:common:parseReleaseLocalResources UP-TO-DATE
> Task :core:common:javaPreCompileRelease UP-TO-DATE
> Task :i18n:generateMRandroidHostTest UP-TO-DATE
> Task :domain:generateReleaseResources UP-TO-DATE
> Task :i18n:generateMRcommonMain UP-TO-DATE
> Task :i18n:generateMRandroidMain UP-TO-DATE
> Task :domain:packageReleaseResources UP-TO-DATE
> Task :domain:processReleaseNavigationResources UP-TO-DATE
> Task :i18n:packageAndroidMainResources UP-TO-DATE
> Task :domain:parseReleaseLocalResources UP-TO-DATE
> Task :i18n:parseAndroidMainLocalResources UP-TO-DATE
> Task :domain:javaPreCompileRelease UP-TO-DATE
> Task :source-local:kmpPartiallyResolvedDependenciesChecker
> Task :source-local:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:archive:generateReleaseResources UP-TO-DATE
> Task :core:archive:packageReleaseResources UP-TO-DATE
> Task :core:archive:processReleaseNavigationResources UP-TO-DATE
> Task :i18n:generateAndroidMainRFile UP-TO-DATE
> Task :core:archive:parseReleaseLocalResources UP-TO-DATE
> Task :core-metadata:generateReleaseRFile UP-TO-DATE
> Task :core-metadata:javaPreCompileRelease UP-TO-DATE
> Task :core:archive:generateReleaseRFile UP-TO-DATE
> Task :core:common:generateReleaseRFile UP-TO-DATE
> Task :i18n:compileAndroidMain UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :core:archive:compileReleaseKotlin UP-TO-DATE
> Task :core:archive:javaPreCompileRelease UP-TO-DATE
> Task :core:archive:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:archive:bundleLibCompileToJarRelease UP-TO-DATE
> Task :domain:generateReleaseRFile UP-TO-DATE
> Task :presentation-core:generateReleaseResources FROM-CACHE
> Task :core:common:compileReleaseKotlin UP-TO-DATE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarRelease UP-TO-DATE
> Task :presentation-core:packageReleaseResources FROM-CACHE
> Task :data:generateReleaseResources FROM-CACHE
> Task :data:packageReleaseResources FROM-CACHE
> Task :data:processReleaseNavigationResources FROM-CACHE
> Task :data:parseReleaseLocalResources FROM-CACHE
> Task :source-api:compileAndroidMain UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :data:generateReleaseRFile FROM-CACHE
> Task :core-metadata:compileReleaseKotlin UP-TO-DATE
> Task :core-metadata:compileReleaseJavaWithJavac NO-SOURCE
> Task :core-metadata:bundleLibCompileToJarRelease UP-TO-DATE
> Task :core-metadata:mergeReleaseGeneratedProguardFiles
> Task :domain:compileReleaseKotlin UP-TO-DATE
> Task :domain:compileReleaseJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarRelease UP-TO-DATE
> Task :core-metadata:exportReleaseConsumerProguardFiles
> Task :data:javaPreCompileRelease FROM-CACHE
> Task :presentation-core:processReleaseNavigationResources FROM-CACHE
> Task :presentation-core:parseReleaseLocalResources FROM-CACHE
> Task :source-local:compileAndroidMain UP-TO-DATE
> Task :source-local:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :source-local:processAndroidMainJavaRes UP-TO-DATE
> Task :source-local:createFullJarAndroidMain
> Task :presentation-widget:generateReleaseResources FROM-CACHE
> Task :presentation-widget:packageReleaseResources FROM-CACHE
> Task :presentation-core:generateReleaseRFile FROM-CACHE
> Task :presentation-widget:processReleaseNavigationResources FROM-CACHE
> Task :presentation-widget:parseReleaseLocalResources FROM-CACHE
> Task :presentation-widget:generateReleaseRFile FROM-CACHE
> Task :presentation-core:compileReleaseKotlin FROM-CACHE
> Task :presentation-core:javaPreCompileRelease FROM-CACHE
> Task :presentation-core:compileReleaseJavaWithJavac NO-SOURCE
> Task :presentation-core:bundleLibCompileToJarRelease
> Task :app:mergePreviewNativeLibs
> Task :presentation-widget:javaPreCompileRelease FROM-CACHE
> Task :domain:mergeReleaseGeneratedProguardFiles
> Task :domain:exportReleaseConsumerProguardFiles
> Task :source-api:mergeAndroidMainGeneratedProguardFiles
> Task :source-api:exportAndroidMainConsumerProguardFiles
> Task :presentation-core:mergeReleaseGeneratedProguardFiles
> Task :presentation-core:exportReleaseConsumerProguardFiles
> Task :telemetry:generateReleaseResources FROM-CACHE
> Task :telemetry:packageReleaseResources FROM-CACHE
> Task :telemetry:processReleaseNavigationResources FROM-CACHE
> Task :telemetry:parseReleaseLocalResources FROM-CACHE
> Task :telemetry:generateReleaseRFile FROM-CACHE
> Task :telemetry:compileReleaseKotlin FROM-CACHE
> Task :telemetry:javaPreCompileRelease FROM-CACHE
> Task :telemetry:compileReleaseJavaWithJavac NO-SOURCE
> Task :telemetry:mergeReleaseGeneratedProguardFiles
> Task :app:mergePreviewArtProfile
> Task :app:expandPreviewL8ArtProfileWildcards FROM-CACHE
> Task :telemetry:exportReleaseConsumerProguardFiles
> Task :core:common:mergeReleaseGeneratedProguardFiles
> Task :core:common:exportReleaseConsumerProguardFiles
> Task :i18n:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :i18n:processAndroidMainJavaRes UP-TO-DATE
> Task :i18n:createFullJarAndroidMain
> Task :core:archive:mergeReleaseGeneratedProguardFiles
> Task :core:archive:exportReleaseConsumerProguardFiles
> Task :app:stripPreviewDebugSymbols
> Task :source-api:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :source-local:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :source-local:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :telemetry:bundleLibCompileToJarRelease
> Task :core-metadata:writeReleaseAarMetadata
> Task :data:writeReleaseAarMetadata
> Task :domain:writeReleaseAarMetadata
> Task :i18n:writeAndroidMainAarMetadata UP-TO-DATE
> Task :presentation-core:writeReleaseAarMetadata
> Task :presentation-widget:writeReleaseAarMetadata
> Task :source-api:writeAndroidMainAarMetadata UP-TO-DATE
> Task :source-local:writeAndroidMainAarMetadata UP-TO-DATE
> Task :telemetry:writeReleaseAarMetadata
> Task :core:archive:writeReleaseAarMetadata
> Task :core:common:writeReleaseAarMetadata
> Task :core-metadata:extractDeepLinksRelease FROM-CACHE
> Task :core-metadata:processReleaseManifest FROM-CACHE
> Task :presentation-widget:compileReleaseKotlin
> Task :presentation-widget:compileReleaseJavaWithJavac NO-SOURCE
> Task :data:extractDeepLinksRelease FROM-CACHE
> Task :presentation-widget:mergeReleaseGeneratedProguardFiles
> Task :data:processReleaseManifest FROM-CACHE
> Task :presentation-widget:exportReleaseConsumerProguardFiles
> Task :domain:extractDeepLinksRelease FROM-CACHE
> Task :domain:processReleaseManifest FROM-CACHE
> Task :i18n:processAndroidMainManifest UP-TO-DATE
> Task :presentation-core:extractDeepLinksRelease FROM-CACHE
> Task :presentation-widget:bundleLibCompileToJarRelease
> Task :presentation-widget:extractDeepLinksRelease FROM-CACHE
> Task :presentation-core:processReleaseManifest FROM-CACHE
> Task :source-api:processAndroidMainManifest UP-TO-DATE
> Task :source-local:processAndroidMainManifest UP-TO-DATE
> Task :presentation-widget:processReleaseManifest FROM-CACHE
> Task :telemetry:extractDeepLinksRelease FROM-CACHE
> Task :core:archive:extractDeepLinksRelease FROM-CACHE
> Task :telemetry:processReleaseManifest FROM-CACHE
> Task :core:common:extractDeepLinksRelease FROM-CACHE
> Task :core:archive:processReleaseManifest FROM-CACHE
> Task :core:common:processReleaseManifest FROM-CACHE
> Task :core-metadata:mapReleaseSourceSetPaths
> Task :data:mapReleaseSourceSetPaths
> Task :core-metadata:compileReleaseLibraryResources FROM-CACHE
> Task :data:compileReleaseLibraryResources FROM-CACHE
> Task :i18n:mapAndroidMainSourceSetPaths UP-TO-DATE
> Task :domain:mapReleaseSourceSetPaths
> Task :i18n:compileAndroidMainLibraryResources UP-TO-DATE
> Task :domain:compileReleaseLibraryResources FROM-CACHE
> Task :presentation-core:mapReleaseSourceSetPaths
> Task :presentation-widget:mapReleaseSourceSetPaths
> Task :presentation-core:compileReleaseLibraryResources FROM-CACHE
> Task :telemetry:mapReleaseSourceSetPaths
> Task :telemetry:compileReleaseLibraryResources FROM-CACHE
> Task :presentation-widget:compileReleaseLibraryResources FROM-CACHE
> Task :core:archive:mapReleaseSourceSetPaths
> Task :core:common:mapReleaseSourceSetPaths
> Task :core:archive:compileReleaseLibraryResources FROM-CACHE
> Task :core:common:compileReleaseLibraryResources FROM-CACHE
> Task :core-metadata:bundleLibRuntimeToJarRelease
> Task :presentation-core:bundleLibRuntimeToJarRelease
> Task :domain:bundleLibRuntimeToJarRelease
> Task :source-api:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :telemetry:bundleLibRuntimeToJarRelease
> Task :presentation-widget:bundleLibRuntimeToJarRelease
> Task :core:archive:bundleLibRuntimeToJarRelease
> Task :core:common:bundleLibRuntimeToJarRelease
> Task :core-metadata:processReleaseJavaRes
> Task :presentation-core:processReleaseJavaRes
> Task :presentation-widget:processReleaseJavaRes
> Task :source-api:processAndroidMainJavaRes UP-TO-DATE
> Task :telemetry:processReleaseJavaRes
> Task :domain:processReleaseJavaRes
> Task :core:archive:processReleaseJavaRes
> Task :core-metadata:generateReleaseAssets UP-TO-DATE
> Task :core-metadata:mergeReleaseAssets
> Task :data:generateReleaseAssets UP-TO-DATE
> Task :data:mergeReleaseAssets
> Task :domain:generateReleaseAssets UP-TO-DATE
> Task :core:common:processReleaseJavaRes
> Task :i18n:generateAndroidMainAssets UP-TO-DATE
> Task :i18n:mergeAndroidMainAssets
> Task :domain:mergeReleaseAssets
> Task :presentation-widget:generateReleaseAssets UP-TO-DATE
> Task :presentation-core:generateReleaseAssets UP-TO-DATE
> Task :presentation-widget:mergeReleaseAssets
> Task :telemetry:generateReleaseAssets UP-TO-DATE
> Task :presentation-core:mergeReleaseAssets
> Task :core:archive:generateReleaseAssets UP-TO-DATE
> Task :telemetry:mergeReleaseAssets
> Task :core:archive:mergeReleaseAssets
> Task :core:common:generateReleaseAssets UP-TO-DATE
> Task :core:common:mergeReleaseAssets
> Task :app:checkPreviewDuplicateClasses
> Task :app:extractPreviewNativeSymbolTables FROM-CACHE
> Task :app:compilePreviewAidl FROM-CACHE
> Task :app:dataBindingMergeDependencyArtifactsPreview
> Task :app:generatePreviewResources FROM-CACHE
> Task :app:prepareLibraryDefinitionsPreview FROM-CACHE
> Task :app:replacePreviewShortcutPlaceholder
> Task :app:mergePreviewNativeDebugMetadata
> Task :app:generatePreviewBuildConfig
> Task :app:packagePreviewResources
> Task :app:processPreviewNavigationResources
> Task :app:javaPreCompilePreview FROM-CACHE
> Task :data:generateReleaseDatabaseInterface
> Task :app:parsePreviewLocalResources
> Task :app:checkPreviewAarMetadata
> Task :app:mapPreviewSourceSetPaths
> Task :app:compilePreviewNavigationResources FROM-CACHE
> Task :app:createPreviewCompatibleScreenManifests
> Task :app:extractDeepLinksPreview FROM-CACHE
> Task :app:processPreviewMainManifest
> Task :app:processPreviewManifest
> Task :app:processPreviewManifestForPackage
> Task :app:extractProguardFiles
> Task :app:mergePreviewStartupProfile
> Task :app:generatePreviewAssets UP-TO-DATE
> Task :app:generatePreviewRFile
> Task :app:mergePreviewAssets
> Task :app:compressPreviewAssets FROM-CACHE
> Task :app:extractPreviewVersionControlInfo
> Task :app:validateSigningPreview
> Task :app:writePreviewAppMetadata
> Task :app:writePreviewSigningConfigVersions
> Task :app:mergePreviewResources
> Task :app:dataBindingGenBaseClassesPreview FROM-CACHE

> Task :data:compileReleaseKotlin FAILED
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:109:21 Overload resolution ambiguity between candidates:
fun CblReadingList.requireValidPersistenceOrder(): Unit
fun CblReadingList.requireValidPersistenceOrder(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:110:27 Overload resolution ambiguity between candidates:
fun List<Long>.requireValidSourceSelection(): Unit
fun List<Long>.requireValidSourceSelection(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:162:27 Overload resolution ambiguity between candidates:
fun List<Long>.requireValidSourceSelection(): Unit
fun List<Long>.requireValidSourceSelection(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:440:9 Conflicting overloads:
fun CblReadingList.requireValidPersistenceOrder(): Unit
e: file:///home/runner/work/Yomori/Yomori/data/src/main/java/tachiyomi/data/readinglist/ReadingListRepositoryImpl.kt:448:9 Conflicting overloads:
fun List<Long>.requireValidSourceSelection(): Unit

> Task :app:processPreviewResources
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784246809228.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':data:compileReleaseKotlin' (registered by plugin 'com.android.internal.library').
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

BUILD FAILED in 19s
254 actionable tasks: 127 executed, 60 from cache, 67 up-to-date

```

## gitDiffCheck

Exit code: `0`

```text

```

