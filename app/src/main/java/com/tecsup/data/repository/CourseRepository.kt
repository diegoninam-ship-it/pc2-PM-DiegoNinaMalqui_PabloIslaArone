package com.tecsup.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.tecsup.data.model.Course

object CourseRepository {

    val courses = listOf(
        Course(1, "Kotlin desde Cero", "Juan Pérez", "Básico", "Programación", "5h", "Aprende Kotlin desde cero", "https://via.placeholder.com/300"),
        Course(2, "UI/UX Design", "Ana Torres", "Intermedio", "Diseño", "8h", "Diseño moderno", "https://via.placeholder.com/300"),
        Course(3, "Marketing Digital", "Luis Gómez", "Básico", "Negocios", "6h", "Marketing online", "https://via.placeholder.com/300"),
        Course(4, "Android Avanzado", "Carlos Ruiz", "Avanzado", "Programación", "10h", "Arquitectura Android", "https://via.placeholder.com/300"),
        Course(5, "Photoshop Pro", "María López", "Intermedio", "Diseño", "7h", "Edición profesional", "https://via.placeholder.com/300"),
        Course(6, "Startup Business", "Pedro Díaz", "Avanzado", "Negocios", "9h", "Startups", "https://via.placeholder.com/300")
    )

    // 🔥 cursos inscritos (estado real en memoria)
    val enrolledCourses = mutableStateListOf<Course>()

    fun getCourseById(id: Int) = courses.find { it.id == id }

    fun enroll(course: Course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course)
        }
    }
}