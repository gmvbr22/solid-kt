package dev.gmvbr.solid

fun main() {
    principleSRP()
    principleOCP()
}

fun principleSRP() {
    val task = Task()
    try {
        task.addItem(TaskItem(0, "SRP", "Single Responsibility Principle"))
        task.addItem(TaskItem(1, "OCP", "Open-Closed Principle"))
        task.addItem(TaskItem(2, "LSP", "Liskov Substitution Principle"))
        task.addItem(TaskItem(3, "ISP", "Interface Segregation Principle"))
        task.addItem(TaskItem(4, "DIP", "Dependency Inversion Principle"))
    } catch (e: Exception) {
        print(e)
    }

    val taskRepository = TaskRepository()
    taskRepository.saveTask(task)

    val taskPrinter = TaskPrinter()
    taskPrinter.printTask(task)
}

fun principleOCP(){

    val client = Client()
    client.show(DesktopView())
    client.show(WebView())

    val device = Device()
    device.show(WebClient())
    device.show(DesktopClient())
}