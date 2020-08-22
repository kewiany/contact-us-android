package xyz.kewiany.contactus

import com.jakewharton.rxrelay3.PublishRelay
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.faq.FAQAction
import xyz.kewiany.contactus.logic.faq.FAQAction.SelectBack
import xyz.kewiany.contactus.logic.faq.FAQLogic
import xyz.kewiany.contactus.logic.faq.FAQViewState


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
