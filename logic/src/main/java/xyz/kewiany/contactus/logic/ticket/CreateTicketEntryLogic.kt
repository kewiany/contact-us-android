package xyz.kewiany.contactus.logic.ticket

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.rx3.awaitFirst
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.ViewState

sealed class CreateTicketEntryAction : Action {
    object SelectBack : CreateTicketEntryAction()
    object SelectNext : CreateTicketEntryAction()
}

class CreateTicketEntryViewState : ViewState

suspend fun CreateTicketEntryViewState.CreateTicketEntryLogic(
    actions: Observable<CreateTicketEntryAction>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
) {
    actions.awaitFirst()
}
