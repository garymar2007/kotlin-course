import java.util.UUID

enum class EntityType {
    EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType) : Entity1 {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> type.name
        }
        return Entity1(id, name)
    }
}

class Entity1(val id: String, val name: String) {
    override fun toString(): String {
        return "id:$id name:$name"
    }
}

fun main() {
    val entity = EntityFactory.create(EntityType.HARD)
    println(entity) // output: id:id name:name
}