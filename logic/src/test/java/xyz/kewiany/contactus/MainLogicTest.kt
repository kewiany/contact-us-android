package xyz.kewiany.contactus

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runBlockingTest
import xyz.kewiany.contactus.logic.MainLogic

internal class MainLogicTest : CustomFreeSpec({
    var result: Boolean? = null

    "test" - {
        testDispatcher.runBlockingTest {
            result = MainLogic(testDispatcherProvider)
        }

        "assertion" {
            result shouldBe true
        }
    }
})