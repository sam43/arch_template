package android.template.domain.sampleRepo

import javax.inject.Inject

interface ISampleInAppRepository {
	fun getData()
}

class SampleInAppRepository @Inject constructor(): ISampleInAppRepository {
	// Sample implementation of repository based of project requirements
	override fun getData() {
		// implementation of ISampleInAppRepository; (i.e: implementing SOLID principle's OCP and LSP)
	}
}