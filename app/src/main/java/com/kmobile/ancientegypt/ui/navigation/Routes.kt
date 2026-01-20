package com.example.tutorials.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Category : Screen("category/{categoryId}") {
        fun createRoute(categoryId: String) = "category/$categoryId"
    }
    data object ArtifactDetail : Screen("artifact/{objectId}") {
        fun createRoute(objectId: Int) = "artifact/$objectId"
    }
    data object Gallery : Screen("gallery?categoryId={categoryId}") {
        fun createRoute(categoryId: String? = null) =
            if (categoryId == null) "gallery" else "gallery?categoryId=$categoryId"
    }
}