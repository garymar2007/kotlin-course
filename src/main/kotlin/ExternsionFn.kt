import java.util.*
import kotlin.math.E

object EntityFactory2 {
    fun create(type: EntityType1) : EntitySealed1 {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType1.EASY -> type.name
            EntityType1.MEDIUM -> type.getFormattedName()
            EntityType1.HARD -> type.name
            EntityType1.HELP -> type.getFormattedName()
        }
        return when(type) {
            EntityType1.EASY -> EntitySealed1.Easy(id, name)
            EntityType1.MEDIUM -> EntitySealed1.Medium(id, name)
            EntityType1.HARD -> EntitySealed1.Hard(id, name, 2.0f)
            EntityType1.HELP -> EntitySealed1.Help
        }
    }
}


sealed class EntitySealed1 {
    object Help: EntitySealed1() {
        val name = "Help"
    }
    data class Easy(val id: String, val name: String) : EntitySealed1()
    data class Medium(val id: String, val name: String) : EntitySealed1()
    data class Hard(val id: String, val name: String, val multiplier: Float) : EntitySealed1()
}

fun EntitySealed1.Medium.printInfo() {
    println("Medium class: $id")
}

val EntitySealed1.Medium.info: String
    get() = "some info"

fun main() {
    val entity = EntityFactory2.create(EntityType1.MEDIUM)
    if (entity is EntitySealed1.Medium) {
        //extension function
        entity.printInfo()
        //extension property
        println(entity.info)
    }
}

//2:07:01