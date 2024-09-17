package android.template.core.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// Sample:: define this for networking and data fetch remotely (or use network module)
@Module
@InstallIn(SingletonComponent::class)
interface ServiceModule {
	
	@Singleton
	fun provideApiService(): ApiService
}

// Sample ApiService interface
interface ApiService {
	// @GET/@POST api call
}