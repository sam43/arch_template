package android.template.core

import android.template.core_db.MyModel
import android.template.core_db.MyModelDao
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
        val repository = DefaultMyModelRepository(FakeMyModelDao())

        repository.add("Repository")

        assertEquals(repository.myModels.first().size, 1)
    }
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