package io.rakuten.arch.core.datastore.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.rakuten.arch.core.datastore.repository.IUserPrefRepository
import io.rakuten.arch.core.datastore.repository.UserPrefRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
	
	@Singleton
	@Binds
	fun bindsUserPrefRepository(
		userPrefRepository: UserPrefRepository
	): IUserPrefRepository
}