package xyz.kewiany.contactus

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import xyz.kewiany.contactus.logic.FAQViewState
import xyz.kewiany.contactus.logic.MenuViewState
import xyz.kewiany.contactus.logic.common.MainViewState

class MainStateT(val state: MainViewState)
class MenuViewStateT(val state: MenuViewState)
class FAQViewStateT(val state: FAQViewState)

private val <S : Any> Observable<S>.T: TestObserver<S> get() = test()
