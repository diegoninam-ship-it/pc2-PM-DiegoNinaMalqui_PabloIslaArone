package com.tecsup.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.ArrowBack
import com.tecsup.data.repository.CourseRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {

    val courses = CourseRepository.enrolledCourses

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text("Diego", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Mis cursos inscritos")

            if (courses.isEmpty()) {
                Text("Aún no te has inscrito en cursos")
            } else {
                courses.forEach {
                    Text("• ${it.title}")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Progreso general")
            LinearProgressIndicator(progress = 0.6f)
            Text("60% completado")
        }
    }
}