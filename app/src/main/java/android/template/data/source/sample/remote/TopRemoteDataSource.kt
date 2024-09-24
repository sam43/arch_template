package android.template.data.source.sample.remote

import android.template.core.service.dto.BaseResponseDto
import android.template.core.service.network.ApiResult
import android.template.core.service.network.handleApi
import android.template.service.model.dto.AnimeDto
import android.template.service.network.TopApiService
import javax.inject.Inject

/**
 * SOLID: Open-Closed Principle (OCP)
 * @author Sadat Sayem
 * */

interface ITopRemoteDataSource {
	suspend fun fetchAnimeTopList(): ApiResult<BaseResponseDto<List<AnimeDto>>>
}
class TopRemoteDataSource @Inject constructor(private val topApi: TopApiService):
	ITopRemoteDataSource {
	override suspend fun fetchAnimeTopList(): ApiResult<BaseResponseDto<List<AnimeDto>>> =
		handleApi { topApi.fetchTopAnimeList() }
}