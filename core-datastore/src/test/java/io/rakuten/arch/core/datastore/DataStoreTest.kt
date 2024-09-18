package io.rakuten.arch.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import io.rakuten.arch.core.datastore.helper.CoroutineTest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import org.junit.After
import org.junit.Before
import java.io.File

abstract class DataStoreTest: CoroutineTest() {
	private lateinit var preferencesScope: CoroutineScope
	protected lateinit var dataStore: DataStore<Preferences>
	
	@Before
	fun createDatastore() {
		preferencesScope = CoroutineScope(testDispatcher + Job())
		
		dataStore = PreferenceDataStoreFactory.create(scope = preferencesScope) {
			InstrumentationRegistry.getInstrumentation().targetContext.preferencesDataStoreFile(
				"test-preferences-file"
			)
		}
	}
	
	@After
	fun removeDatastore() {
		File(
			ApplicationProvider.getApplicationContext<Context>().filesDir,
			"datastore"
		).deleteRecursively()
		
		preferencesScope.cancel()
	}
}