package xyz.kewiany.contactus

import com.jakewharton.rxrelay3.PublishRelay
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryAction
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryAction.SelectBack
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryLogic
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryViewState

internal class CreateTicketEntryLogicTest : CustomFunSpec({
    val actions = PublishRelay.create<CreateTicketEntryAction>()
    val state = CreateTicketEntryViewState()
    val stateT = CreateTicketEntryStateT(state)
    var logic: Job? = null

    fun run() {
        logic = testScope.launch {
            state.CreateTicketEntryLogic(
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
