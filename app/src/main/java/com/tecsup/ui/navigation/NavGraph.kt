package com.tecsup.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

import com.tecsup.ui.screens.*

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login.route,
        modifier = modifier,
        // Animaciones globales por defecto
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 1000 },
                animationSpec = tween(400)
            ) + fadeIn(animationSpec = tween(400))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(400)
            ) + fadeOut(animationSpec = tween(400))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -1000 },
                animationSpec = tween(400)
            ) + fadeIn(animationSpec = tween(400))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 1000 },
                animationSpec = tween(400)
            ) + fadeOut(animationSpec = tween(400))
        }
    ) {

        composable(NavRoutes.Login.route) {
            LoginScreen(navController)
        }

        composable(NavRoutes.Home.route) {
            HomeScreen(navController)
        }

        composable(NavRoutes.Courses.route) {
            CoursesScreen(navController)
        }

        composable(
            route = NavRoutes.Detail.route,
            arguments = listOf(
                navArgument("courseId") {
                    type = NavType.IntType
                }
            ),
            // Animación específica para el detalle (Efecto de escala)
            enterTransition = {
                scaleIn(initialScale = 0.8f) + fadeIn(animationSpec = tween(400))
            },
            exitTransition = {
                scaleOut(targetScale = 0.8f) + fadeOut(animationSpec = tween(400))
            }
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("courseId") ?: return@composable
            DetailScreen(navController, id)
        }

        composable(NavRoutes.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
