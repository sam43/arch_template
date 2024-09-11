package android.template.ui.vms

import android.template.DataStoreTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.rakuten.arch.core.datastore.repository.UserPrefRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainViewModelTest: DataStoreTest() {
	private val userPrefRepository: UserPrefRepository = UserPrefRepository(dataStore)
	private val expectedAge = 26
	
	@Test
	fun addition_isCorrect() {
		assertEquals(4, 2 + 2)
	}
}