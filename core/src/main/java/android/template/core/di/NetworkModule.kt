package android.template.core.di

import android.app.Application
import android.template.core.service.network.NetworkManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
	@Provides
	@Singleton
	fun provideApiManager(app: Application): NetworkManager = NetworkManager(app)
	
	@Provides
	@Singleton
	fun provideCache(apiManager: NetworkManager): Cache = apiManager.createCacheMemoryForApiResponse()
	
	@Provides
	@Singleton
	fun provideMoshi(): Moshi = Moshi.Builder()
		.add(KotlinJsonAdapterFactory())
		.build()
}