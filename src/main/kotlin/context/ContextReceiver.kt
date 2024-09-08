package context

//https://blog.rockthejvm.com/kotlin-context-receivers/

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

context(JsonScope<A>, Logger)   //implicitly dependency injection
fun <A> printAsJson(aList: List<A>): String {
    consoleLogger.info("Printing as JSON")
    return aList.joinToString(separator = ", ", prefix = "[", postfix = "]") {
        it.toJson()
    }
}

interface Jobs {
    fun findById(id: JobId): Job?
}

context(Logger)
class LiveJobs : Jobs {
    override fun findById(id: JobId): Job? {
        consoleLogger.info("Searching for job with id $id")
        return JOBS_DATABASE[id]
    }
}

context(JsonScope<Job>, Logger) //non-business logic should be used within context
class JobController(private val jobs: Jobs) {   //business logic should be passed as a dependency
    fun jsonById(id: String): String {
        info("Getting job by id $id to serialize as JSON")
        val jobId = JobId(id.toLong())
        return jobs.findById(jobId)?.let {
            info("Job with Id $id found")
            return it.toJson()
        } ?: "No Job Found"
    }
}

fun main() {
    with(jobJsonScope) {
        with(consoleLogger) {
            println(printAsJson(JOBS_DATABASE.values.toList()))
        }
    }
}