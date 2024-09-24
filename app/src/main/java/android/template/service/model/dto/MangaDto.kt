package android.template.service.model.dto

import android.template.service.model.dto.common.Demographic
import android.template.service.model.dto.common.Genre
import android.template.service.model.dto.common.Images
import android.template.service.model.dto.common.Theme
import android.template.service.model.dto.common.Title
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MangaDto(
	@Json(name = "mal_id") val malId: Int? = 0, // 2
	@Json(name = "url") val url: String? = "", // https://myanimelist.net/manga/2/Berserk
	@Json(name = "images") val images: Images? = Images(),
	@Json(name = "approved") val approved: Boolean? = false, // true
	@Json(name = "titles") val titles: List<Title?>? = listOf(),
	@Json(name = "title") val title: String? = "", // Berserk
	@Json(name = "title_english") val titleEnglish: String? = "", // Berserk
	@Json(name = "title_japanese") val titleJapanese: String? = "", // ベルセルク
	@Json(name = "title_synonyms") val titleSynonyms: List<String?>? = listOf(),
	@Json(name = "type") val type: String? = "", // Manga
	@Json(name = "chapters") val chapters: Int? = 0, // 96
	@Json(name = "volumes") val volumes: Int? = 0, // 24
	@Json(name = "status") val status: String? = "", // Publishing
	@Json(name = "publishing") val publishing: Boolean? = false, // true
	@Json(name = "published") val published: Published? = Published(),
	@Json(name = "score") val score: Double? = 0.0, // 9.47
	@Json(name = "scored") val scored: Double? = 0.0, // 9.47
	@Json(name = "scored_by") val scoredBy: Int? = 0, // 358728
	@Json(name = "rank") val rank: Int? = 0, // 1
	@Json(name = "popularity") val popularity: Int? = 0, // 1
	@Json(name = "members") val members: Int? = 0, // 715809
	@Json(name = "favorites") val favorites: Int? = 0, // 129170
	@Json(name = "synopsis") val synopsis: String? = "", // Guts, a former mercenary now known as the Black Swordsman, is out for revenge. After a tumultuous childhood, he finally finds someone he respects and believes he can trust, only to have everything fall apart when this person takes away everything important to Guts for the purpose of fulfilling his own desires. Now marked for death, Guts becomes condemned to a fate in which he is relentlessly pursued by demonic beings. Setting out on a dreadful quest riddled with misfortune, Guts, armed with a massive sword and monstrous strength, will let nothing stop him, not even death itself, until he is finally able to take the head of the one who stripped him—and his loved one—of their humanity. [Written by MAL Rewrite] Included one-shot: Volume 14: Berserk: The Prototype
	@Json(name = "background") val background: String? = "", // Berserk won the Excellence Award at the sixth Tezuka Osamu Cultural Prize in 2002. As of September 2023, over 60 million copies of the manga are in circulation. The series has been published in English by Dark Horse Comics since November 4, 2003. It has also been released in Argentina, Brazil, Czech Republic, France, Germany, Greece, Hong Kong, Italy, México, Poland, South Korea, Spain, Taiwan, Thailand, and Turkey. In May 2021, the author Kentaro Miura suddenly died at the age of 54. Chapter 364 of Berserk was published posthumously on September 10, 2021. Miura would often share details about the series' story with his childhood friend and fellow mangaka Kouji Mori. The series resumed on June 24, 2022, with Studio Gaga handling the art and Kouji Mori's supervision.
	@Json(name = "authors") val authors: List<Author?>? = listOf(),
	@Json(name = "serializations") val serializations: List<Serialization?>? = listOf(),
	@Json(name = "genres") val genres: List<Genre?>? = listOf(),
	@Json(name = "explicit_genres") val explicitGenres: List<Any?>? = listOf(),
	@Json(name = "themes") val themes: List<Theme?>? = listOf(),
	@Json(name = "demographics") val demographics: List<Demographic?>? = listOf()
) {
	@JsonClass(generateAdapter = true)
	data class Published(
		@Json(name = "from") val from: String? = "", // 1989-08-25T00:00:00+00:00
		@Json(name = "to") val to: String? = "", // 2011-04-19T00:00:00+00:00
		@Json(name = "prop") val prop: Prop? = Prop(),
		@Json(name = "string") val string: String? = "" // Aug 25, 1989 to ?
	) {
		@JsonClass(generateAdapter = true)
		data class Prop(
			@Json(name = "from") val from: From? = From(),
			@Json(name = "to") val to: To? = To()
		) {
			@JsonClass(generateAdapter = true)
			data class From(
				@Json(name = "day") val day: Int? = 0, // 25
				@Json(name = "month") val month: Int? = 0, // 8
				@Json(name = "year") val year: Int? = 0 // 1989
			)
			
			@JsonClass(generateAdapter = true)
			data class To(
				@Json(name = "day") val day: Int? = 0, // 19
				@Json(name = "month") val month: Int? = 0, // 4
				@Json(name = "year") val year: Int? = 0 // 2011
			)
		}
	}
	
	@JsonClass(generateAdapter = true)
	data class Author(
		@Json(name = "mal_id") val malId: Int? = 0, // 1868
		@Json(name = "type") val type: String? = "", // people
		@Json(name = "name") val name: String? = "", // Miura, Kentarou
		@Json(name = "url") val url: String? = "" // https://myanimelist.net/people/1868/Kentarou_Miura
	)
	
	@JsonClass(generateAdapter = true)
	data class Serialization(
		@Json(name = "mal_id") val malId: Int? = 0, // 2
		@Json(name = "type") val type: String? = "", // manga
		@Json(name = "name") val name: String? = "", // Young Animal
		@Json(name = "url") val url: String? = "" // https://myanimelist.net/manga/magazine/2/Young_Animal
	)
}