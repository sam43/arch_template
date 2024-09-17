package android.template.core.domain.usecase.sample

import android.template.core.domain.repository.MyModelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MyUseCase @Inject constructor(private val repository: MyModelRepository) {
	suspend operator fun invoke(): Flow<List<String>> {
		val flowOfList = repository.myModels
		// ... do your operation
		return flowOfList
	}
}