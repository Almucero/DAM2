package com.example.todolist.data

data class ToDo(
    val id: Long,
    val title: String,
    val description: String,
    val state: Boolean = false)

val todos: MutableList<ToDo> = mutableListOf(

)