package xyz.kewiany.contactus.logic

import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.logic.common.MainViewState

suspend fun MainViewState.MainLogic(
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
): Boolean {
    commonViewState.isLoading.accept(true)
    withContext(dispatchers.io()) {
        delay(1000)
        commonViewState.isLoading.accept(false)
    }

    return true
}
