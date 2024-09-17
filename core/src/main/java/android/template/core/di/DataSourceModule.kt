package android.template.core.di

import android.template.core.source.remote.sample.IMyModelLocalDataSource
import android.template.core.source.remote.sample.IMyModelRemoteDataSource
import android.template.core.source.remote.sample.MyModelLocalDataSource
import android.template.core.source.remote.sample.MyModelRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
	
	@Singleton
	@Binds
	fun bindsMyModelRemoteDataSource(
		remoteDataSource: MyModelRemoteDataSource
	): IMyModelRemoteDataSource
	
	@Singleton
	@Binds
	fun bindsMyModelLocalDataSource(
		localDataSource: MyModelLocalDataSource
	): IMyModelLocalDataSource
}