package android.template.core.di

import android.template.core.utils.IODispatcher
import android.template.core.utils.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
interface CoroutineModule {
    
    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineContext = Dispatchers.IO
    
    @Provides
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineContext = Dispatchers.Main
}