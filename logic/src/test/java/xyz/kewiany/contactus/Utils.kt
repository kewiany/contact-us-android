package xyz.kewiany.contactus

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import xyz.kewiany.contactus.logic.FAQViewState
import xyz.kewiany.contactus.logic.MenuViewState
import xyz.kewiany.contactus.logic.common.MainViewState

class MainStateT(val state: MainViewState)
class MenuViewStateT(val state: MenuViewState)
class FAQViewStateT(private val state: FAQViewState) {
    val items = state.items.T
}

val <S : Any> TestObserver<S>.value: S get() = values().last()
private val <S : Any> Observable<S>.T: TestObserver<S> get() = test()
