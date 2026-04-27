package com.tecsup.ui.navigation

sealed class NavRoutes(val route: String) {
    object Login : NavRoutes("login")
    object Home : NavRoutes("home")
    object Courses : NavRoutes("courses")
    object Detail : NavRoutes("detail/{courseId}") {
        fun createRoute(id: Int) = "detail/$id"
    }
    object Profile : NavRoutes("profile")
}