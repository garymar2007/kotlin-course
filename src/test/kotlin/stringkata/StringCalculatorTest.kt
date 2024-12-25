package stringkata

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.jvm.Throws
import kotlin.test.Test

class StringCalculatorTest {
    private val stringCalculator = StringCalculator()

    @Test
    fun `should return 0 for empty string`() {
        assertEquals(0, stringCalculator.add(""))
    }

    @Test
    fun `should return 1 for string 1`() {
        assertEquals(1, stringCalculator.add("1"))
    }

    @Test
    fun `should return 3 for string 1,2`() {
        assertEquals(3, stringCalculator.add("1,2"))
    }

    @Test
    fun `should return 6 for string 1,2,3`() {
        assertEquals(6, stringCalculator.add("1,2,3"))
    }

    @Test
    fun `should return 6 for string 1n2,3`() {
        assertEquals(6, stringCalculator.add("1\n2,3"))
    }

    @Test
    @Throws(IllegalArgumentException::class)
    fun `should return exception for string 1,2,3n`() {
        assertThrows(IllegalArgumentException::class.java) {
            stringCalculator.add("1,2,3\n")
        }
    }

    @Test
    @Throws(IllegalArgumentException::class)
    fun `should return exception for string 1,-2,3`() {
        assertThrows(IllegalArgumentException::class.java) {
            stringCalculator.add("1,-2,3")
        }
    }

    @Test
    fun `should return 6 for string 1,2,3,1001`() {
        assertEquals(6, stringCalculator.add("1,2,3,1001"))
    }

    @Test
    fun `should return 6 for string different delimeter`() {
        assertEquals(6, stringCalculator.add("//[***]\\n1***2***3"))
    }
}