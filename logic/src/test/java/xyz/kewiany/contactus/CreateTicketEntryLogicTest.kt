package xyz.kewiany.contactus

import com.jakewharton.rxrelay3.PublishRelay
import io.kotest.assertions.asClue
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.InputError
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryAction
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryAction.*
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryLogic
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryViewState

internal class CreateTicketEntryLogicTest : CustomFunSpec({
    val actions = PublishRelay.create<CreateTicketEntryAction>()
    val state = CreateTicketEntryViewState()
    val stateT = CreateTicketEntryStateT(state)
    var logic: Job? = null

    val email = "email@email.com"
    val name = "name"
    val countryPosition = 1
    val topicPosition = 1

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

    test("set input error none on each on init") {
        run()
        state.asClue {
            state.emailError.value shouldBe InputError.NONE
            state.nameError.value shouldBe InputError.NONE
            state.countryError.value shouldBe InputError.NONE
            state.topicError.value shouldBe InputError.NONE
        }
    }

    test("set input error none on change email") {
        run()
        actions.accept(ChangeEmail(email))
        state.emailError.value shouldBe InputError.NONE
    }

    test("set input error none on change name") {
        run()
        actions.accept(ChangeName(name))
        state.nameError.value shouldBe InputError.NONE
    }

    test("set input error none on select country") {
        run()
        actions.accept(SelectCountry(countryPosition))
        state.countryError.value shouldBe InputError.NONE
    }

    test("set input error none on select topic") {
        run()
        actions.accept(SelectTopic(topicPosition))
        state.topicError.value shouldBe InputError.NONE
    }
})
