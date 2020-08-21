package xyz.kewiany.contactus

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.MainLogic
import xyz.kewiany.contactus.logic.common.MainViewState

internal class MainLogicTest : CustomFreeSpec({
    val state = MainViewState()
    val stateT = MainStateT(state)

    "test loading" - {
        testScope.launch {
            state.MainLogic(testDispatcherProvider)
        }
        "load" {
            stateT.state.commonViewState.isLoading shouldBe true
        }
        testScope.advanceTimeBy(1000)
        "do not load" {
            stateT.state.commonViewState.isLoading shouldBe false
        }
    }
})

