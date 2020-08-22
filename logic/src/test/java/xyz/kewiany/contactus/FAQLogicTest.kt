package xyz.kewiany.contactus

import com.jakewharton.rxrelay3.PublishRelay
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.FAQAction
import xyz.kewiany.contactus.logic.FAQAction.SelectBack
import xyz.kewiany.contactus.logic.FAQLogic
import xyz.kewiany.contactus.logic.FAQViewState


internal class FAQLogicTest : CustomFunSpec({
    val actions = PublishRelay.create<FAQAction>()
    val state = FAQViewState()
    val stateT = FAQViewStateT(state)
    var logic: Job? = null

    fun getItems() = stateT.items.value

    fun run() {
        logic = testScope.launch {
            state.FAQLogic(
                actions,
                testDispatcherProvider
            )
        }
    }

    test("set two items on init") {
        run()
        getItems() shouldBe listOf("one", "two")
        getItems().count() shouldBe 2
    }

    test("finish logic on select back") {
        run()
        actions.accept(SelectBack)
        logic?.isCompleted shouldBe true
    }
})
