package xyz.kewiany.contactus

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import xyz.kewiany.contactus.logic.common.MainViewState
import xyz.kewiany.contactus.logic.faq.FAQViewState
import xyz.kewiany.contactus.logic.menu.MenuViewState

class MainStateT(val state: MainViewState)
class MenuViewStateT(val state: MenuViewState)
class FAQViewStateT(private val state: FAQViewState) {
    val items = state.items.T
}

val <S : Any> TestObserver<S>.value: S get() = values().last()
private val <S : Any> Observable<S>.T: TestObserver<S> get() = test()
