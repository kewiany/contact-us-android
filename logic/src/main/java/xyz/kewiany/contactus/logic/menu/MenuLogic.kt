package xyz.kewiany.contactus.logic.menu

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.ofType
import kotlinx.coroutines.rx3.awaitFirst
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.ViewState
import xyz.kewiany.contactus.logic.faq.FAQLogic
import xyz.kewiany.contactus.logic.faq.FAQViewState
import xyz.kewiany.contactus.logic.menu.MenuAction.SelectCreateTicket
import xyz.kewiany.contactus.logic.menu.MenuAction.SelectFAQ
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryLogic
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryViewState

sealed class MenuAction : Action {
    object SelectBack : MenuAction()
    object SelectCreateTicket : MenuAction()
    object SelectFAQ : MenuAction()
}

class MenuViewState : ViewState {
    val createTicketEntryViewState = CreateTicketEntryViewState()
    val faqViewState = FAQViewState()
}

suspend fun MenuViewState.MenuLogic(
    actions: Observable<MenuAction>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
) {
    when (actions.awaitFirst()) {
        SelectCreateTicket -> createTicketEntryViewState.CreateTicketEntryLogic(actions.ofType(), dispatchers)
        SelectFAQ -> faqViewState.FAQLogic(actions.ofType(), dispatchers)
    }
}
