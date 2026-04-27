package com.tecsup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

import com.tecsup.ui.screens.*

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login.route
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

        composable(NavRoutes.Detail.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("courseId")?.toInt() ?: 0
            DetailScreen(navController, id)
        }

        composable(NavRoutes.Profile.route) {
            ProfileScreen(navController)
        }
    }
}