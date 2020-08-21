package xyz.kewiany.contactus

import io.kotest.core.Tuple2
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import xyz.kewiany.contactus.core.DispatcherProvider

abstract class CustomFreeSpec constructor(
    body: CustomFreeSpec.() -> Unit
) : FreeSpec(body as FreeSpec.() -> Unit) {

    val testDispatcher = TestCoroutineDispatcher()
    val testDispatcherProvider = object : DispatcherProvider {
        override fun default(): CoroutineDispatcher = testDispatcher
        override fun io(): CoroutineDispatcher = testDispatcher
        override fun main(): CoroutineDispatcher = testDispatcher
        override fun unconfined(): CoroutineDispatcher = testDispatcher
    }

    override fun beforeEach(f: suspend (TestCase) -> Unit) {
        super.beforeEach(f)
        Dispatchers.setMain(testDispatcher)
    }

    override fun afterEach(f: suspend (Tuple2<TestCase, TestResult>) -> Unit) {
        super.afterEach(f)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}