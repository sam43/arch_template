package android.template.core.domain.repository

import android.template.core.source.sample.local.IMyModelLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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