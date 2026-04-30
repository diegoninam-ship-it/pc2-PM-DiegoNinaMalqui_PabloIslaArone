package com.tecsup.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.data.repository.CourseRepository
import androidx.compose.material.icons.filled.ArrowBack
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, courseId: Int) {

    val course = CourseRepository.getCourseById(courseId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        }
    ) { padding ->

        course?.let {

            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {

                AsyncImage(
                    model = it.image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(it.title, style = MaterialTheme.typography.headlineSmall)
                Text(it.description)
                Text("Duración: ${it.duration}")

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    CourseRepository.enroll(it)
                }) {
                    Text("Inscribirse")
                }
            }
        }
    }
}