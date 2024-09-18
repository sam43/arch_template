package android.template.data.source.sample.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * SOLID: Open-Closed Principle (OCP)
 * @author Sadat Sayem
 * */

interface IMyModelLocalDataSource {
	fun getLocalData(): Flow<List<MyModelDto>>
}
class MyModelLocalDataSource @Inject constructor():
	IMyModelLocalDataSource {
	override fun getLocalData(): Flow<List<MyModelDto>> = flowOf(listOf(MyModelDto("sample")))
}

// Following code is created for sample
// See complete sample in core module

data class MyModelDto(
	val name: String
)