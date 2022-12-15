import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Calculator {
    fun sum(a: Int, b: Int) = a + b
}

class CalculatorTest {
    @Test
    fun testSum() {
        val calculator: Calculator = Calculator()
        Assertions.assertThat(calculator.sum(5, 3)).isEqualTo(8)
    }
}