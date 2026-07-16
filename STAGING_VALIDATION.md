# Cross-series reader staging validation

Commit before validation: `d68c75470c929fd9685a302a0e0dcdf3523b0d2b`

## spotlessApply

Exit code: `1`

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
> Task :core-metadata:spotlessKotlinGradle FROM-CACHE
> Task :spotlessKotlinGradle FROM-CACHE
> Task :core-metadata:spotlessKotlinGradleApply UP-TO-DATE
> Task :spotlessKotlinGradleApply UP-TO-DATE
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
> Task :app:spotlessKotlinApply FAILED
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784245607386.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:spotlessKotlinApply' (registered by plugin 'mihon.plugins.spotless').
> There were 1 lint error(s), they must be fixed or suppressed.
  src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListReaderDialogs.kt:L101 ktlint(standard:max-line-length) Exceeded max line length (120)
  Resolve these lints or suppress with `suppressLintsFor`

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights from a Build Scan (powered by Develocity).
> Get more help at https://help.gradle.org.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD FAILED in 26s
82 actionable tasks: 9 executed, 37 from cache, 36 up-to-date

```

## spotlessCheck

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
> Task :spotlessKotlin UP-TO-DATE
> Task :core-metadata:spotlessKotlin UP-TO-DATE
> Task :build-logic:spotlessKotlin UP-TO-DATE
> Task :core-metadata:spotlessKotlinCheck UP-TO-DATE
> Task :spotlessKotlinCheck UP-TO-DATE
> Task :spotlessKotlinGradle UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradle UP-TO-DATE
> Task :spotlessKotlinGradleCheck UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradleCheck UP-TO-DATE
> Task :data:spotlessKotlin UP-TO-DATE
> Task :data:spotlessKotlinCheck UP-TO-DATE
> Task :core-metadata:spotlessXml UP-TO-DATE
> Task :spotlessXml UP-TO-DATE
> Task :spotlessXmlCheck UP-TO-DATE
> Task :core-metadata:spotlessXmlCheck UP-TO-DATE
> Task :core-metadata:spotlessCheck UP-TO-DATE
> Task :data:spotlessKotlinGradle UP-TO-DATE
> Task :data:spotlessKotlinGradleCheck UP-TO-DATE
> Task :data:spotlessXml UP-TO-DATE
> Task :data:spotlessXmlCheck UP-TO-DATE
> Task :data:spotlessCheck UP-TO-DATE
> Task :i18n:spotlessKotlin UP-TO-DATE
> Task :i18n:spotlessKotlinCheck UP-TO-DATE
> Task :domain:spotlessKotlin UP-TO-DATE
> Task :domain:spotlessKotlinCheck UP-TO-DATE
> Task :i18n:spotlessKotlinGradle UP-TO-DATE
> Task :i18n:spotlessKotlinGradleCheck UP-TO-DATE
> Task :domain:spotlessKotlinGradle UP-TO-DATE
> Task :domain:spotlessKotlinGradleCheck UP-TO-DATE
> Task :i18n:spotlessXml UP-TO-DATE
> Task :i18n:spotlessXmlCheck UP-TO-DATE
> Task :i18n:spotlessCheck UP-TO-DATE
> Task :presentation-core:spotlessKotlin UP-TO-DATE
> Task :presentation-core:spotlessKotlinCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlin UP-TO-DATE
> Task :presentation-widget:spotlessKotlinCheck UP-TO-DATE
> Task :domain:spotlessXml UP-TO-DATE
> Task :presentation-core:spotlessKotlinGradle UP-TO-DATE
> Task :domain:spotlessXmlCheck UP-TO-DATE
> Task :domain:spotlessCheck UP-TO-DATE
> Task :presentation-core:spotlessKotlinGradleCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlinGradle UP-TO-DATE
> Task :presentation-widget:spotlessKotlinGradleCheck UP-TO-DATE
> Task :presentation-widget:spotlessXml UP-TO-DATE
> Task :presentation-core:spotlessXml UP-TO-DATE
> Task :presentation-core:spotlessXmlCheck UP-TO-DATE
> Task :presentation-core:spotlessCheck UP-TO-DATE
> Task :presentation-widget:spotlessXmlCheck UP-TO-DATE
> Task :presentation-widget:spotlessCheck UP-TO-DATE
> Task :app:spotlessKotlin
> Task :app:spotlessKotlinCheck FAILED
> Task :source-api:spotlessKotlin UP-TO-DATE
> Task :telemetry:spotlessKotlin UP-TO-DATE
> Task :build-logic:spotlessKotlinCheck UP-TO-DATE
> Task :build-logic:spotlessKotlinGradle UP-TO-DATE
> Task :build-logic:spotlessKotlinGradleCheck UP-TO-DATE
> Task :build-logic:spotlessCheck UP-TO-DATE
> Task :source-local:spotlessKotlin UP-TO-DATE
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784245631373.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:spotlessKotlinCheck' (registered by plugin 'mihon.plugins.spotless').
> There were 1 lint error(s), they must be fixed or suppressed.
  src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListReaderDialogs.kt:L101 ktlint(standard:max-line-length) Exceeded max line length (120)
  Resolve these lints or suppress with `suppressLintsFor`

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights from a Build Scan (powered by Develocity).
> Get more help at https://help.gradle.org.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD FAILED in 1s
55 actionable tasks: 2 executed, 53 up-to-date

```

