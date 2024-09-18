package android.template.service

import android.template.core.utils.Constants.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ApiManager @Inject constructor() {
	
	companion object {
		private const val HTTP_CONNECT_TIMEOUT = 10L
		private const val HTTP_READ_TIMEOUT = 60L
		private const val HTTP_WRITE_TIMEOUT = 60L
		private const val HTTP_MAX_IDLE_CONNECTIONS = 15
		private const val HTTP_KEEP_ALIVE_DURATION = 3L
	}
	
	fun <S> createBasicAuthService(serviceClass: Class<S>): S{
		val moshi = Moshi.Builder()
			.add(KotlinJsonAdapterFactory())
			.build()
		
		val retrofit = Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(createOkHttpClient())
			.addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
			.addCallAdapterFactory(CoroutineCallAdapterFactory())
			.build()
		
		return retrofit.create(serviceClass)
	}
	
	private fun createOkHttpClient(): OkHttpClient {
		val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
		httpClient.connectionPool(ConnectionPool(HTTP_MAX_IDLE_CONNECTIONS, HTTP_KEEP_ALIVE_DURATION, TimeUnit.MINUTES))
		httpClient.connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
		httpClient.readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
		httpClient.writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
		
		
		val logging = HttpLoggingInterceptor()
		logging.level = HttpLoggingInterceptor.Level.BODY
		httpClient.addInterceptor(logging)
		
//
//		if (BuildConfig.DEBUG) {
//		}
		return httpClient.build()
	}
}