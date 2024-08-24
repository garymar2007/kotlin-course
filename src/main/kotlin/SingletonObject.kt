object EntityFactory {
    fun create() = Entity1("id", "name")
}

class Entity1(val id: String, val name: String) {
    override fun toString(): String {
        return "id:$id name:$name"
    }
}

fun main() {
    val entity = EntityFactory.create()
    println(entity) // output: id:id name:name
}