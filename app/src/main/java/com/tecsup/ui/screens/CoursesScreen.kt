package com.tecsup.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.data.repository.CourseRepository
import com.tecsup.ui.navigation.NavRoutes
import androidx.compose.material.icons.filled.ArrowBack
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(navController: NavController) {

    var category by remember { mutableStateOf("Todos") }
    val courses = CourseRepository.courses

    val filtered = courses.filter {
        category == "Todos" || it.category == category
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cursos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {

            // 🔥 FILTROS
            Row(modifier = Modifier.padding(8.dp)) {
                listOf("Todos", "Programación", "Diseño", "Negocios").forEach {
                    FilterChip(
                        selected = category == it,
                        onClick = { category = it },
                        label = { Text(it) }
                    )
                }
            }

            LazyColumn {
                items(filtered) { course ->

                    ElevatedCard(
                        modifier = Modifier
                            .padding(12.dp)
                            .clickable {
                                navController.navigate("detail/${course.id}")
                            }
                    ) {

                        Column {
                            AsyncImage(
                                model = course.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                            )

                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(course.title)
                                Text(course.instructor)
                                Text(course.level)
                            }
                        }
                    }
                }
            }
        }
    }
}