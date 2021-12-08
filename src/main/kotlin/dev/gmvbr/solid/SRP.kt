@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.gmvbr.solid

data class TaskItem(var id: Int, val name: String, var description: String) {
    override fun toString(): String {
        return "Id: $id, Name: '$name', Description: '$description'"
    }
}

// Errado
// TaskModel tem multiplas responsabilidade.

class TaskModel {
    fun listItems(): List<TaskItem> = listOf()
    fun addItem(task: TaskItem) {}
    fun deleteItem(id: Int) {}

    fun saveTask() {}
    fun loadTask() {}

    fun printTask() {}
}

// Correto
// Cada classe abaixo tem sua responsabilidade

class Task {
    private val tasks = mutableListOf<TaskItem>()

    fun listItems(): List<TaskItem> = tasks

    fun addItem(taskItem: TaskItem) {
        val taskResult = tasks.find { it.id == taskItem.id }
        if (taskResult != null) {
            throw Exception("Item.id exists on task")
        }
        tasks.add(taskItem)
    }

    fun deleteItem(id: Int) {
        tasks.removeIf { it.id == id }
    }
}

class TaskRepository {
    fun saveTask(task: Task) {}
    fun loadTask(task: Task) {}
}

class TaskPrinter {
    fun printTask(task: Task) {
        task.listItems().forEach {
            println(it.toString())
        }
    }
}