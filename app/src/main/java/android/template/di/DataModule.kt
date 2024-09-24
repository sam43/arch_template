package android.template.di

import android.template.domain.sampleRepo.ITopRepository
import android.template.domain.sampleRepo.TopRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * This is a if needed module
 * But It is recommended to use the "core" one
 * */

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
	
	@Singleton
	@Binds
	fun bindsTopRepository(
		topRepository: TopRepository
	): ITopRepository
	
	@Singleton
	@Binds
	fun bindsTopDataSource(
		topRepository: TopRepository
	): ITopRepository
}