package android.template.core

import android.template.core.domain.repository.DefaultMyModelRepository
import android.template.core.source.sample.local.IMyModelLocalDataSource
import android.template.core_db.entity.MyModel
import android.template.core_db.entity.MyModelDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit tests for [DefaultMyModelRepository].
 */
class DefaultMyModelRepositoryTest {

    @Test
    fun myModels_newItemSaved_itemIsReturned() = runTest {
        val repository = DefaultMyModelRepository(FakeLocalDataSource())

        repository.add("Repository")

        assertEquals(repository.myModels.first().size, 1)
    }
}

private abstract class DataSource

private class FakeLocalDataSource: DataSource(), IMyModelLocalDataSource {
    override fun getLocalData(): Flow<List<MyModel>> {
        TODO("Not yet implemented")
    }
    
    override suspend fun insertIntoLocalData(name: String) {
        TODO("Not yet implemented")
    }
    
}

private class FakeRemoteDataSource: DataSource() {

}

private class FakeMyModelDao : MyModelDao {
    private val data = mutableListOf<MyModel>()
    
    override fun getMyModels(): Flow<List<MyModel>> = flow {
        emit(data)
    }
    
    override suspend fun insertMyModel(item: MyModel) {
        data.add(0, item)
    }
}