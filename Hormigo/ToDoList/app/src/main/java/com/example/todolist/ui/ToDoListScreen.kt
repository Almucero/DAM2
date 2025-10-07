package com.example.todolist.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todolist.data.ToDo

@Composable
fun ToDoListScreen(modifier: Modifier = Modifier, todos: List<ToDo>) {
    Text("TODO LIST")
}