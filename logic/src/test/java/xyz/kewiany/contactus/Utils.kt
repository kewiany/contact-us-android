package xyz.kewiany.contactus

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import xyz.kewiany.contactus.logic.common.MainViewState

class MainStateT(val state: MainViewState)

private val <S : Any> Observable<S>.T: TestObserver<S> get() = test()
