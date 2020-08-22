package xyz.kewiany.contactus.logic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.ofType
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.MainViewState
import xyz.kewiany.contactus.logic.menu.MenuLogic

suspend fun MainViewState.MainLogic(
    actions: Observable<Action>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
): Boolean {
    commonViewState.isLoading.accept(true)
    withContext(dispatchers.io()) {
        delay(1000)
        commonViewState.isLoading.accept(false)
    }
    menuState.MenuLogic(actions.ofType())
    return true
}
