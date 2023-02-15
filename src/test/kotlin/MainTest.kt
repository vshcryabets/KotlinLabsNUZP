import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

internal class MainTest {
    @Test
    fun testGithubUser() {
        assertNotEquals(seed(), "user", "Впишіть ім'я СВОГО GitHub користувача.")
        assertTrue(seed().isNotEmpty(), "Не вказано ім'я GitHub користувача")
    }

    @Test
    fun globalTest() {
        when (labNumber()) {
            1 -> {
                val buffer = StringBuilder()
                interceptPrintln(buffer)
                main(emptyArray())
                assertEquals("Щось не так з третім кошеням", 5, buffer.lines().size)
                val lastLine = buffer.lines()[3]
                assertTrue(
                    lastLine.contains("рудий", true) &&
                            lastLine.contains("\uD83D\uDC06") &&
                            lastLine.contains("кошеня №3", ignoreCase = true) &&
                            lastLine.contains("віком 6 років", ignoreCase = true) &&
                            lastLine.contains("вагою 8 ", ignoreCase = true),
                    "Щось не так з третім кошеням"
                )
            }
            else -> assertTrue(false, "Некоректний номер лаболаторної роботи")
        }
    }

}