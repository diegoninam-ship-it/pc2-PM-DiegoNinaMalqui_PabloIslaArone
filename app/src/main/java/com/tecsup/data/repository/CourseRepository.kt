package com.tecsup.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.tecsup.data.model.Course

object CourseRepository {

    val courses = listOf(
        Course(
            id = 1,
            title = "Kotlin desde Cero",
            instructor = "Juan Pérez",
            level = "Básico",
            category = "Programación",
            duration = "5h",
            description = "Aprende Kotlin desde cero con las mejores prácticas de programación moderna.",
            image = "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?q=80&w=500&auto=format&fit=crop",
            isNew = true
        ),
        Course(
            id = 2,
            title = "UI/UX Design",
            instructor = "Ana Torres",
            level = "Intermedio",
            category = "Diseño",
            duration = "8h",
            description = "Domina las herramientas de diseño y crea interfaces de usuario impactantes y funcionales.",
            image = "https://images.unsplash.com/photo-1558655146-d09347e92766?q=80&w=500&auto=format&fit=crop",
            isPopular = true
        ),
        Course(
            id = 3,
            title = "Marketing Digital",
            instructor = "Luis Gómez",
            level = "Básico",
            category = "Negocios",
            duration = "6h",
            description = "Estrategias de marketing online efectivas para hacer crecer cualquier negocio.",
            image = "https://images.unsplash.com/photo-1460925895917-afdab827c52f?q=80&w=500&auto=format&fit=crop"
        ),
        Course(
            id = 4,
            title = "Android Avanzado",
            instructor = "Carlos Ruiz",
            level = "Avanzado",
            category = "Programación",
            duration = "10h",
            description = "Lleva tus habilidades de Android al siguiente nivel con arquitecturas modernas.",
            image = "https://images.unsplash.com/photo-1607252650355-f7fd0460ccdb?q=80&w=500&auto=format&fit=crop",
            isNew = true,
            isPopular = true
        ),
        Course(
            id = 5,
            title = "Photoshop Pro",
            instructor = "María López",
            level = "Intermedio",
            category = "Diseño",
            duration = "7h",
            description = "Edición fotográfica y retoque profesional con Adobe Photoshop.",
            image = "https://images.unsplash.com/photo-1626785774573-4b799315345d?q=80&w=500&auto=format&fit=crop"
        ),
        Course(
            id = 6,
            title = "Startup Business",
            instructor = "Pedro Díaz",
            level = "Avanzado",
            category = "Negocios",
            duration = "9h",
            description = "Todo lo que necesitas saber para lanzar y escalar tu propia empresa tecnológica.",
            image = "https://images.unsplash.com/photo-1519389950473-47ba0277781c?q=80&w=500&auto=format&fit=crop",
            isPopular = true
        )
    )

    val enrolledCourses = mutableStateListOf<Course>()

    fun getCourseById(id: Int) = courses.find { it.id == id }

    fun enroll(course: Course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course)
        }
    }
}
