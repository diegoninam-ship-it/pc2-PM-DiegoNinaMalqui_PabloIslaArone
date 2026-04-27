package com.tecsup.data.repository

import com.tecsup.data.model.Course;

object CourseRepository {

    val courses = listOf(
        Course(1, "Kotlin desde Cero", "Juan Pérez", "Básico", "Programación", "5h", "Aprende Kotlin desde cero", ""),
        Course(2, "UI/UX Design", "Ana Torres", "Intermedio", "Diseño", "8h", "Diseño de interfaces modernas", ""),
        Course(3, "Marketing Digital", "Luis Gómez", "Básico", "Negocios", "6h", "Estrategias digitales", ""),
        Course(4, "Android Avanzado", "Carlos Ruiz", "Avanzado", "Programación", "10h", "Arquitectura Android", ""),
        Course(5, "Photoshop Pro", "María López", "Intermedio", "Diseño", "7h", "Edición profesional", ""),
        Course(6, "Startup Business", "Pedro Díaz", "Avanzado", "Negocios", "9h", "Creación de startups", "")
    )

    fun getCourseById(id: Int) = courses.find { it.id == id }
}