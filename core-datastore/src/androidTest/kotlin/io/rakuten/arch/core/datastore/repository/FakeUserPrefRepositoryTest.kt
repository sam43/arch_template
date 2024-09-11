package io.rakuten.arch.core.datastore.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.filters.SmallTest
import io.rakuten.arch.core.datastore.DataStoreTest
import io.rakuten.arch.core.datastore.readIntValueOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class UserPrefRepositoryTest: DataStoreTest() {
	private val userPrefRepository: FakeUserPrefRepository = FakeUserPrefRepository(dataStore)
	private val expectedAge = 26

	@Test
	fun addition_isCorrect() = runTest {
		assertEquals(4, 2 + 2)
	}
	
	@Test
	fun write_to_shared_preference() = coTest {
		// Make sure that setUserAge runs on the correct dispatcher
		userPrefRepository.setUserAge(expectedAge)
		assertEquals(expectedAge, userPrefRepository.getUserAge("user_age").first())
	}
}

interface IFakeUserPrefRepository {
	suspend fun setUserAge(age: Int)
	
	// removed suspend keyword from below methods to get data directly in main thread
	suspend fun getUserAge(key: String): Flow<Int>
	
}

class FakeUserPrefRepository(private val dataStore: DataStore<Preferences>):
	IFakeUserPrefRepository {
	private var sampleAge = 20
	override suspend fun setUserAge(age: Int) {
//		dataStore.edit { pref -> pref[intPreferencesKey("user_age")] = age }
		sampleAge = age
	}
	override suspend fun getUserAge(key: String): Flow<Int> = flowOf(sampleAge) // dataStore.readIntValueOf(key)
	
}