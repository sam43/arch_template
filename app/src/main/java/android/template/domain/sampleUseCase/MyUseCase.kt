package android.template.domain.sampleUseCase

import android.template.domain.sampleRepo.ISampleInAppRepository
import javax.inject.Inject

class MyUseCase @Inject constructor(private val repository: ISampleInAppRepository) {
	suspend operator fun invoke() {
		repository.getData()
		// ... do your operation
	}
}