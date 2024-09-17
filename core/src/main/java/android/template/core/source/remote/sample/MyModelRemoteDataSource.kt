package android.template.core.source.remote.sample

import android.template.core.domain.repository.MyModelRepository
import android.template.core_db.MyModel
import javax.inject.Inject

interface IMyModelRemoteDataSource {
	suspend fun getData(): MyModel
}
class MyModelRemoteDataSource @Inject constructor(private val myModelRepository: MyModelRepository): IMyModelRemoteDataSource {
	override suspend fun getData(): MyModel {
		return MyModel("sample")
	}
}