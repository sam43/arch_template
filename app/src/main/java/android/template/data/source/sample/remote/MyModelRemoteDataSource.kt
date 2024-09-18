package android.template.data.source.sample.remote

import android.template.core.domain.repository.MyModelRepository
import android.template.data.source.sample.local.MyModelDto
import javax.inject.Inject

/**
 * SOLID: Open-Closed Principle (OCP)
 * @author Sadat Sayem
 * */

interface IMyModelRemoteDataSource {
	suspend fun getData(): MyModelDto
}
class MyModelRemoteDataSource @Inject constructor(private val repository: MyModelRepository):
	IMyModelRemoteDataSource {
	override suspend fun getData(): MyModelDto {
		return MyModelDto("sample")
	}
}