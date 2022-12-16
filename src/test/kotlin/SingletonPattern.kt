import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/*
NetworkDriverClass used for Creating class instance to show that each object is created at different memory address
NetworkDriverSingleton used for Creating singleton to show that all instances are same directing to same memory address
 */
class NetworkDriverClass {

    init {
        println("Initializing NetworkDriverClass object: $this")
    }

    fun log(): NetworkDriverClass = apply { println("NetworkDriverClass instance: $this") }
}

object NetworkDriverSingleton {

    init {
        println("Initializing NetworkDriverSingleton object $this")
    }

    fun log(): NetworkDriverSingleton = apply { println("NetworkDriverSingleton: $this") }
}

class SingletonTest() {

    @Test
    fun testSingleton() {
        val networkDriverClass1NotSingleton = NetworkDriverClass().log() // Init block called, new NetworkDriverObject
        val networkDriverClass2NotSingleton = NetworkDriverClass().log() // Init block called, new NetworkDriverObject

        val usingSingleton1 = NetworkDriverSingleton.log() // Init block only once, NetworkDriverSingleton
        val usingSingleton2 = NetworkDriverSingleton.log() // Init block called, same NetworkDriverSingleton used


//        Assertions.assertThat(networkDriverClass1NotSingleton).isNotSameAs(NetworkDriverClass()) // Passed -- using isSameAs() will be failed here
//        Assertions.assertThat(networkDriverClass2NotSingleton).isNotSameAs(NetworkDriverClass()) // Passed -- using isSameAs() will be failed here

        Assertions.assertThat(usingSingleton1).isSameAs(NetworkDriverSingleton) // Passed
        Assertions.assertThat(usingSingleton2).isSameAs(NetworkDriverSingleton) // Passed

//        Assertions.assertThat(networkDriverClass1Singleton).isNotSameAs(NetworkDriverSingleton) // Will be failed
//        Assertions.assertThat(networkDriverClass2Singleton).isNotSameAs(NetworkDriverSingleton) // Will be failed
    }
}