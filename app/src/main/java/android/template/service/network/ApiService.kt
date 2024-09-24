package android.template.service.network

import android.template.core.service.dto.BaseResponseDto
import android.template.service.model.dto.AnimeDto
import android.template.service.model.dto.MangaDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TopApiService {
	@GET("top/anime")
	fun fetchTopAnimeList(): Response<BaseResponseDto<List<AnimeDto>>>
	
	@GET("top/manga")
	fun fetchTopMangaList(): Response<BaseResponseDto<List<MangaDto>>>
}

interface PhotosApiService {
	@GET("anime/{id}/pictures")
	fun fetchAnimePhotosList(@Path("id") animeId: String)
}