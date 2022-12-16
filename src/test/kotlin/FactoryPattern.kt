import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/*
Let's say we have a functionality where we are going to implement Countries, some of them have their "customProperties"
*/
sealed class Country {
    object Canada : Country()
    object Spain : Country()
    class Usa(val customProperty: String) : Country()
    data class Greece(val customProperty: String) : Country()
}

class Pakistan : Country()

/*
Now all the above countries needs to have their own currencies which looks like this
*/

class Currency(val currencyCode: String)

/*
 Factory pattern for Currency will help all the countries to get their respective currencies, country will be passed to
 factory, and it will return the currency for respective country
*/

object CurrencyFactory {
    fun currencyProvider(country: Country): Currency =
        when (country) {
            Country.Canada -> Currency("CAD")
            is Pakistan -> Currency("PKR")
            is Country.Greece -> Currency("EUR")
            Country.Spain -> Currency("EUR")
            is Country.Usa -> Currency("USD")
        }
}

/*
Unit test case for currencyProvider method
*/

class FactoryMethodTest {
    @Test
    fun currencyFactoryDesignTest() {
        val canadianCurrency = CurrencyFactory.currencyProvider(Country.Canada).currencyCode
        println("Canadian Currency: $canadianCurrency")
        val usaCurrency = CurrencyFactory.currencyProvider(Country.Usa("customProperty")).currencyCode
        println("USA Currency: $usaCurrency")
        val pakistanCurrency = CurrencyFactory.currencyProvider(Pakistan()).currencyCode
        println("Pakistan Currency: $pakistanCurrency")

        Assertions.assertThat(canadianCurrency).isEqualTo("CAD")
        Assertions.assertThat(usaCurrency).isEqualTo("USD")
        Assertions.assertThat(pakistanCurrency).isEqualTo("PKR")

    }
}
