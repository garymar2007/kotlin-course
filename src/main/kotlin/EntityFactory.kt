interface IdProvider {
    fun getId(): String
}

class Entity private constructor(val id: String) {
    companion object Factory : IdProvider {
        const val id = "id"
        fun create() = Entity(getId())

        override fun getId(): String {
            return "123"
        }
    }
}

fun main() {
    val entity = Entity.Factory.create()
    println(Entity.id)  // output: id
    println(entity.id)  // output: 123
}