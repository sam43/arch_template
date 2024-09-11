package io.rakuten.arch.core.datastore.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.rakuten.arch.core.datastore.DataStoreTest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UserPrefRepositoryTest: DataStoreTest() {
	@get:Rule
	val tmpFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()
	
	private lateinit var userPrefRepository: FakeUserPrefRepository
	private val expectedAge = 26
	
	@Before
	fun setup() {
		super.createDatastore()
		userPrefRepository = FakeUserPrefRepository(dataStore)
	}
	
	@Test
	fun defaultPrefValue() = runTest {
		val defaultAgeValue = 0
		coTest {
			assertEquals(defaultAgeValue, userPrefRepository.getUserAge("user_age").first())
		}
	}
	
	@Test
	fun writeToAndReadFromSharedPref() = runTest {
		coTest {
			// Make sure that setUserAge runs on the correct dispatcher
			userPrefRepository.setUserAge(expectedAge)
			assertEquals(expectedAge, userPrefRepository.getUserAge("user_age").first())
		}
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