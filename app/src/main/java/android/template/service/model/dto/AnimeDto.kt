package android.template.service.model.dto

import android.template.service.model.dto.common.Demographic
import android.template.service.model.dto.common.Genre
import android.template.service.model.dto.common.Images
import android.template.service.model.dto.common.Theme
import android.template.service.model.dto.common.Title
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class AnimeDto(
	@Json(name = "mal_id") val malId: Int? = 0, // 52991
	@Json(name = "url") val url: String? = "", // https://myanimelist.net/anime/52991/Sousou_no_Frieren
	@Json(name = "images") val images: Images? = Images(),
	@Json(name = "trailer") val trailer: Trailer? = Trailer(),
	@Json(name = "approved") val approved: Boolean? = false, // true
	@Json(name = "titles") val titles: List<Title?>? = listOf(),
	@Json(name = "title") val title: String? = "", // Sousou no Frieren
	@Json(name = "title_english") val titleEnglish: String? = "", // Frieren: Beyond Journey's End
	@Json(name = "title_japanese") val titleJapanese: String? = "", // 葬送のフリーレン
	@Json(name = "title_synonyms") val titleSynonyms: List<String?>? = listOf(),
	@Json(name = "type") val type: String? = "", // TV
	@Json(name = "source") val source: String? = "", // Manga
	@Json(name = "episodes") val episodes: Int? = 0, // 28
	@Json(name = "status") val status: String? = "", // Finished Airing
	@Json(name = "airing") val airing: Boolean? = false, // false
	@Json(name = "aired") val aired: Aired? = Aired(),
	@Json(name = "duration") val duration: String? = "", // 24 min per ep
	@Json(name = "rating") val rating: String? = "", // PG-13 - Teens 13 or older
	@Json(name = "score") val score: Double? = 0.0, // 9.33
	@Json(name = "scored_by") val scoredBy: Int? = 0, // 502781
	@Json(name = "rank") val rank: Int? = 0, // 1
	@Json(name = "popularity") val popularity: Int? = 0, // 200
	@Json(name = "members") val members: Int? = 0, // 892399
	@Json(name = "favorites") val favorites: Int? = 0, // 52209
	@Json(name = "synopsis") val synopsis: String? = "", // During their decade-long quest to defeat the Demon King, the members of the hero's party—Himmel himself, the priest Heiter, the dwarf warrior Eisen, and the elven mage Frieren—forge bonds through adventures and battles, creating unforgettable precious memories for most of them.However, the time that Frieren spends with her comrades is equivalent to merely a fraction of her life, which has lasted over a thousand years. When the party disbands after their victory, Frieren casually returns to her "usual" routine of collecting spells across the continent. Due to her different sense of time, she seemingly holds no strong feelings toward the experiences she went through.As the years pass, Frieren gradually realizes how her days in the hero's party truly impacted her. Witnessing the deaths of two of her former companions, Frieren begins to regret having taken their presence for granted; she vows to better understand humans and create real personal connections. Although the story of that once memorable journey has long ended, a new tale is about to begin.[Written by MAL Rewrite]
	@Json(name = "background") val background: String? = "", // Sousou no Frieren was released on Blu-ray and DVD in seven volumes from January 24, 2024, to July 17, 2024.
	@Json(name = "season") val season: String? = "", // fall
	@Json(name = "year") val year: Int? = 0, // 2023
	@Json(name = "broadcast") val broadcast: Broadcast? = Broadcast(),
	@Json(name = "producers") val producers: List<Producer?>? = listOf(),
	@Json(name = "licensors") val licensors: List<Licensor?>? = listOf(),
	@Json(name = "studios") val studios: List<Studio?>? = listOf(),
	@Json(name = "genres") val genres: List<Genre?>? = listOf(),
	@Json(name = "explicit_genres") val explicitGenres: List<Any?>? = listOf(),
	@Json(name = "themes") val themes: List<Theme?>? = listOf(),
	@Json(name = "demographics") val demographics: List<Demographic?>? = listOf()
) {
	@JsonClass(generateAdapter = true)
	data class Trailer(
		@Json(name = "youtube_id") val youtubeId: String? = "", // ZEkwCGJ3o7M
		@Json(name = "url") val url: String? = "", // https://www.youtube.com/watch?v=ZEkwCGJ3o7M
		@Json(name = "embed_url") val embedUrl: String? = "", // https://www.youtube.com/embed/ZEkwCGJ3o7M?enablejsapi=1&wmode=opaque&autoplay=1
		@Json(name = "images") val images: Images? = Images()
	) {
		@JsonClass(generateAdapter = true)
		data class Images(
			@Json(name = "image_url") val imageUrl: String? = "", // https://img.youtube.com/vi/ZEkwCGJ3o7M/default.jpg
			@Json(name = "small_image_url") val smallImageUrl: String? = "", // https://img.youtube.com/vi/ZEkwCGJ3o7M/sddefault.jpg
			@Json(name = "medium_image_url") val mediumImageUrl: String? = "", // https://img.youtube.com/vi/ZEkwCGJ3o7M/mqdefault.jpg
			@Json(name = "large_image_url") val largeImageUrl: String? = "", // https://img.youtube.com/vi/ZEkwCGJ3o7M/hqdefault.jpg
			@Json(name = "maximum_image_url") val maximumImageUrl: String? = "" // https://img.youtube.com/vi/ZEkwCGJ3o7M/maxresdefault.jpg
		)
	}
	
	@JsonClass(generateAdapter = true)
	data class Aired(
		@Json(name = "from") val from: String? = "", // 2023-09-29T00:00:00+00:00
		@Json(name = "to") val to: String? = "", // 2024-03-22T00:00:00+00:00
		@Json(name = "prop") val prop: Prop? = Prop(),
		@Json(name = "string") val string: String? = "" // Sep 29, 2023 to Mar 22, 2024
	) {
		@JsonClass(generateAdapter = true)
		data class Prop(
			@Json(name = "from") val from: From? = From(),
			@Json(name = "to") val to: To? = To()
		) {
			@JsonClass(generateAdapter = true)
			data class From(
				@Json(name = "day") val day: Int? = 0, // 29
				@Json(name = "month") val month: Int? = 0, // 9
				@Json(name = "year") val year: Int? = 0 // 2023
			)
			
			@JsonClass(generateAdapter = true)
			data class To(
				@Json(name = "day") val day: Int? = 0, // 22
				@Json(name = "month") val month: Int? = 0, // 3
				@Json(name = "year") val year: Int? = 0 // 2024
			)
		}
	}
	
	@JsonClass(generateAdapter = true)
	data class Broadcast(
		@Json(name = "day") val day: String? = "", // Fridays
		@Json(name = "time") val time: String? = "", // 23:00
		@Json(name = "timezone") val timezone: String? = "", // Asia/Tokyo
		@Json(name = "string") val string: String? = "" // Fridays at 23:00 (JST)
	)
	
	@JsonClass(generateAdapter = true)
	data class Producer(
		@Json(name = "mal_id") val malId: Int? = 0, // 17
		@Json(name = "type") val type: String? = "", // anime
		@Json(name = "name") val name: String? = "", // Aniplex
		@Json(name = "url") val url: String? = "" // https://myanimelist.net/anime/producer/17/Aniplex
	)
	
	@JsonClass(generateAdapter = true)
	data class Licensor(
		@Json(name = "mal_id") val malId: Int? = 0, // 102
		@Json(name = "type") val type: String? = "", // anime
		@Json(name = "name") val name: String? = "", // Funimation
		@Json(name = "url") val url: String? = "" // https://myanimelist.net/anime/producer/102/Funimation
	)
	
	@JsonClass(generateAdapter = true)
	data class Studio(
		@Json(name = "mal_id") val malId: Int? = 0, // 11
		@Json(name = "type") val type: String? = "", // anime
		@Json(name = "name") val name: String? = "", // Madhouse
		@Json(name = "url") val url: String? = "" // https://myanimelist.net/anime/producer/11/Madhouse
	)
}