## testDebugUnitTest

Exit code: `1`

```text
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
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784245633473.json

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

BUILD FAILED in 44s
233 actionable tasks: 87 executed, 142 from cache, 4 up-to-date

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
> Task :data:verifyReleaseDatabaseMigration
> Task :data:verifyDebugDatabaseMigration
> Task :data:verifySqlDelightMigration
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784245677689.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 4s
6 actionable tasks: 2 executed, 4 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## assemblePreview

Exit code: `1`

```text
> Task :telemetry:generateReleaseRFile FROM-CACHE
> Task :telemetry:compileReleaseKotlin FROM-CACHE
> Task :telemetry:javaPreCompileRelease FROM-CACHE
> Task :telemetry:compileReleaseJavaWithJavac NO-SOURCE
> Task :telemetry:mergeReleaseGeneratedProguardFiles
> Task :telemetry:exportReleaseConsumerProguardFiles
> Task :core:common:mergeReleaseGeneratedProguardFiles
> Task :core:common:exportReleaseConsumerProguardFiles
> Task :i18n:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :i18n:processAndroidMainJavaRes UP-TO-DATE
> Task :i18n:createFullJarAndroidMain
> Task :core:archive:mergeReleaseGeneratedProguardFiles
> Task :app:extractPreviewNativeSymbolTables FROM-CACHE
> Task :core:archive:exportReleaseConsumerProguardFiles
> Task :source-api:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :source-local:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :source-local:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :telemetry:bundleLibCompileToJarRelease
> Task :app:checkPreviewDuplicateClasses
> Task :app:compilePreviewAidl FROM-CACHE
> Task :app:dataBindingMergeDependencyArtifactsPreview
> Task :app:generatePreviewResources FROM-CACHE
> Task :app:prepareLibraryDefinitionsPreview FROM-CACHE
> Task :app:replacePreviewShortcutPlaceholder
> Task :app:mergePreviewNativeDebugMetadata
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
> Task :data:extractDeepLinksRelease FROM-CACHE
> Task :data:processReleaseManifest FROM-CACHE
> Task :domain:extractDeepLinksRelease FROM-CACHE
> Task :domain:processReleaseManifest FROM-CACHE
> Task :i18n:processAndroidMainManifest UP-TO-DATE
> Task :presentation-core:extractDeepLinksRelease FROM-CACHE
> Task :presentation-core:processReleaseManifest FROM-CACHE
> Task :presentation-widget:extractDeepLinksRelease FROM-CACHE
> Task :presentation-widget:processReleaseManifest FROM-CACHE
> Task :source-api:processAndroidMainManifest UP-TO-DATE
> Task :source-local:processAndroidMainManifest UP-TO-DATE
> Task :telemetry:extractDeepLinksRelease FROM-CACHE
> Task :telemetry:processReleaseManifest FROM-CACHE
> Task :core:archive:extractDeepLinksRelease FROM-CACHE
> Task :core:archive:processReleaseManifest FROM-CACHE
> Task :core:common:extractDeepLinksRelease FROM-CACHE
> Task :core:common:processReleaseManifest FROM-CACHE
> Task :core-metadata:mapReleaseSourceSetPaths
> Task :core-metadata:compileReleaseLibraryResources FROM-CACHE
> Task :data:mapReleaseSourceSetPaths
> Task :data:compileReleaseLibraryResources FROM-CACHE
> Task :domain:mapReleaseSourceSetPaths
> Task :domain:compileReleaseLibraryResources FROM-CACHE
> Task :i18n:mapAndroidMainSourceSetPaths UP-TO-DATE
> Task :i18n:compileAndroidMainLibraryResources UP-TO-DATE
> Task :presentation-core:mapReleaseSourceSetPaths
> Task :presentation-core:compileReleaseLibraryResources FROM-CACHE
> Task :presentation-widget:mapReleaseSourceSetPaths
> Task :presentation-widget:compileReleaseLibraryResources FROM-CACHE
> Task :telemetry:mapReleaseSourceSetPaths
> Task :telemetry:compileReleaseLibraryResources FROM-CACHE
> Task :core:archive:mapReleaseSourceSetPaths
> Task :core:archive:compileReleaseLibraryResources FROM-CACHE
> Task :core:common:mapReleaseSourceSetPaths
> Task :core:common:compileReleaseLibraryResources FROM-CACHE
> Task :core-metadata:bundleLibRuntimeToJarRelease
> Task :domain:bundleLibRuntimeToJarRelease
> Task :presentation-core:bundleLibRuntimeToJarRelease
> Task :source-api:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :telemetry:bundleLibRuntimeToJarRelease
> Task :core:archive:bundleLibRuntimeToJarRelease
> Task :core:common:bundleLibRuntimeToJarRelease
> Task :core-metadata:processReleaseJavaRes
> Task :domain:processReleaseJavaRes
> Task :presentation-core:processReleaseJavaRes
> Task :source-api:processAndroidMainJavaRes UP-TO-DATE
> Task :telemetry:processReleaseJavaRes
> Task :core:archive:processReleaseJavaRes
> Task :core:common:processReleaseJavaRes
> Task :core-metadata:generateReleaseAssets UP-TO-DATE
> Task :core-metadata:mergeReleaseAssets
> Task :data:generateReleaseAssets UP-TO-DATE
> Task :data:mergeReleaseAssets
> Task :domain:generateReleaseAssets UP-TO-DATE
> Task :domain:mergeReleaseAssets
> Task :i18n:generateAndroidMainAssets UP-TO-DATE
> Task :i18n:mergeAndroidMainAssets
> Task :presentation-core:generateReleaseAssets UP-TO-DATE
> Task :presentation-core:mergeReleaseAssets
> Task :presentation-widget:generateReleaseAssets UP-TO-DATE
> Task :presentation-widget:mergeReleaseAssets
> Task :telemetry:generateReleaseAssets UP-TO-DATE
> Task :telemetry:mergeReleaseAssets
> Task :core:archive:generateReleaseAssets UP-TO-DATE
> Task :core:archive:mergeReleaseAssets
> Task :core:common:generateReleaseAssets UP-TO-DATE
> Task :core:common:mergeReleaseAssets
> Task :presentation-widget:compileReleaseKotlin
> Task :presentation-widget:compileReleaseJavaWithJavac NO-SOURCE
> Task :presentation-widget:mergeReleaseGeneratedProguardFiles
> Task :presentation-widget:exportReleaseConsumerProguardFiles
> Task :presentation-widget:bundleLibRuntimeToJarRelease
> Task :presentation-widget:bundleLibCompileToJarRelease
> Task :presentation-widget:processReleaseJavaRes
> Task :app:generatePreviewBuildConfig
> Task :app:packagePreviewResources
> Task :app:processPreviewNavigationResources
> Task :app:javaPreCompilePreview FROM-CACHE
> Task :app:parsePreviewLocalResources
> Task :app:checkPreviewAarMetadata
> Task :app:mapPreviewSourceSetPaths
> Task :app:compilePreviewNavigationResources FROM-CACHE
> Task :app:createPreviewCompatibleScreenManifests
> Task :app:extractDeepLinksPreview FROM-CACHE
> Task :app:processPreviewMainManifest
> Task :app:processPreviewManifest
> Task :app:processPreviewManifestForPackage
> Task :app:generatePreviewRFile
> Task :app:extractProguardFiles
> Task :app:mergePreviewStartupProfile
> Task :app:generatePreviewAssets UP-TO-DATE
> Task :app:mergePreviewAssets
> Task :app:compressPreviewAssets FROM-CACHE
> Task :app:extractPreviewVersionControlInfo
> Task :data:generateReleaseDatabaseInterface
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
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784245682250.json

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

BUILD FAILED in 16s
254 actionable tasks: 127 executed, 60 from cache, 67 up-to-date

```

## gitDiffCheck

Exit code: `0`

```text

```

