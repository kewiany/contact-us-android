package xyz.kewiany.contactus

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import xyz.kewiany.contactus.logic.MainLogic
import xyz.kewiany.contactus.logic.common.MainViewState

internal class MainLogicTest : CustomFreeSpec({
    val state = MainViewState()
    val stateT = MainStateT(state)

    beforeTest {
        testDispatcher.runBlockingTest {
            state.MainLogic(testDispatcherProvider)
        }
    }

    "test" - {
        stateT.state.commonViewState.isLoading shouldBe false
    }
})