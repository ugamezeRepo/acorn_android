pluginManagement {
    repositories {
        google()
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

rootProject.name = "Hello"
include(":app")
include(":step01hello")
include(":HelloKotlin")
include(":step02activity")
include(":step02activity2")
include(":step02activity3")
include(":step03layout")
include(":step04view")
include(":step04example")
include(":step05listview")
include(":step06customlistview")
include(":step07fragment")
include(":step07fragment2")
include(":step08httprequest")
include(":step08httprequest2")
include(":step08example")
include(":step08galleryexample")
include(":step09viewmodel")
include(":step10bottomnavi")
include(":step11sharedpref")
