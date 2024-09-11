package io.rakuten.arch.core.datastore.helper

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule


@OptIn(ExperimentalCoroutinesApi::class)
abstract class CoroutineTest {
	@Rule
	@JvmField
	val rule = InstantTaskExecutorRule()
	
	protected val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
	protected val testCoroutineScope = TestScope(testDispatcher)
	
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
		testDispatcher.cleanupTestCoroutines()
	}
	
	fun coTest(block: suspend TestScope.() -> Unit) =
		testCoroutineScope.run { block }
}