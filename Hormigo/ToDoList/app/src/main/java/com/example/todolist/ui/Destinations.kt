package com.example.todolist.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations(val route: String) {
    @Serializable
    object List: Destinations("todo_list")
    @Serializable
    object Create: Destinations("todo_create")
    @Serializable
    data class Detail(val id: Long): Destinations("todo_detail/$id")
}
