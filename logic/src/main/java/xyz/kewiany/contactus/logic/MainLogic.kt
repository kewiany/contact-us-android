package xyz.kewiany.contactus.logic

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.MainViewState

suspend fun MainViewState.MainLogic(
    actions: Observable<Action>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
): Boolean {
    commonViewState.isLoading.accept(true)
    withContext(dispatchers.io()) {
        delay(1000)
        commonViewState.isLoading.accept(false)
    }
    return true
}
