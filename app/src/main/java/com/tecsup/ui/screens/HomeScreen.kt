package com.tecsup.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.ui.navigation.NavRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("EduTech") })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text("Bienvenido 👋", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedCard(onClick = {
                navController.navigate(NavRoutes.Courses.route)
            }) {
                Text("📚 Explorar Cursos", modifier = Modifier.padding(16.dp))
            }

            Spacer(modifier = Modifier.height(12.dp))

            ElevatedCard(onClick = {
                navController.navigate(NavRoutes.Profile.route)
            }) {
                Text("👤 Mi Perfil", modifier = Modifier.padding(16.dp))
            }
        }
    }
}