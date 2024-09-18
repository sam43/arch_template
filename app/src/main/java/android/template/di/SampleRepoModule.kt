package android.template.di

import android.template.domain.sampleRepo.ISampleInAppRepository
import android.template.domain.sampleRepo.SampleInAppRepository
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
interface SampleRepoModule {
	
	@Singleton
	@Binds
	fun bindsSampleRepository(
		myModelRepository: SampleInAppRepository
	): ISampleInAppRepository
}