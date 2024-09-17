package android.template.core.di

import android.template.core.domain.repository.DefaultMyModelRepository
import android.template.core.domain.repository.MyModelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
	
	@Singleton
	@Binds
	fun bindsMyModelRepository(
		myModelRepository: DefaultMyModelRepository
	): MyModelRepository
}