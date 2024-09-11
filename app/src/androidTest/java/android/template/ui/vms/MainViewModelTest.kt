package android.template.ui.vms

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

// under construction

@RunWith(AndroidJUnit4ClassRunner::class)
class MainViewModelTest {
	private val expectedAge = 26
	@Test
	fun addition_isCorrect() = runTest {
		assertEquals(4, 2 + 2)
	}
}