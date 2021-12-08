@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.gmvbr.solid

data class TaskItem(
    var id: Int,
    val name: String,
    var description: String
) {
    override fun toString(): String {
        return "ID: $id, NAME: '$name', DESCRIPTION: '$description'"
    }
}

/// Wrong usage of SRP (Single Responsibility Principle)
///
class WrongTaskModel {

    fun listItems(): List<TaskItem> {
        return listOf()
    }

    fun addItem(task: TaskItem) {}

    fun deleteItem(id: Int) {}

    fun saveTask() {}

    fun loadTask() {}

    fun printTask() {}

}

// Correct usage of SRP (Single Responsibility Principle)
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

    fun saveTask(task: Task) {
        // ....
    }

    fun loadTask(task: Task) {
        // ....
    }
}

class TaskPrinter {

    fun printTask(task: Task) {
        task.listItems().forEach {
            println(it.toString())
        }
    }

}