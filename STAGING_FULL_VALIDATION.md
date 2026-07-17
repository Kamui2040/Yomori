# Full cross-series reader staging validation

Commit before validation: `ff736b26c4268188a4b5a8811503f4bca88f2c00`

## spotlessCheck

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
> Task :spotlessKotlinCheck UP-TO-DATE
> Task :core-metadata:spotlessKotlinCheck UP-TO-DATE
> Task :core-metadata:spotlessKotlinGradle FROM-CACHE
> Task :core-metadata:spotlessKotlinGradleCheck UP-TO-DATE
> Task :spotlessKotlinGradle FROM-CACHE
> Task :spotlessKotlinGradleCheck UP-TO-DATE
> Task :core-metadata:spotlessXml FROM-CACHE
> Task :core-metadata:spotlessXmlCheck UP-TO-DATE
> Task :core-metadata:spotlessCheck UP-TO-DATE
> Task :spotlessXml FROM-CACHE
> Task :spotlessXmlCheck UP-TO-DATE
> Task :build-logic:spotlessKotlin FROM-CACHE
> Task :i18n:spotlessKotlin FROM-CACHE
> Task :i18n:spotlessKotlinCheck UP-TO-DATE
> Task :i18n:spotlessKotlinGradle FROM-CACHE
> Task :i18n:spotlessKotlinGradleCheck UP-TO-DATE
> Task :i18n:spotlessXml FROM-CACHE
> Task :i18n:spotlessXmlCheck UP-TO-DATE
> Task :i18n:spotlessCheck UP-TO-DATE
> Task :presentation-core:spotlessKotlin FROM-CACHE
> Task :presentation-core:spotlessKotlinCheck UP-TO-DATE
> Task :presentation-core:spotlessKotlinGradle FROM-CACHE
> Task :presentation-core:spotlessKotlinGradleCheck UP-TO-DATE
> Task :presentation-core:spotlessXml FROM-CACHE
> Task :presentation-core:spotlessXmlCheck UP-TO-DATE
> Task :presentation-core:spotlessCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlin FROM-CACHE
> Task :presentation-widget:spotlessKotlinCheck UP-TO-DATE
> Task :presentation-widget:spotlessKotlinGradle FROM-CACHE
> Task :presentation-widget:spotlessKotlinGradleCheck UP-TO-DATE
> Task :presentation-widget:spotlessXml FROM-CACHE
> Task :presentation-widget:spotlessXmlCheck UP-TO-DATE
> Task :presentation-widget:spotlessCheck UP-TO-DATE
> Task :source-api:spotlessKotlin FROM-CACHE
> Task :source-api:spotlessKotlinCheck UP-TO-DATE
> Task :source-api:spotlessKotlinGradle FROM-CACHE
> Task :source-api:spotlessKotlinGradleCheck UP-TO-DATE
> Task :source-api:spotlessXml FROM-CACHE
> Task :source-api:spotlessXmlCheck UP-TO-DATE
> Task :source-api:spotlessCheck UP-TO-DATE
> Task :source-local:spotlessKotlin FROM-CACHE
> Task :source-local:spotlessKotlinCheck UP-TO-DATE
> Task :source-local:spotlessKotlinGradle FROM-CACHE
> Task :source-local:spotlessKotlinGradleCheck UP-TO-DATE
> Task :source-local:spotlessXml FROM-CACHE
> Task :source-local:spotlessXmlCheck UP-TO-DATE
> Task :source-local:spotlessCheck UP-TO-DATE
> Task :telemetry:spotlessKotlin FROM-CACHE
> Task :telemetry:spotlessKotlinCheck UP-TO-DATE
> Task :telemetry:spotlessKotlinGradle FROM-CACHE
> Task :telemetry:spotlessKotlinGradleCheck UP-TO-DATE
> Task :telemetry:spotlessXml FROM-CACHE
> Task :telemetry:spotlessXmlCheck UP-TO-DATE
> Task :telemetry:spotlessCheck UP-TO-DATE
> Task :core:archive:spotlessKotlin FROM-CACHE
> Task :core:archive:spotlessKotlinCheck UP-TO-DATE
> Task :core:archive:spotlessKotlinGradle FROM-CACHE
> Task :core:archive:spotlessKotlinGradleCheck UP-TO-DATE
> Task :core:archive:spotlessXml FROM-CACHE
> Task :core:archive:spotlessXmlCheck UP-TO-DATE
> Task :core:archive:spotlessCheck UP-TO-DATE
> Task :core:common:spotlessKotlin FROM-CACHE
> Task :core:common:spotlessKotlinCheck UP-TO-DATE
> Task :core:common:spotlessKotlinGradle FROM-CACHE
> Task :core:common:spotlessKotlinGradleCheck UP-TO-DATE
> Task :core:common:spotlessXml FROM-CACHE
> Task :core:common:spotlessXmlCheck UP-TO-DATE
> Task :core:common:spotlessCheck UP-TO-DATE
> Task :build-logic:spotlessKotlinCheck UP-TO-DATE
> Task :build-logic:spotlessKotlinGradle FROM-CACHE
> Task :build-logic:spotlessKotlinGradleCheck UP-TO-DATE
> Task :build-logic:spotlessCheck UP-TO-DATE
> Task :spotlessCheck UP-TO-DATE
> Task :data:spotlessKotlin
> Task :data:spotlessKotlinCheck
> Task :data:spotlessKotlinGradle FROM-CACHE
> Task :data:spotlessKotlinGradleCheck UP-TO-DATE
> Task :data:spotlessXml FROM-CACHE
> Task :data:spotlessXmlCheck UP-TO-DATE
> Task :data:spotlessCheck
> Task :domain:spotlessKotlin
> Task :domain:spotlessKotlinCheck
> Task :domain:spotlessKotlinGradle FROM-CACHE
> Task :domain:spotlessKotlinGradleCheck UP-TO-DATE
> Task :domain:spotlessXml FROM-CACHE
> Task :domain:spotlessXmlCheck UP-TO-DATE
> Task :domain:spotlessCheck
> Task :app:spotlessKotlin
> Task :app:spotlessKotlinCheck
> Task :app:spotlessKotlinGradle FROM-CACHE
> Task :app:spotlessKotlinGradleCheck UP-TO-DATE
> Task :app:spotlessXml
> Task :app:spotlessXmlCheck
> Task :app:spotlessCheck
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784249308118.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 33s
86 actionable tasks: 11 executed, 38 from cache, 37 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## testDebugUnitTest

