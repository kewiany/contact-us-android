package xyz.kewiany.contactus

import com.jakewharton.rxrelay3.PublishRelay
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.MenuAction
import xyz.kewiany.contactus.logic.MenuAction.SelectBack
import xyz.kewiany.contactus.logic.MenuLogic
import xyz.kewiany.contactus.logic.MenuViewState

internal class MenuLogicTest : CustomFunSpec({
    val actions = PublishRelay.create<MenuAction>()
    val state = MenuViewState()
    val stateT = MenuViewStateT(state)
    var logic: Job? = null

    fun run() {
        logic = testScope.launch {
            state.MenuLogic(
                actions,
                testDispatcherProvider
            )
        }
    }

    test("finish logic on select back") {
        run()
        actions.accept(SelectBack)
        logic?.isCompleted shouldBe true
    }
})
