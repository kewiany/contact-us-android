package xyz.kewiany.contactus.logic

import kotlinx.coroutines.*
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.logic.common.MainViewState
import kotlin.coroutines.CoroutineContext

suspend fun MainViewState.MainLogic(
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
): Boolean {
    commonViewState.isLoading = true
        withContext(dispatchers.io()) {
            delay(1000)
            commonViewState.isLoading = false
        }

    return true
}
