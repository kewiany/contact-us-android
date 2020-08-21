package xyz.kewiany.contactus.logic

import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider

suspend fun MainLogic(dispatchers: DispatcherProvider = DefaultDispatcherProvider()): Boolean {
    withContext(dispatchers.io()) {
        delay(5000)
    }
    return true
}
