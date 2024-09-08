package context

data class Job(val id: JobId, val company: Company, val role: Role, val salary: Salary)
@JvmInline
value class JobId(val value: Long)
@JvmInline
value class Company(val name: String)
@JvmInline
value class Role(val name: String)
@JvmInline
value class Salary(val amount: Double)

val JOBS_DATABASE: Map<JobId, Job> = mapOf(
    JobId(1) to Job(
        JobId(1),
        Company("Google"),
        Role("Software Engineer"),
        Salary(100_000.0)
    ),
    JobId(2) to Job(
        JobId(2),
        Company("Facebook"),
        Role("Product Manager"),
        Salary(120_000.0)
    ),
    JobId(3) to Job(
        JobId(3),
        Company("Amazon"),
        Role("Data Scientist"),
        Salary(110_000.0)
    ),
    JobId(4) to Job(
        JobId(4),
        Company("Apple"),
        Role("Software Engineer"),
        Salary(105_000.0)
    ),
    JobId(5) to Job(
        JobId(5),
        Company("Microsoft"),
        Role("Product Manager"),
        Salary(125_000.0)
    )
)

val jobJsonScope = object : JsonScope<Job> {
    override fun Job.toJson(): String =
        //receiver
        """
        {
            "id": ${id.value},
            "company": "${company.name}",
            "role": "${role.name}",
            "salary": ${salary.amount}
        }
    """.trimIndent()
}

interface Logger {
    fun info(message: String)
}

val consoleLogger = object : Logger {
    override fun info(message: String) {
        println("[INFO] ${message}")
    }
}

//Scope
interface JsonScope<A> {    // dispatcher receiver
    fun A.toJson(): String
    // receiver
}

context(JsonScope<A>, Logger)
fun <A> printAsJson(aList: List<A>): String {
    consoleLogger.info("Printing as JSON")
    return aList.joinToString(separator = ", ", prefix = "[", postfix = "]") {
        it.toJson()
    }
}

fun main() {
    with(jobJsonScope) {
        with(consoleLogger) {
            println(printAsJson(JOBS_DATABASE.values.toList()))
        }
    }
}