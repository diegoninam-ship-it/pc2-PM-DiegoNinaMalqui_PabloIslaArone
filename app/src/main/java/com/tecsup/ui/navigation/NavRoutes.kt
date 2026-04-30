package com.tecsup.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavRoutes(val route: String, val title: String = "", val icon: ImageVector? = null) {
    object Login : NavRoutes("login")
    object Home : NavRoutes("home", "Inicio", Icons.Default.Home)
    object Courses : NavRoutes("courses", "Cursos", Icons.Default.School)
    object Profile : NavRoutes("profile", "Perfil", Icons.Default.Person)
    object Detail : NavRoutes("detail/{courseId}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}
