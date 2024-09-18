package io.rakuten.arch.core.datastore.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.rakuten.arch.core.datastore.readDoubleValueOf
import io.rakuten.arch.core.datastore.readIntValueOf
import io.rakuten.arch.core.datastore.readStringValueOf
import io.rakuten.arch.core.datastore.utils.Constants.KEY_USER_AGE
import io.rakuten.arch.core.datastore.utils.Constants.KEY_USER_EXPENSE
import io.rakuten.arch.core.datastore.utils.Constants.KEY_USER_NAME
import io.rakuten.arch.core.datastore.writeDoubleValueOf
import io.rakuten.arch.core.datastore.writeIntValueOf
import io.rakuten.arch.core.datastore.writeStringValueOf
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * This is a sample implementation class created for testing purpose
 * Let's call it "UserPrefRepository"; we can implement the similar one in the client / app module
 * */
interface IUserPrefRepository {
	suspend fun setUserAge(age: Int)
	suspend fun setUserName(name: String)
	suspend fun setUserAnnualExpense(expense: Double)
	
	// removed suspend keyword from below methods to get data directly in main thread
	fun getUserAge(key: String): Flow<Int>
	fun getUserName(key: String): Flow<String>
	fun getUserAnnualExpense(key: String): Flow<Double>
	
}
open class UserPrefRepository @Inject constructor(private val dataStore: DataStore<Preferences>): IUserPrefRepository {
	override suspend fun setUserAge(age: Int) {
		dataStore.writeIntValueOf(KEY_USER_AGE, age)
	}
	
	override suspend fun setUserName(name: String) {
		dataStore.writeStringValueOf(KEY_USER_NAME, name)
	}
	
	override suspend fun setUserAnnualExpense(expense: Double) {
		dataStore.writeDoubleValueOf(KEY_USER_EXPENSE, expense)
	}
	
	override fun getUserAge(key: String): Flow<Int> = dataStore.readIntValueOf(key)
	
	override fun getUserName(key: String): Flow<String> = dataStore.readStringValueOf(key)
	
	override fun getUserAnnualExpense(key: String): Flow<Double> = dataStore.readDoubleValueOf(key)
}