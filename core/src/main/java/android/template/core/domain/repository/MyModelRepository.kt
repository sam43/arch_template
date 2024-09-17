package android.template.core.domain.repository

import android.template.core.domain.usecase.CoroutineUseCaseRunner
import android.template.core.source.remote.sample.IMyModelLocalDataSource
import android.template.core.source.remote.sample.MyModelLocalDataSource
import android.template.core.utils.IODispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import android.template.core_db.MyModel
import android.template.core_db.MyModelDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

interface MyModelRepository {
    val myModels: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultMyModelRepository @Inject constructor(
    private val localDataSource: IMyModelLocalDataSource
) : MyModelRepository {
    override val myModels: Flow<List<String>> = localDataSource.getLocalData().map { items -> items.map { it.name } }
    
    override suspend fun add(name: String) = localDataSource.insertIntoLocalData(name)
}