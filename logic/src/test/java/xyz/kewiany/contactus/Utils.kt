package xyz.kewiany.contactus

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import xyz.kewiany.contactus.logic.common.MainViewState
import xyz.kewiany.contactus.logic.faq.FAQViewState
import xyz.kewiany.contactus.logic.menu.MenuViewState
import xyz.kewiany.contactus.logic.ticket.CreateTicketEntryViewState

class MainStateT(val state: MainViewState)
class MenuViewStateT(val state: MenuViewState)
class FAQViewStateT(state: FAQViewState) {
    val items = state.items.T
}

class CreateTicketEntryStateT(state: CreateTicketEntryViewState)

val <S : Any> TestObserver<S>.value: S get() = values().last()
private val <S : Any> Observable<S>.T: TestObserver<S> get() = test()
