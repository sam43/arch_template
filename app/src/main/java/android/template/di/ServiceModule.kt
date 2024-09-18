package android.template.di

import android.template.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
interface ServiceModule {
	
	@Provides
	fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
	
	@Provides
	fun provideHttpLoggingInterceptor() = 0 // todo:: add logging interception implementation
	
	@Provides
	fun provideOkhttp() = 0 // todo:: initialize okhttp3 and build
}