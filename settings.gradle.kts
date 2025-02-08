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
include(":P0141_MenuAdv")
include(":P0151_ContextMenu")
include(":P0161_DynamicLayout")
include(":P0171_DynamicLayout2")
include(":P0181_DynamicLayout3")
include(":P0191_SimpleCalculator")
include(":P0201_SimpleAnimation")
include(":p0211twoactivity")
include(":P0231_OneActivityState")
include(":P0261_IntentFilter")
include(":P0271_GetIntentAction")
include(":P0281_IntentExtras")
include(":P0291_SimpleActivityResult")
include(":P0301_ActivityResult")
include(":P0311_SimpleIntents")
include(":P0321_SimpleBrowser")
include(":P0331_SharedPreferences")
include(":P0341_SimpleSQLite")
include(":P0361_SQLiteQuery")
include(":P0371_SQLiteInnerJoin")
include(":P0381_SQLiteTransaction")
include(":P0391_SQLiteOnUpgradeDB")
include(":P0401_LayoutInflaterNew")
include(":P0411_LayoutInflaterList")
include(":recyclerview")
include(":recyclerviewhard")
include(":less7_save_activity_state_with_livedata")
include(":less_8_data_binding")
include(":cicerone_app")
include(":architecture_app")
include(":architecture_app_added_dagger")
include(":coroutines")
