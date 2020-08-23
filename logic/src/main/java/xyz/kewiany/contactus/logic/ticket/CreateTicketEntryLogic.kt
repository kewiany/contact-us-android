package xyz.kewiany.contactus.logic.ticket

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.rx3.awaitFirst
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.core.createState
import xyz.kewiany.contactus.logic.InputError
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.ViewState
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryAction.*

sealed class CreateTicketEntryAction : Action {
    object SelectBack : CreateTicketEntryAction()
    object SelectNext : CreateTicketEntryAction()
    data class ChangeEmail(val value: String) : CreateTicketEntryAction()
    data class ChangeName(val value: String) : CreateTicketEntryAction()
    data class SelectCountry(val position: Int) : CreateTicketEntryAction()
    data class SelectTopic(val position: Int) : CreateTicketEntryAction()
}

class CreateTicketEntryViewState : ViewState {
    val emailError = createState<InputError>()
    val nameError = createState<InputError>()
    val countryError = createState<InputError>()
    val topicError = createState<InputError>()
}

suspend fun CreateTicketEntryViewState.CreateTicketEntryLogic(
    actions: Observable<CreateTicketEntryAction>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
) {
    var email = "";
    var name = ""
    var countryPosition = 0
    var topicPosition = 0

    emailError.accept(InputError.NONE)
    nameError.accept(InputError.NONE)
    countryError.accept(InputError.NONE)
    topicError.accept(InputError.NONE)

    logic@ while (true) when (val action = actions.awaitFirst()) {
        SelectBack -> {
            break@logic
        }
        SelectNext -> {
            continue@logic
        }
        is ChangeEmail -> {
            email = action.value
            emailError.accept(InputError.NONE)
        }
        is ChangeName -> {
            name = action.value
            nameError.accept(InputError.NONE)
        }
        is SelectCountry -> {
            countryPosition = action.position
            countryError.accept(InputError.NONE)
        }
        is SelectTopic -> {
            topicPosition = action.position
            topicError.accept(InputError.NONE)
        }
    }
}
