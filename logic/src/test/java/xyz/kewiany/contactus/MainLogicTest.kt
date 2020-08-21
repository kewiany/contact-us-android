package xyz.kewiany.contactus

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.MainLogic
import xyz.kewiany.contactus.logic.common.MainViewState

internal class MainLogicTest : CustomFunSpec({
    val state = MainViewState()
    val stateT = MainStateT(state)

    fun run() {
        testScope.launch {
            state.MainLogic(testDispatcherProvider)
        }
    }

    test("set loading to true") {
        run()
        stateT.state.commonViewState.isLoading shouldBe true
    }

    test("set loading to false after 1000 milliseconds") {
        run()
        testScope.advanceTimeBy(1000)
        stateT.state.commonViewState.isLoading shouldBe false
    }
})

