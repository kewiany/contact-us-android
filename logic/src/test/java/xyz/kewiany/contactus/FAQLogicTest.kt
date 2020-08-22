package xyz.kewiany.contactus

import com.jakewharton.rxrelay3.PublishRelay
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.FAQAction
import xyz.kewiany.contactus.logic.FAQLogic
import xyz.kewiany.contactus.logic.FAQViewState


internal class FAQLogicTest : CustomFunSpec({
    val actions = PublishRelay.create<FAQAction>()
    val state = FAQViewState()
    val stateT = FAQViewStateT(state)
    var logic: Job? = null

    fun run() {
        logic = testScope.launch {
            state.FAQLogic(
                actions,
                testDispatcherProvider
            )
        }
    }

    test("finish logic on select back") {
        run()
        actions.accept(FAQAction.SelectBack)
        logic?.isCompleted shouldBe true
    }
})
