package android.template.di

import android.content.Context
import android.template.App
import android.template.core.service.network.NetworkManager
import android.template.service.network.PhotosApiService
import android.template.service.network.TopApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface ServiceModule {
	
	@Provides
	@Singleton
	fun provideApplication(@ApplicationContext app: Context): App {
		return app as App
	}
	@Provides
	@Singleton
	fun provideApiManager(app: App): NetworkManager = NetworkManager(app)
	
	@Provides
	@Singleton
	fun provideTopApiService(apiManager: NetworkManager, moshi: Moshi): TopApiService =
		apiManager.createBasicApiService(
			TopApiService::class.java, moshi
		)
	
	@Provides
	@Singleton
	fun provideTopApiServiceWithCache(
		apiManager: NetworkManager,
		moshi: Moshi,
		cache: Cache
	): TopApiService = apiManager.createBasicApiServiceWithCache(TopApiService::class.java, moshi, cache)
	
	@Provides
	@Singleton
	fun provideDetailApiService(apiManager: NetworkManager, moshi: Moshi): PhotosApiService =
		apiManager.createBasicApiService(
			PhotosApiService::class.java, moshi
		)
	
	@Provides
	@Singleton
	fun provideDetailApiServiceWithCache(
		apiManager: NetworkManager,
		moshi: Moshi,
		cache: Cache
	): PhotosApiService = apiManager.createBasicApiServiceWithCache(PhotosApiService::class.java, moshi, cache)
}