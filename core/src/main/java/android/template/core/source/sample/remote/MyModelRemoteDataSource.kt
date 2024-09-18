package android.template.core.source.sample.remote

import android.template.core.domain.repository.MyModelRepository
import android.template.core_db.entity.MyModel
import javax.inject.Inject

/**
 * SOLID: Open-Closed Principle (OCP)
 * @author Sadat Sayem
 * */

interface IMyModelRemoteDataSource {
	suspend fun getData(): MyModel
}
class MyModelRemoteDataSource @Inject constructor(private val repository: MyModelRepository):
	IMyModelRemoteDataSource {
	override suspend fun getData(): MyModel {
		return MyModel("sample")
	}
}