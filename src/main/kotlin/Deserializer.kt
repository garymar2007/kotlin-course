import com.google.gson.Gson

data class Person(
    val id: String,
    val name: String
)

fun main() {
    val jsonString = """
        {
            "id": "id",
            "name": "name"
        }
    """.trimIndent()

    val person = Gson().fromJson(jsonString, Person::class.java)

    println(person) // output: Person(id=id, name=name)
}