Exit code: `0`

```text
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
> Task :core:common:compileReleaseKotlin FROM-CACHE
> Task :core-metadata:javaPreCompileRelease FROM-CACHE
> Task :domain:preReleaseBuild UP-TO-DATE
> Task :core:common:javaPreCompileRelease FROM-CACHE
> Task :domain:generateReleaseResources FROM-CACHE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :domain:packageReleaseResources FROM-CACHE
> Task :domain:processReleaseNavigationResources FROM-CACHE
> Task :core:common:bundleLibCompileToJarRelease
> Task :domain:parseReleaseLocalResources FROM-CACHE
> Task :domain:generateReleaseRFile FROM-CACHE
> Task :domain:javaPreCompileRelease FROM-CACHE
> Task :source-local:kmpPartiallyResolvedDependenciesChecker
> Task :source-local:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:archive:preReleaseBuild UP-TO-DATE
> Task :core:archive:generateReleaseResources FROM-CACHE
> Task :core:common:compileDebugKotlin FROM-CACHE
> Task :core:archive:packageReleaseResources FROM-CACHE
> Task :core:common:javaPreCompileDebug FROM-CACHE
> Task :core:common:compileDebugJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarDebug
> Task :source-api:compileAndroidMain FROM-CACHE
> Task :source-api:bundleAndroidMainClassesToCompileJar
> Task :core-metadata:compileDebugKotlin FROM-CACHE
> Task :core-metadata:compileDebugJavaWithJavac NO-SOURCE
> Task :core-metadata:bundleLibCompileToJarDebug
> Task :presentation-core:compileDebugKotlin FROM-CACHE
> Task :presentation-core:compileDebugJavaWithJavac NO-SOURCE
> Task :presentation-core:bundleLibCompileToJarDebug
> Task :core-metadata:compileReleaseKotlin FROM-CACHE
> Task :core-metadata:compileReleaseJavaWithJavac NO-SOURCE
> Task :core-metadata:bundleLibCompileToJarRelease
> Task :core:archive:processReleaseNavigationResources FROM-CACHE
> Task :core:archive:parseReleaseLocalResources FROM-CACHE
> Task :core:archive:generateReleaseRFile FROM-CACHE
> Task :core:archive:compileReleaseKotlin FROM-CACHE
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
> Task :presentation-core:compileDebugLibraryResources FROM-CACHE
> Task :presentation-widget:mapDebugSourceSetPaths
> Task :presentation-widget:compileDebugLibraryResources FROM-CACHE
> Task :telemetry:mapDebugSourceSetPaths
> Task :telemetry:compileDebugLibraryResources FROM-CACHE
> Task :core:archive:mapDebugSourceSetPaths
> Task :data:generateDebugDatabaseInterface
> Task :domain:writeDebugAarMetadata
> Task :app:generateDebugBuildConfig
> Task :app:packageDebugResources
> Task :app:processDebugNavigationResources
> Task :app:parseDebugLocalResources
> Task :app:generateDebugRFile
> Task :app:javaPreCompileDebug FROM-CACHE
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
> Task :core-metadata:preDebugUnitTestBuild UP-TO-DATE
> Task :core-metadata:generateDebugUnitTestStubRFile FROM-CACHE
> Task :core-metadata:compileDebugUnitTestKotlin NO-SOURCE
> Task :core-metadata:javaPreCompileDebugUnitTest FROM-CACHE
> Task :core-metadata:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :core-metadata:processDebugUnitTestJavaRes NO-SOURCE
> Task :core-metadata:testDebugUnitTest NO-SOURCE
> Task :data:preDebugUnitTestBuild UP-TO-DATE
> Task :data:generateDebugUnitTestStubRFile FROM-CACHE
> Task :data:javaPreCompileDebugUnitTest FROM-CACHE
> Task :domain:preDebugUnitTestBuild UP-TO-DATE
> Task :domain:generateDebugUnitTestStubRFile FROM-CACHE
> Task :domain:javaPreCompileDebugUnitTest FROM-CACHE
> Task :presentation-core:preDebugUnitTestBuild UP-TO-DATE
> Task :presentation-core:generateDebugUnitTestStubRFile FROM-CACHE
> Task :presentation-core:compileDebugUnitTestKotlin NO-SOURCE
> Task :presentation-core:javaPreCompileDebugUnitTest FROM-CACHE
> Task :presentation-core:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :presentation-core:processDebugUnitTestJavaRes NO-SOURCE
> Task :presentation-core:testDebugUnitTest NO-SOURCE
> Task :presentation-widget:preDebugUnitTestBuild UP-TO-DATE
> Task :presentation-widget:generateDebugUnitTestStubRFile FROM-CACHE
> Task :presentation-widget:javaPreCompileDebugUnitTest FROM-CACHE
> Task :telemetry:preDebugUnitTestBuild UP-TO-DATE
> Task :telemetry:generateDebugUnitTestStubRFile FROM-CACHE
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
> Task :core:common:preDebugUnitTestBuild UP-TO-DATE
> Task :core:common:generateDebugUnitTestStubRFile FROM-CACHE
> Task :app:mergeDebugResources
> Task :core:common:compileDebugUnitTestKotlin FROM-CACHE
> Task :core:common:javaPreCompileDebugUnitTest FROM-CACHE
> Task :core:common:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :core:common:processDebugUnitTestJavaRes
> Task :app:dataBindingGenBaseClassesDebug FROM-CACHE
> Task :core:common:testDebugUnitTest FROM-CACHE
> Task :app:processDebugResources
> Task :domain:compileDebugKotlin
> Task :domain:compileReleaseKotlin
> Task :domain:compileDebugJavaWithJavac NO-SOURCE
> Task :domain:processDebugJavaRes
> Task :domain:compileReleaseJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarDebug
> Task :domain:bundleLibRuntimeToJarDebug
> Task :domain:bundleLibCompileToJarRelease
> Task :presentation-widget:compileDebugKotlin
> Task :presentation-widget:compileDebugJavaWithJavac NO-SOURCE
> Task :presentation-widget:bundleLibCompileToJarDebug
> Task :presentation-widget:bundleLibRuntimeToJarDebug
> Task :presentation-widget:processDebugJavaRes
> Task :presentation-widget:compileDebugUnitTestKotlin NO-SOURCE
> Task :presentation-widget:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :presentation-widget:processDebugUnitTestJavaRes NO-SOURCE
> Task :presentation-widget:testDebugUnitTest NO-SOURCE
> Task :source-local:compileAndroidMain
> Task :source-local:bundleAndroidMainClassesToCompileJar
> Task :source-local:bundleAndroidMainClassesToRuntimeJar
> Task :source-local:processAndroidMainJavaRes
> Task :domain:compileDebugUnitTestKotlin
> Task :domain:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :domain:processDebugUnitTestJavaRes

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

> Task :data:compileDebugKotlin
> Task :data:compileDebugJavaWithJavac NO-SOURCE
> Task :data:processDebugJavaRes
> Task :data:bundleLibCompileToJarDebug
> Task :data:bundleLibRuntimeToJarDebug
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

ReadingListResolutionAtomicWriteTest > combined write requires the accepted snapshot to match exactly() PASSED

ReadingListResolutionAtomicWriteTest > candidate replacement and automatic match are committed together() PASSED

ReadingListResolutionAtomicWriteTest > confirmed entries refuse the combined automatic write() PASSED

ReadingListResolutionAtomicWriteTest > skipped entries refuse the combined automatic write() PASSED

ReadingListResolutionRepositoryImplTest > confirmed entries refuse candidate replacement() PASSED

ReadingListResolutionRepositoryImplTest > entry override updates preserve creation time() PASSED

ReadingListResolutionRepositoryImplTest > candidate rejections survive candidate refresh() PASSED

ReadingListResolutionSqlTest > automatic resolution cannot modify an explicitly skipped entry() PASSED

ReadingListResolutionSqlTest > deleting a list cascades through resolution storage() PASSED

ReadingListResolutionSqlTest > automatic series mappings cannot replace confirmed mappings() PASSED

ReadingListResolutionSqlTest > automatic resolution cannot overwrite a confirmed entry() PASSED

ReadingListStorageCodecTest > rejects empty source selections() PASSED

ReadingListStorageCodecTest > rejects duplicate source IDs() PASSED

ReadingListStorageCodecTest > round trips match score breakdowns() PASSED

ReadingListStorageCodecTest > rejects gaps or reordered positions() PASSED

ReadingListStorageCodecTest > rejects blank matching identifiers() PASSED

ReadingListStorageCodecTest > round trips original CBL metadata() PASSED

ReadingListStorageCodecTest > round trips parser warnings() PASSED

ReadingListStorageCodecTest > accepts contiguous authoritative positions() PASSED

ReadingListStorageCodecTest > accepts ordered unique source IDs including signed IDs() PASSED

> Task :app:compileDebugKotlin
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/download/DownloadManager.kt:224:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/download/DownloadManager.kt:251:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/download/Downloader.kt:115:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/library/LibraryUpdateNotifier.kt:211:13 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/notification/NotificationReceiver.kt:200:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/notification/NotificationReceiver.kt:226:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/reader/loader/HttpPageLoader.kt:134:13 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt:100:57 'val Icons.Outlined.List: ImageVector' is deprecated. Use the AutoMirrored version at Icons.AutoMirrored.Outlined.List.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt:350:46 'val Icons.Outlined.List: ImageVector' is deprecated. Use the AutoMirrored version at Icons.AutoMirrored.Outlined.List.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt:413:5 'fun ListItem(headlineContent: ComposableFunction0<Unit>, modifier: Modifier = ..., overlineContent: ComposableFunction0<Unit>? = ..., supportingContent: ComposableFunction0<Unit>? = ..., leadingContent: ComposableFunction0<Unit>? = ..., trailingContent: ComposableFunction0<Unit>? = ..., colors: ListItemColors = ..., tonalElevation: Dp = ..., shadowElevation: Dp = ...): Unit' is deprecated. Use the overload where `headlineContent` is now a trailing `content` lambda.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt:468:54 'val Icons.Outlined.List: ImageVector' is deprecated. Use the AutoMirrored version at Icons.AutoMirrored.Outlined.List.

> Task :app:compileDebugJavaWithJavac
> Task :app:processDebugJavaRes
> Task :app:bundleDebugClassesToCompileJar
> Task :app:bundleDebugClassesToRuntimeJar
> Task :app:compileDebugUnitTestKotlin
> Task :app:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :app:processDebugUnitTestJavaRes
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended

> Task :app:testDebugUnitTest

ReaderErrorMessageTest > detects wrapped null pointer failures() PASSED

ReaderErrorMessageTest > replaces HTTP source null pointer failures() PASSED

ReaderErrorMessageTest > preserves local source failures() PASSED

ReaderErrorMessageTest > preserves informative HTTP source failures() PASSED

CblDocumentReaderTest > empty documents decode deterministically() PASSED

CblDocumentReaderTest > decodes UTF-8 with and without BOM() PASSED

CblDocumentReaderTest > decodes UTF-16 little endian with and without BOM() PASSED

CblDocumentReaderTest > decodes UTF-16 big endian with and without BOM() PASSED

ReadingListCandidateSearchTest > unavailable confirmed mapping does not search replacement sources() PASSED

ReadingListCandidateSearchTest > confirmed series mapping avoids replacement series searches() PASSED

ReadingListCandidateSearchTest > confirmed series history requires the same manga() PASSED

ReadingListCandidateSearchTest > confirmed and skipped entries are not searched or replaced() PASSED

ReadingListCandidateSearchTest > searches one selected source once for entries in the same series() PASSED

ReadingListCandidateSearchTest > one failing source does not discard another source result() PASSED

ReadingListCandidateSearchTest > missing chapter override is not converted into a synthetic match() PASSED

ReadingListCandidateSearchTest > unavailable entry override is not bypassed by lower priority sources() PASSED

ReadingListCandidateSearchTest > queued requests receive their full timeout after acquiring the permit() PASSED

ReadingListCandidateSearchTest > marks eligible entries unavailable when no selected source is installed() PASSED

ReadingListCandidateSearchTest > entry override takes precedence over a confirmed series mapping() PASSED

ReadingListCandidateSearchTest > entry override seed is eligible only for its owning entry() PASSED

ReadingListCandidateSearchTest > source-only entry override limits the series search() PASSED

ReadingListCandidateSearchTest > source requests time out without blocking the whole search() PASSED

ReadingListCandidateSearchTest > rejected candidates are not returned to automatic matching() PASSED

ReadingListCandidateSearchTest > simultaneous list searches share the configured request limit() PASSED

ReadingListReaderNavigatorTest > previous before first is a boundary and next after final completes the list() PASSED

ReadingListReaderNavigatorTest > skipped entry and incomplete identities block without contacting a source() PASSED

ReadingListReaderNavigatorTest > skipping the final blocked entry completes only the list() PASSED

ReadingListReaderNavigatorTest > start resumes persisted position independently of shared chapter read state() PASSED

ReadingListReaderNavigatorTest > existing exact local manga and chapter are reused without extension requests() PASSED

ReadingListReaderNavigatorTest > unselected and unavailable sources never fall back to another selected source() PASSED

ReadingListReaderNavigatorTest > start opens position zero in cbl order even when repository entries are unsorted() PASSED

ReadingListReaderNavigatorTest > next and previous follow cbl positions instead of repository or manga order() PASSED

ReadingListReaderNavigatorTest > explicit read materializes only the exact non-favorite manga and chapter() PASSED

ReadingListReaderNavigatorTest > empty list completes without pointing progress at a missing entry() PASSED

ReadingListReaderNavigatorTest > completed list requires explicit restart and restart clears completion at position zero() PASSED

ReadingListReaderNavigatorTest > source timeout blocks the entry without losing its saved identity() PASSED

ReadingListReaderNavigatorTest > explicit skip advances exactly one position and stops again when the following entry is blocked() PASSED

ReadingListReaderNavigatorTest > every unresolved resolution state blocks at its exact entry() PASSED

ReadingListReaderNavigatorTest > missing exact chapter marks only that entry as removed without synthetic substitution() PASSED

ReadingListReviewScreenModelTest > series mapping removal uses the entry normalized series key() PASSED

ReadingListReviewScreenModelTest > presentation preserves cbl order candidate order and orphaned rejections() PASSED

ReadingListReviewScreenModelTest > presentation retains every state and excludes confirmed and skipped entries from attention() PASSED

ReadingListReviewScreenModelTest > stored rejection restoration clears only its exact identity() PASSED

ReadingListReviewScreenModelTest > unknown candidate identity is refused without a repository write() PASSED

ReadingListReviewScreenModelTest > series mapping is a separate explicit operation() PASSED

ReadingListReviewScreenModelTest > candidate rejection uses the exact persisted snapshot() PASSED

ReadingListReviewScreenModelTest > orphaned rejection can be restored without a candidate snapshot() PASSED

ReadingListReviewScreenModelTest > candidate confirmation uses the exact persisted snapshot() PASSED

ReadingListSourceFilterTest > source search narrows a nonmatching extension to matching child sources() PASSED

ReadingListSourceFilterTest > all languages leaves installed variants visible() PASSED

ReadingListSourceFilterTest > extension search keeps all language-filtered variants in a matching group() PASSED

ReadingListSourceFilterTest > unavailable saved sources remain visible through a language filter() PASSED

ReadingListSourceFilterTest > preferred language includes matching and all-language variants() PASSED

ReadingListSourceFilterTest > lists concrete installed languages without the all-language source() PASSED

ReadingListSourceGroupingTest > omits installed extensions without online sources() PASSED

ReadingListSourceGroupingTest > keeps installed extensions with the same display name separate() PASSED

ReadingListSourceGroupingTest > groups multilingual variants under one installed extension() PASSED

ReadingListSourceGroupingTest > deduplicates conflicting source IDs deterministically() PASSED

MigratorTest > withinRangeMigration() PASSED

MigratorTest > largeMigration() PASSED

MigratorTest > sameVersion() PASSED

MigratorTest > smallMigration() PASSED

MigratorTest > noMigrations() PASSED

MigratorTest > initialVersion() PASSED
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784249336868.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 2m 18s
247 actionable tasks: 101 executed, 142 from cache, 4 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

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
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784249475725.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 5s
6 actionable tasks: 2 executed, 4 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## assemblePreview

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
> Task :data:preBuild UP-TO-DATE
> Task :core-metadata:preBuild UP-TO-DATE
> Task :domain:preBuild UP-TO-DATE
> Task :core-metadata:preReleaseBuild UP-TO-DATE
> Task :data:preReleaseBuild UP-TO-DATE
> Task :domain:preReleaseBuild UP-TO-DATE
> Task :app:preBuild UP-TO-DATE
> Task :app:prePreviewBuild UP-TO-DATE
> Task :core-metadata:mergeReleaseJniLibFolders
> Task :data:mergeReleaseJniLibFolders
> Task :app:mergePreviewJniLibFolders
> Task :domain:mergeReleaseJniLibFolders
> Task :domain:mergeReleaseNativeLibs NO-SOURCE
> Task :i18n:androidPreBuild UP-TO-DATE
> Task :i18n:preAndroidMainBuild UP-TO-DATE
> Task :data:mergeReleaseNativeLibs NO-SOURCE
> Task :core-metadata:mergeReleaseNativeLibs NO-SOURCE
> Task :i18n:mergeAndroidMainJniLibFolders
> Task :data:copyReleaseJniLibsProjectOnly
> Task :domain:copyReleaseJniLibsProjectOnly
> Task :presentation-core:preBuild UP-TO-DATE
> Task :presentation-core:preReleaseBuild UP-TO-DATE
> Task :core-metadata:copyReleaseJniLibsProjectOnly
> Task :source-api:androidPreBuild UP-TO-DATE
> Task :source-api:preAndroidMainBuild UP-TO-DATE
> Task :presentation-widget:preBuild UP-TO-DATE
> Task :presentation-widget:preReleaseBuild UP-TO-DATE
> Task :i18n:mergeAndroidMainNativeLibs NO-SOURCE
> Task :i18n:copyAndroidMainJniLibsProjectOnly
> Task :source-api:mergeAndroidMainJniLibFolders
> Task :source-local:androidPreBuild UP-TO-DATE
> Task :source-local:preAndroidMainBuild UP-TO-DATE
> Task :source-api:mergeAndroidMainNativeLibs NO-SOURCE
> Task :presentation-widget:mergeReleaseJniLibFolders
> Task :presentation-core:mergeReleaseJniLibFolders
> Task :presentation-widget:mergeReleaseNativeLibs NO-SOURCE
> Task :presentation-core:mergeReleaseNativeLibs NO-SOURCE
> Task :source-local:mergeAndroidMainJniLibFolders
> Task :source-api:copyAndroidMainJniLibsProjectOnly
> Task :telemetry:preBuild UP-TO-DATE
> Task :telemetry:preReleaseBuild UP-TO-DATE
> Task :source-local:mergeAndroidMainNativeLibs NO-SOURCE
> Task :presentation-core:copyReleaseJniLibsProjectOnly
> Task :core:archive:preBuild UP-TO-DATE
> Task :presentation-widget:copyReleaseJniLibsProjectOnly
> Task :core:common:preBuild UP-TO-DATE
> Task :core:archive:preReleaseBuild UP-TO-DATE
> Task :core:common:preReleaseBuild UP-TO-DATE
> Task :telemetry:mergeReleaseJniLibFolders
> Task :source-local:copyAndroidMainJniLibsProjectOnly
> Task :telemetry:mergeReleaseNativeLibs NO-SOURCE
> Task :core:archive:mergeReleaseJniLibFolders
> Task :core:common:mergeReleaseJniLibFolders
> Task :core:archive:mergeReleaseNativeLibs NO-SOURCE
> Task :core-metadata:prepareReleaseArtProfile
> Task :core:common:mergeReleaseNativeLibs NO-SOURCE
> Task :telemetry:copyReleaseJniLibsProjectOnly
> Task :data:prepareReleaseArtProfile
> Task :core:archive:copyReleaseJniLibsProjectOnly
> Task :core:common:copyReleaseJniLibsProjectOnly
> Task :domain:prepareReleaseArtProfile
> Task :i18n:prepareAndroidMainArtProfile
> Task :presentation-core:prepareReleaseArtProfile
> Task :presentation-widget:prepareReleaseArtProfile
> Task :source-local:prepareAndroidMainArtProfile
> Task :telemetry:prepareReleaseArtProfile
> Task :source-api:prepareAndroidMainArtProfile
> Task :core-metadata:generateReleaseResources UP-TO-DATE
> Task :core:common:prepareReleaseArtProfile
> Task :source-api:kmpPartiallyResolvedDependenciesChecker
> Task :source-api:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :i18n:kmpPartiallyResolvedDependenciesChecker
> Task :core:archive:prepareReleaseArtProfile
> Task :core-metadata:packageReleaseResources UP-TO-DATE
> Task :core:common:generateReleaseResources UP-TO-DATE
> Task :core-metadata:processReleaseNavigationResources UP-TO-DATE
> Task :i18n:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core:common:packageReleaseResources UP-TO-DATE
> Task :i18n:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :core:common:processReleaseNavigationResources UP-TO-DATE
> Task :i18n:generateAndroidMainLocalesConfig UP-TO-DATE
> Task :core-metadata:parseReleaseLocalResources UP-TO-DATE
> Task :i18n:generateMRcommonTest UP-TO-DATE
> Task :core:common:parseReleaseLocalResources UP-TO-DATE
> Task :core:common:javaPreCompileRelease UP-TO-DATE
> Task :i18n:generateMRandroidHostTest UP-TO-DATE
> Task :i18n:generateMRcommonMain UP-TO-DATE
> Task :i18n:generateMRandroidMain UP-TO-DATE
> Task :domain:generateReleaseResources UP-TO-DATE
> Task :domain:packageReleaseResources UP-TO-DATE
> Task :i18n:packageAndroidMainResources UP-TO-DATE
> Task :domain:processReleaseNavigationResources UP-TO-DATE
> Task :i18n:parseAndroidMainLocalResources UP-TO-DATE
> Task :domain:parseReleaseLocalResources UP-TO-DATE
> Task :domain:javaPreCompileRelease UP-TO-DATE
> Task :i18n:generateAndroidMainRFile UP-TO-DATE
> Task :i18n:compileAndroidMain UP-TO-DATE
> Task :i18n:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :source-local:kmpPartiallyResolvedDependenciesChecker
> Task :source-local:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :core-metadata:generateReleaseRFile UP-TO-DATE
> Task :core-metadata:javaPreCompileRelease UP-TO-DATE
> Task :core:archive:generateReleaseResources UP-TO-DATE
> Task :core:archive:packageReleaseResources UP-TO-DATE
> Task :core:common:generateReleaseRFile UP-TO-DATE
> Task :core:archive:processReleaseNavigationResources UP-TO-DATE
> Task :domain:generateReleaseRFile UP-TO-DATE
> Task :core:archive:parseReleaseLocalResources UP-TO-DATE
> Task :core:archive:generateReleaseRFile UP-TO-DATE
> Task :core:common:compileReleaseKotlin UP-TO-DATE
> Task :core:common:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:common:bundleLibCompileToJarRelease UP-TO-DATE
> Task :core:archive:compileReleaseKotlin UP-TO-DATE
> Task :core:archive:javaPreCompileRelease UP-TO-DATE
> Task :core:archive:compileReleaseJavaWithJavac NO-SOURCE
> Task :core:archive:bundleLibCompileToJarRelease UP-TO-DATE
> Task :data:generateReleaseResources FROM-CACHE
> Task :source-api:compileAndroidMain UP-TO-DATE
> Task :source-api:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :data:packageReleaseResources FROM-CACHE
> Task :core-metadata:compileReleaseKotlin UP-TO-DATE
> Task :core-metadata:compileReleaseJavaWithJavac NO-SOURCE
> Task :core-metadata:bundleLibCompileToJarRelease UP-TO-DATE
> Task :core-metadata:mergeReleaseGeneratedProguardFiles
> Task :core-metadata:exportReleaseConsumerProguardFiles
> Task :data:processReleaseNavigationResources FROM-CACHE
> Task :domain:compileReleaseKotlin UP-TO-DATE
> Task :domain:compileReleaseJavaWithJavac NO-SOURCE
> Task :domain:bundleLibCompileToJarRelease UP-TO-DATE
> Task :data:parseReleaseLocalResources FROM-CACHE
> Task :source-local:compileAndroidMain UP-TO-DATE
> Task :data:generateReleaseRFile FROM-CACHE
> Task :source-local:bundleAndroidMainClassesToRuntimeJar UP-TO-DATE
> Task :source-local:processAndroidMainJavaRes UP-TO-DATE
> Task :source-local:createFullJarAndroidMain
> Task :data:javaPreCompileRelease FROM-CACHE
> Task :presentation-core:generateReleaseResources FROM-CACHE
> Task :presentation-core:packageReleaseResources FROM-CACHE
> Task :presentation-core:processReleaseNavigationResources FROM-CACHE
> Task :presentation-core:parseReleaseLocalResources FROM-CACHE
> Task :presentation-core:generateReleaseRFile FROM-CACHE
> Task :app:mergePreviewNativeLibs
> Task :presentation-widget:generateReleaseResources FROM-CACHE
> Task :presentation-widget:packageReleaseResources FROM-CACHE
> Task :presentation-core:compileReleaseKotlin FROM-CACHE
> Task :presentation-core:javaPreCompileRelease FROM-CACHE
> Task :app:mergePreviewArtProfile
> Task :presentation-core:compileReleaseJavaWithJavac NO-SOURCE
> Task :presentation-widget:processReleaseNavigationResources FROM-CACHE
> Task :presentation-core:bundleLibCompileToJarRelease
> Task :presentation-widget:parseReleaseLocalResources FROM-CACHE
> Task :presentation-widget:generateReleaseRFile FROM-CACHE
> Task :app:expandPreviewL8ArtProfileWildcards FROM-CACHE
> Task :presentation-widget:javaPreCompileRelease FROM-CACHE
> Task :domain:mergeReleaseGeneratedProguardFiles
> Task :domain:exportReleaseConsumerProguardFiles
> Task :source-api:mergeAndroidMainGeneratedProguardFiles
> Task :app:stripPreviewDebugSymbols
> Task :source-api:exportAndroidMainConsumerProguardFiles
> Task :presentation-core:mergeReleaseGeneratedProguardFiles
> Task :presentation-core:exportReleaseConsumerProguardFiles
> Task :telemetry:generateReleaseResources FROM-CACHE
> Task :telemetry:packageReleaseResources FROM-CACHE
> Task :telemetry:processReleaseNavigationResources FROM-CACHE
> Task :telemetry:parseReleaseLocalResources FROM-CACHE
> Task :telemetry:generateReleaseRFile FROM-CACHE
> Task :app:extractPreviewNativeSymbolTables FROM-CACHE
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
> Task :core:archive:exportReleaseConsumerProguardFiles
> Task :app:checkPreviewDuplicateClasses
> Task :app:mergePreviewNativeDebugMetadata
> Task :source-api:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :source-local:generateAndroidMainEmptyResourceFiles UP-TO-DATE
> Task :source-local:bundleAndroidMainClassesToCompileJar UP-TO-DATE
> Task :telemetry:bundleLibCompileToJarRelease
> Task :app:compilePreviewAidl FROM-CACHE
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
> Task :app:dataBindingMergeDependencyArtifactsPreview
> Task :core:common:writeReleaseAarMetadata
> Task :core-metadata:extractDeepLinksRelease FROM-CACHE
> Task :app:generatePreviewResources FROM-CACHE
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
> Task :app:prepareLibraryDefinitionsPreview FROM-CACHE
> Task :core:archive:processReleaseManifest FROM-CACHE
> Task :core:common:extractDeepLinksRelease FROM-CACHE
> Task :app:replacePreviewShortcutPlaceholder
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
> Task :presentation-widget:compileReleaseKotlin
> Task :presentation-widget:compileReleaseJavaWithJavac NO-SOURCE
> Task :presentation-widget:mergeReleaseGeneratedProguardFiles
> Task :core:archive:processReleaseJavaRes
> Task :presentation-widget:exportReleaseConsumerProguardFiles
> Task :core:common:processReleaseJavaRes
> Task :presentation-widget:bundleLibCompileToJarRelease
> Task :core-metadata:generateReleaseAssets UP-TO-DATE
> Task :presentation-widget:bundleLibRuntimeToJarRelease
> Task :core-metadata:mergeReleaseAssets
> Task :data:generateReleaseAssets UP-TO-DATE
> Task :presentation-widget:processReleaseJavaRes
> Task :data:mergeReleaseAssets
> Task :i18n:generateAndroidMainAssets UP-TO-DATE
> Task :domain:generateReleaseAssets UP-TO-DATE
> Task :i18n:mergeAndroidMainAssets
> Task :presentation-core:generateReleaseAssets UP-TO-DATE
> Task :domain:mergeReleaseAssets
> Task :presentation-widget:generateReleaseAssets UP-TO-DATE
> Task :presentation-core:mergeReleaseAssets
> Task :telemetry:generateReleaseAssets UP-TO-DATE
> Task :presentation-widget:mergeReleaseAssets
> Task :core:archive:generateReleaseAssets UP-TO-DATE
> Task :telemetry:mergeReleaseAssets
> Task :core:common:generateReleaseAssets UP-TO-DATE
> Task :core:archive:mergeReleaseAssets
> Task :core:common:mergeReleaseAssets
> Task :app:generatePreviewBuildConfig
> Task :app:packagePreviewResources
> Task :app:processPreviewNavigationResources
> Task :app:parsePreviewLocalResources
> Task :app:javaPreCompilePreview FROM-CACHE
> Task :app:generatePreviewRFile
> Task :app:mapPreviewSourceSetPaths
> Task :app:compilePreviewNavigationResources FROM-CACHE
> Task :app:checkPreviewAarMetadata
> Task :app:createPreviewCompatibleScreenManifests
> Task :app:extractDeepLinksPreview FROM-CACHE
> Task :app:processPreviewMainManifest
> Task :app:processPreviewManifest
> Task :app:extractProguardFiles
> Task :app:mergePreviewStartupProfile
> Task :app:processPreviewManifestForPackage
> Task :app:generatePreviewAssets UP-TO-DATE
> Task :data:generateReleaseDatabaseInterface
> Task :app:mergePreviewAssets
> Task :app:compressPreviewAssets FROM-CACHE
> Task :app:extractPreviewVersionControlInfo
> Task :app:validateSigningPreview
> Task :app:writePreviewAppMetadata
> Task :app:writePreviewSigningConfigVersions
> Task :app:mergePreviewResources
> Task :app:dataBindingGenBaseClassesPreview FROM-CACHE
> Task :data:compileReleaseKotlin
> Task :data:compileReleaseJavaWithJavac NO-SOURCE
> Task :data:mergeReleaseGeneratedProguardFiles
> Task :data:exportReleaseConsumerProguardFiles
> Task :data:bundleLibCompileToJarRelease
> Task :data:bundleLibRuntimeToJarRelease
> Task :data:processReleaseJavaRes
> Task :app:processPreviewResources
> Task :app:compilePreviewKotlin
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/download/DownloadManager.kt:224:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/download/DownloadManager.kt:251:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/download/Downloader.kt:115:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/library/LibraryUpdateNotifier.kt:211:13 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/notification/NotificationReceiver.kt:200:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/data/notification/NotificationReceiver.kt:226:9 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/reader/loader/HttpPageLoader.kt:134:13 This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt:100:57 'val Icons.Outlined.List: ImageVector' is deprecated. Use the AutoMirrored version at Icons.AutoMirrored.Outlined.List.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt:350:46 'val Icons.Outlined.List: ImageVector' is deprecated. Use the AutoMirrored version at Icons.AutoMirrored.Outlined.List.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt:413:5 'fun ListItem(headlineContent: ComposableFunction0<Unit>, modifier: Modifier = ..., overlineContent: ComposableFunction0<Unit>? = ..., supportingContent: ComposableFunction0<Unit>? = ..., leadingContent: ComposableFunction0<Unit>? = ..., trailingContent: ComposableFunction0<Unit>? = ..., colors: ListItemColors = ..., tonalElevation: Dp = ..., shadowElevation: Dp = ...): Unit' is deprecated. Use the overload where `headlineContent` is now a trailing `content` lambda.
w: file:///home/runner/work/Yomori/Yomori/app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt:468:54 'val Icons.Outlined.List: ImageVector' is deprecated. Use the AutoMirrored version at Icons.AutoMirrored.Outlined.List.

> Task :app:compilePreviewJavaWithJavac
> Task :app:mergePreviewGeneratedProguardFiles
> Task :app:processPreviewJavaRes
> Task :app:mergePreviewJavaResource
> Task :app:expandPreviewArtProfileWildcards
> Task :app:producePreviewComposeMapping

> Task :app:reportPreviewComposeMappingErrors
warning: Failed to collect Compose stack trace mapping (Failed to tokenize tachiyomi.presentation.widget.BaseUpdatesGridGlanceWidget.provideGlance$suspendImpl(Ltachiyomi/presentation/widget/BaseUpdatesGridGlanceWidget;Landroid/content/Context;Landroidx/glance/GlanceId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;). Please report to Google through https://goo.gle/compose-feedback

> Task :app:minifyPreviewWithR8
WARNING: /home/runner/work/Yomori/Yomori/app/build/intermediates/merged_java_res/preview/mergePreviewJavaResource/base.jar: R8: Unexpected reference to missing service class: META-INF/services/nl.adaptivity.xmlutil.util.SerializationProvider.
WARNING: /home/runner/work/Yomori/Yomori/app/build/intermediates/merged_java_res/preview/mergePreviewJavaResource/base.jar: R8: Unexpected reference to missing service implementation class in META-INF/services/nl.adaptivity.xmlutil.util.SerializationProvider: nl.adaptivity.xmlutil.serialization.KotlinxSerializationProvider.
WARNING: /home/runner/work/Yomori/Yomori/app/build/intermediates/merged_java_res/preview/mergePreviewJavaResource/base.jar: R8: Unexpected reference to missing service implementation class in META-INF/services/nl.adaptivity.xmlutil.util.SerializationProvider: nl.adaptivity.xmlutil.util.DefaultSerializationProvider.
WARNING: R8: Missing class androidx.window.extensions.WindowExtensions (referenced from: int androidx.window.core.ExtensionsUtil.getSafeVendorApiLevel() and 1 other context)
Missing class androidx.window.extensions.WindowExtensionsProvider (referenced from: int androidx.window.core.ExtensionsUtil.getSafeVendorApiLevel() and 1 other context)
Missing class androidx.window.extensions.area.ExtensionWindowAreaPresentation (referenced from: androidx.window.extensions.area.ExtensionWindowAreaPresentation androidx.window.area.reflectionguard.WindowAreaComponentApi3Requirements.getRearDisplayPresentation())
Missing class androidx.window.extensions.core.util.function.Consumer (referenced from: void androidx.window.area.reflectionguard.WindowAreaComponentApi3Requirements.addRearDisplayPresentationStatusListener(androidx.window.extensions.core.util.function.Consumer) and 9 other contexts)
Missing class androidx.window.extensions.core.util.function.Function (referenced from: androidx.window.reflection.JFunction2)
Missing class androidx.window.extensions.core.util.function.Predicate (referenced from: androidx.window.reflection.Predicate2)
Missing class androidx.window.extensions.layout.DisplayFeature (referenced from: androidx.window.layout.WindowLayoutInfo androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter.translate$window_release(androidx.window.layout.WindowMetrics, androidx.window.extensions.layout.WindowLayoutInfo))
Missing class androidx.window.extensions.layout.FoldingFeature (referenced from: androidx.window.layout.FoldingFeature androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter.translate$window_release(androidx.window.layout.WindowMetrics, androidx.window.extensions.layout.FoldingFeature) and 1 other context)
Missing class androidx.window.extensions.layout.WindowLayoutComponent (referenced from: androidx.window.extensions.layout.WindowLayoutComponent androidx.window.layout.adapter.extensions.ExtensionWindowBackendApi1.component and 9 other contexts)
Missing class androidx.window.extensions.layout.WindowLayoutInfo (referenced from: void androidx.window.layout.adapter.extensions.ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1.invoke(androidx.window.extensions.layout.WindowLayoutInfo) and 8 other contexts)
Missing class androidx.window.sidecar.SidecarDeviceState (referenced from: androidx.window.sidecar.SidecarDeviceState androidx.window.layout.adapter.sidecar.DistinctElementSidecarCallback.mLastDeviceState and 12 other contexts)
Missing class androidx.window.sidecar.SidecarDisplayFeature (referenced from: boolean androidx.window.layout.adapter.sidecar.SidecarAdapter.isEqualSidecarDisplayFeature(androidx.window.sidecar.SidecarDisplayFeature, androidx.window.sidecar.SidecarDisplayFeature) and 8 other contexts)
Missing class androidx.window.sidecar.SidecarInterface$SidecarCallback (referenced from: androidx.window.sidecar.SidecarInterface$SidecarCallback androidx.window.layout.adapter.sidecar.DistinctElementSidecarCallback.mCallback and 7 other contexts)
Missing class androidx.window.sidecar.SidecarInterface (referenced from: androidx.window.sidecar.SidecarInterface androidx.window.layout.adapter.sidecar.SidecarCompat.sidecar and 11 other contexts)
Missing class androidx.window.sidecar.SidecarProvider (referenced from: androidx.window.sidecar.SidecarInterface androidx.window.layout.adapter.sidecar.SidecarCompat$Companion.getSidecarCompat$window_release(android.content.Context) and 1 other context)
Missing class androidx.window.sidecar.SidecarWindowLayoutInfo (referenced from: void androidx.window.layout.adapter.sidecar.DistinctElementSidecarCallback.onWindowLayoutChanged(android.os.IBinder, androidx.window.sidecar.SidecarWindowLayoutInfo) and 7 other contexts)

> Task :app:mergePreviewComposeMapping
> Task :app:convertShrunkResourcesToBinaryPreview
> Task :app:optimizePreviewResources
> Task :app:l8DexDesugarLibPreview
> Task :app:compilePreviewArtProfile
> Task :app:packagePreview
> Task :app:createPreviewApkListingFileRedirect
> Task :app:assemblePreview
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784249481535.json

[Incubating] Problems report is available at: file:///home/runner/work/Yomori/Yomori/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 10.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/9.6.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 5m 15s
275 actionable tasks: 148 executed, 60 from cache, 67 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.6.1/userguide/configuration_cache_enabling.html

```

## gitDiffCheck

Exit code: `0`

```text

```

