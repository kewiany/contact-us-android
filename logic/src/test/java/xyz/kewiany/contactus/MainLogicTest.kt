package xyz.kewiany.contactus

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class MainLogicTest : FreeSpec({
    beforeEach {
        println("before")
    }
    afterEach {
        println("after")
    }
    "test" - {
        "assertion" {
            MainLogic() shouldBe true
        }
    }
})
