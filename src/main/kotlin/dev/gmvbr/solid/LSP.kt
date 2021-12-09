@file:Suppress("unused")

package dev.gmvbr.solid


/// Correto
/// FileStorage pode ser substituído por Storage
/// porque ela mantem os mesmos métodos da superclasse.

open class Storage {

    open fun save(name: String) {
        println("Storage.save($name)")
    }
}

class FileStorage : Storage() {

    override fun save(name: String) {
        println("FileStorage.save($name)")
    }
}

class Config {

    fun save(storage: Storage, name: String) {
        storage.save(name)
    }

}

// Errado
// Bot não pode ser substituído por Entity, já que a entity
// não pode chamar calculatePosition

open class Entity {

    open fun move(x: Int, y: Int) {
        println("move x:$x y:$y")
    }

}

class Bot : Entity() {

    override fun move(x: Int, y: Int) {
        println("[Bot] move x:$x y:$y")
    }

    fun calculatePosition(x: Int, y: Int) {
        move(x * 2, y * 2)
    }
}

