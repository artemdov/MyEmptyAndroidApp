pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
include(":p0031firstproject")
include(":p180constraintLayoutintro")
include(":p051layoutfiles")
include(":P0091_OnClickButtons")
include(":P0101_Listener")
include(":P0102_ActivityListener")
include(":P0131_MenuSimple")
