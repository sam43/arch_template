package android.template.core.service.network

import android.app.Application
import android.template.core.BuildConfig
import android.template.core.utils.Constants.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NetworkManager @Inject constructor(private val app: Application) {
	
	companion object {
		private const val HTTP_CONNECT_TIMEOUT = 10L
		private const val HTTP_READ_TIMEOUT = 60L
		private const val HTTP_WRITE_TIMEOUT = 60L
		private const val HTTP_MAX_IDLE_CONNECTIONS = 15
		private const val HTTP_KEEP_ALIVE_DURATION = 3L
	}
	
	fun <S> createBasicApiService(serviceClass: Class<S>, moshi: Moshi): S {
		val retrofit = Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(createOkHttpClient())
			.addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
			.addCallAdapterFactory(CoroutineCallAdapterFactory())
			.build()
		
		return retrofit.create(serviceClass)
	}
	
	fun <S> createBasicApiServiceWithCache(serviceClass: Class<S>, moshi: Moshi, cache: Cache): S {
		val retrofit = Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(createOkHttpClient(cache))
			.addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
			.addCallAdapterFactory(CoroutineCallAdapterFactory())
			.build()
		
		return retrofit.create(serviceClass)
	}
	
	private fun createOkHttpClient(cache: Cache? = null): OkHttpClient {
		val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
		if (cache != null) httpClient.cache(cache)
		httpClient.connectionPool(ConnectionPool(HTTP_MAX_IDLE_CONNECTIONS, HTTP_KEEP_ALIVE_DURATION, TimeUnit.MINUTES))
		httpClient.connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
		httpClient.readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
		httpClient.writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
		
		if (BuildConfig.DEBUG) {
			val logging = HttpLoggingInterceptor()
			logging.level = HttpLoggingInterceptor.Level.BODY
			httpClient.addInterceptor(logging)
		}
		return httpClient.build()
	}
	
	fun createCacheMemoryForApiResponse(): Cache {
		// optional:: for response caching
		val directory = File(app.cacheDir, "http_cache")
		val maxSize = 50L * 1024L * 1024L // 50 MiB
		return Cache(directory, maxSize)
	}
}