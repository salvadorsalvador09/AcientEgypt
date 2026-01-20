package com.example.tutorials.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kmobile.ancientegypt.ui.screen.ArtifactDetailScreen
import com.kmobile.ancientegypt.ui.screen.CategoryScreen
import com.kmobile.ancientegypt.ui.screen.GalleryScreen
import com.kmobile.ancientegypt.ui.screen.HomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onOpenCategory = { categoryId ->
                    navController.navigate(Screen.Category.createRoute(categoryId))
                },
                onOpenGallery = { categoryIdOrNull ->
                    navController.navigate(Screen.Gallery.createRoute(categoryIdOrNull))
                }
            )
        }

        composable(
            route = Screen.Category.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId").orEmpty()

            CategoryScreen(
                categoryId = categoryId,
                onOpenArtifact = { objectId ->
                    navController.navigate(Screen.ArtifactDetail.createRoute(objectId))
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.ArtifactDetail.route,
            arguments = listOf(navArgument("objectId") { type = NavType.IntType })
        ) { backStackEntry ->
            val objectId = backStackEntry.arguments?.getInt("objectId") ?: 0

            ArtifactDetailScreen(
                objectId = objectId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.Gallery.route,
            arguments = listOf(
                navArgument("categoryId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            GalleryScreen(
                categoryId = categoryId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
