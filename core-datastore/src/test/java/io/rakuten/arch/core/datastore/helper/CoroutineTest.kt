package io.rakuten.arch.core.datastore.helper

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.CancellationException


@OptIn(ExperimentalCoroutinesApi::class)
abstract class CoroutineTest {
	@Rule
	@JvmField
	val rule = InstantTaskExecutorRule()
	
	protected val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
	private val testCoroutineScope = TestScope(testDispatcher)
	
	@Before
	fun setupViewModelScope() {
		Dispatchers.setMain(testDispatcher)
	}
	
	@After
	fun cleanupViewModelScope() {
		Dispatchers.resetMain()
	}
	
	@After
	fun cleanupCoroutines() {
//		testDispatcher.cleanupTestCoroutines() // deprecated if we use "runTest { }" it will automatically cleanup
		testDispatcher.cancel(CancellationException("Cancelling due to cleanupTestCoroutines"))
		testCoroutineScope.backgroundScope.cancel("Cancelling background job")
	}
	
	// "runTest { }" replaces the "coTest { }; leaving following code for future reference"
	fun coTest(block: suspend TestScope.() -> Unit) =
		testCoroutineScope.run { block }
}