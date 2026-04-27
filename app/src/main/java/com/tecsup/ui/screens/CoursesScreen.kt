package com.tecsup.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.data.repository.CourseRepository
import com.tecsup.ui.navigation.NavRoutes
import androidx.compose.material.icons.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(navController: NavController) {

    val courses = CourseRepository.courses

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cursos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(courses) { course ->

                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .clickable {
                            navController.navigate(
                                NavRoutes.Detail.createRoute(course.id)
                            )
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(course.title, style = MaterialTheme.typography.titleMedium)
                        Text(course.instructor)
                        Text(course.level)
                    }
                }
            }
        }
    }
}