import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Person(
    val id: String,
    val name: String,
    val dob: String
)

private inline fun <reified T> Gson.fromJson(json: String): T {
    return this.fromJson(json, object : TypeToken<T>() {}.type)
}

private inline fun <reified T> Gson.fromObject(obj: T): String {
    return this.toJson(obj, object : TypeToken<T>() {}.type)
}

fun main() {
    val jsonString = """
        {
            "id": "123",
            "name": "Gary Ma",
            "dob": "1990-01-01"
        }
    """.trimIndent()

    val person = Gson().fromJson<Person>(jsonString)

    println(person) // output: Person(id=id, name=name)

    println(Gson().fromObject(person)) // output: {"id":"id","name":"name"}
}