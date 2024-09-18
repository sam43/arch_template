package android.template.core.source.local

import android.template.core_db.entity.MyModel
import android.template.core_db.entity.MyModelDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IMyModelLocalDataSource {
	fun getLocalData(): Flow<List<MyModel>>
	suspend fun insertIntoLocalData(name: String)
}
class MyModelLocalDataSource @Inject constructor(private val myModelDao: MyModelDao):
	IMyModelLocalDataSource {
	override fun getLocalData(): Flow<List<MyModel>> = myModelDao.getMyModels()
	
	override suspend fun insertIntoLocalData(name: String) = myModelDao.insertMyModel(MyModel(name = name))
	
}