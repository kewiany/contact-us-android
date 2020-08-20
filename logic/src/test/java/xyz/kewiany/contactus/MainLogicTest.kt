package xyz.kewiany.contactus

import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.freeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class MainLogicTest : FreeSpec({
    val reusableTest = freeSpec {
        "test2" - {
            "assertion2" {
                MainLogic() shouldNotBe ""
            }
        }
    }
    beforeEach {
        println("before")
    }
    afterEach {
        println("after")
    }
    include(reusableTest)
    "test" - {
        "assertion" {
            MainLogic() shouldBe true
        }
    }
})

