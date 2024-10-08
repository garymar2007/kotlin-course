import java.util.*
import kotlin.math.E

enum class EntityType1 {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase(Locale.getDefault())
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

object EntityFactory1 {
    fun create(type: EntityType1) : EntitySealed {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType1.EASY -> type.name
            EntityType1.MEDIUM -> type.getFormattedName()
            EntityType1.HARD -> type.name
            EntityType1.HELP -> type.getFormattedName()
        }
        return when(type) {
            EntityType1.EASY -> EntitySealed.Easy(id, name)
            EntityType1.MEDIUM -> EntitySealed.Medium(id, name)
            EntityType1.HARD -> EntitySealed.Hard(id, name, 2.0f)
            EntityType1.HELP -> EntitySealed.Help
        }
    }
}

sealed class EntitySealed {
    object Help: EntitySealed() {
        val name = "Help"
    }
    data class Easy(val id: String, val name: String) : EntitySealed()
    data class Medium(val id: String, val name: String) : EntitySealed()
    data class Hard(val id: String, val name: String, val multiplier: Float) : EntitySealed()
}

fun main() {
    val entity = EntityFactory1.create(EntityType1.MEDIUM)
    println(entity) // output: Medium(id=d7576c17-233b-456e-bd63-655851b9c1d0, name=Medium)
    val msg = when(entity) {
        EntitySealed.Help -> "Help class"
        is EntitySealed.Easy -> "Easy class"
        is EntitySealed.Medium -> "Medium class"
        is EntitySealed.Hard -> "Hard class"
    }

    println(msg)

    val entity1 = EntityFactory1.create(EntityType1.EASY)
    val entity2 = EntityFactory1.create(EntityType1.EASY)

    if (entity1 == entity2) {
        println("They are the same")
    } else {
        println("They are different")   // output: They are different
    }

    val entity3 = EntitySealed.Easy("id", "name")
    val entity4 = EntitySealed.Easy("id", "name")
    val entity5 = entity3.copy()

    if (entity3 == entity4) {
        println("They are the same")    // output: They are the same
    } else {
        println("They are different")
    }

    if (entity3 == entity5) {
        println("They are the same")    // output: They are the same
    } else {
        println("They are different")
    }

    if (entity3 === entity5) {
        println("They are the same")
    } else {
        println("They are different")   // output: They are different
    }
}

//2:07:01