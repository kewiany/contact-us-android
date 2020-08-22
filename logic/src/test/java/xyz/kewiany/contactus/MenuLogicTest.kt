package xyz.kewiany.contactus

import com.jakewharton.rxrelay3.PublishRelay
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.menu.MenuAction
import xyz.kewiany.contactus.logic.menu.MenuAction.*
import xyz.kewiany.contactus.logic.menu.MenuLogic
import xyz.kewiany.contactus.logic.menu.MenuViewState

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

    test("do not finish logic on select create ticket") {
        run()
        actions.accept(SelectCreateTicket)
        logic?.isCompleted shouldBe false
    }

    test("do not finish logic on select faq") {
        run()
        actions.accept(SelectFAQ)
        logic?.isCompleted shouldBe false
    }
})
