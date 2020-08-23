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
    val emailInputError = createState<InputError>()
    val nameInputError = createState<InputError>()
    val countryInputError = createState<InputError>()
    val topicInputError = createState<InputError>()
}

suspend fun CreateTicketEntryViewState.CreateTicketEntryLogic(
    actions: Observable<CreateTicketEntryAction>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
) {
    when (actions.awaitFirst()) {
        is ChangeEmail -> {
            emailInputError.accept(InputError.NONE)
        }
        is ChangeName -> {
            nameInputError.accept(InputError.NONE)
        }
        is SelectCountry -> {
            countryInputError.accept(InputError.NONE)
        }
        is SelectTopic -> {
            topicInputError.accept(InputError.NONE)
        }
    }
}
