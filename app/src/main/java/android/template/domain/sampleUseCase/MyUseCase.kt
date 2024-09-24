package android.template.domain.sampleUseCase

import android.template.domain.sampleRepo.ITopRepository
import javax.inject.Inject

class MyUseCase @Inject constructor(private val repository: ITopRepository) {
	suspend operator fun invoke() {
		repository.fetchAnimeTop()
		// ... do your operation
	}
}