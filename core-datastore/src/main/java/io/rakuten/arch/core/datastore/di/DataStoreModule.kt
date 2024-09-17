package io.rakuten.arch.core.datastore.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.rakuten.arch.core.datastore.utils.Constants.PREFERENCE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
	private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)
	
	@Provides
	fun appContext(application: Application): Context = application.applicationContext
	
	@Provides
	@Singleton
	fun providePreferenceDataStore(context: Context): DataStore<Preferences> = context.dataStore
	
}