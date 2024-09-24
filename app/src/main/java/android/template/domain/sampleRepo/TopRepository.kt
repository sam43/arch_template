package android.template.domain.sampleRepo

import android.template.data.source.sample.remote.TopRemoteDataSource
import android.template.service.model.dto.AnimeDto
import javax.inject.Inject

interface ITopRepository {
	fun fetchAnimeTop(): List<AnimeDto>
}

class TopRepository @Inject constructor(dataSource: TopRemoteDataSource): ITopRepository {
	// Sample implementation of repository based of project requirements
	override fun fetchAnimeTop(): List<AnimeDto> {
		// implementation of IAnimeRepository; (i.e: implementing SOLID principle's OCP and LSP)
		return emptyList()
	}
}