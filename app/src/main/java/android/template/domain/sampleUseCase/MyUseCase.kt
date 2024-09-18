package android.template.domain.sampleUseCase

import javax.inject.Inject

class MyUseCase @Inject constructor() {
	suspend operator fun invoke() {
		// ... do your operation
	}
}