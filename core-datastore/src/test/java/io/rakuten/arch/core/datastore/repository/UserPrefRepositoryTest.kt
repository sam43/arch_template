package io.rakuten.arch.core.datastore.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestScope
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


private const val TEST_DATASTORE_NAME: String = "test_datastore"

@RunWith(AndroidJUnit4::class)
class UserPrefRepositoryTest {
	private val testContext: Context = ApplicationProvider.getApplicationContext()
	private lateinit var testDataStore: DataStore<Preferences>
	private val testScope = TestScope()

	private lateinit var userPrefRepository: FakeUserPrefRepository
	
	@Before
	fun setUp() {
		testDataStore = PreferenceDataStoreFactory.create(
			scope = testScope,
			produceFile = { testContext.preferencesDataStoreFile(TEST_DATASTORE_NAME) }
		)
		userPrefRepository = FakeUserPrefRepository(testDataStore)
	}

	@Test
	fun addition_isCorrect() {
		assertEquals(4, 2 + 2)
	}
	
	@Test
	fun `write to shared preference`() = runBlocking {
		// Make sure that setUserAge runs on the correct dispatcher
		userPrefRepository.setUserAge(28)
		assertEquals(28, userPrefRepository.getUserAge("user_age").first())
	}
	
	@After
	fun tearDown() {
		testScope.cancel()
	}
}


interface IFakeUserPrefRepository {
	suspend fun setUserAge(age: Int)
	
	// removed suspend keyword from below methods to get data directly in main thread
	suspend fun getUserAge(key: String): Flow<Int>
	
}

class FakeUserPrefRepository(private val dataStore: DataStore<Preferences>): IFakeUserPrefRepository {
	private var sampleAge = 20
	override suspend fun setUserAge(age: Int) {
//		dataStore.edit { pref -> pref[intPreferencesKey("user_age")] = age }
		sampleAge = age
	}
	override suspend fun getUserAge(key: String): Flow<Int> = flowOf(sampleAge) // dataStore.readIntValueOf(key)
	
}