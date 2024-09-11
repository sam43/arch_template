package io.rakuten.arch.core.datastore.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.rakuten.arch.core.datastore.DataStoreTest
import io.rakuten.arch.core.datastore.readIntValueOf
import io.rakuten.arch.core.datastore.utils.Constants.KEY_USER_AGE
import io.rakuten.arch.core.datastore.writeIntValueOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
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
		// initialize fake repository for test
		userPrefRepository = FakeUserPrefRepository(dataStore)
	}
	
	@Test
	fun defaultValueWhenNoSharedPrefOperation() = runTest {
		val defaultAgeValue = 0 // when no value default is '0'
		assertEquals(defaultAgeValue, userPrefRepository.getUserAge(KEY_USER_AGE).first())
	}
	
	@Test
	fun writeToSharedPrefAndReadFromIt() = runTest {
		userPrefRepository.setUserAge(expectedAge)
		assertEquals(expectedAge, userPrefRepository.getUserAge(KEY_USER_AGE).first())
	}
}

interface IFakeUserPrefRepository {
	suspend fun setUserAge(age: Int)
	suspend fun getUserAge(key: String): Flow<Int>
}

class FakeUserPrefRepository(private val dataStore: DataStore<Preferences>):
	IFakeUserPrefRepository {
	override suspend fun setUserAge(age: Int) {
		dataStore.writeIntValueOf(KEY_USER_AGE, age)
	}
	override suspend fun getUserAge(key: String): Flow<Int> = dataStore.readIntValueOf(key)
}