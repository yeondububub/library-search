plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "library-search"

include("search-api")
include("external:naver-client")
include("common")
findProject(":external:naver-client")?.name = "naver-client"