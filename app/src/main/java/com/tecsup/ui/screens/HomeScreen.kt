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
        topBar = { TopAppBar(title = { Text("EduTech") }) }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text("Hola, Diego 👋", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedCard(onClick = { navController.navigate("courses") }) {
                Text("📚 Cursos", modifier = Modifier.padding(16.dp))
            }

            ElevatedCard(onClick = { navController.navigate("profile") }) {
                Text("🎯 Mis Cursos", modifier = Modifier.padding(16.dp))
            }

            ElevatedCard(onClick = { navController.navigate("profile") }) {
                Text("👤 Perfil", modifier = Modifier.padding(16.dp))
            }
        }
    }
}