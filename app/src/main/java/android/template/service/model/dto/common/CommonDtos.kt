package android.template.service.model.dto.common

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Images(
	@Json(name = "jpg") val jpg: Jpg? = Jpg(),
	@Json(name = "webp") val webp: Webp? = Webp()
) {
	@JsonClass(generateAdapter = true)
	data class Jpg(
		@Json(name = "image_url") val imageUrl: String? = "", // https://cdn.myanimelist.net/images/manga/1/157897.jpg
		@Json(name = "small_image_url") val smallImageUrl: String? = "", // https://cdn.myanimelist.net/images/manga/1/157897t.jpg
		@Json(name = "large_image_url") val largeImageUrl: String? = "" // https://cdn.myanimelist.net/images/manga/1/157897l.jpg
	)
	
	@JsonClass(generateAdapter = true)
	data class Webp(
		@Json(name = "image_url") val imageUrl: String? = "", // https://cdn.myanimelist.net/images/manga/1/157897.webp
		@Json(name = "small_image_url") val smallImageUrl: String? = "", // https://cdn.myanimelist.net/images/manga/1/157897t.webp
		@Json(name = "large_image_url") val largeImageUrl: String? = "" // https://cdn.myanimelist.net/images/manga/1/157897l.webp
	)
}

@JsonClass(generateAdapter = true)
data class Title(
	@Json(name = "type") val type: String? = "", // Default
	@Json(name = "title") val title: String? = "" // Berserk
)

@JsonClass(generateAdapter = true)
data class Genre(
	@Json(name = "mal_id") val malId: Int? = 0, // 1
	@Json(name = "type") val type: String? = "", // manga
	@Json(name = "name") val name: String? = "", // Action
	@Json(name = "url") val url: String? = "" // https://myanimelist.net/manga/genre/1/Action
)

@JsonClass(generateAdapter = true)
data class Theme(
	@Json(name = "mal_id") val malId: Int? = 0, // 58
	@Json(name = "type") val type: String? = "", // manga
	@Json(name = "name") val name: String? = "", // Gore
	@Json(name = "url") val url: String? = "" // https://myanimelist.net/manga/genre/58/Gore
)

@JsonClass(generateAdapter = true)
data class Demographic(
	@Json(name = "mal_id") val malId: Int? = 0, // 41
	@Json(name = "type") val type: String? = "", // manga
	@Json(name = "name") val name: String? = "", // Seinen
	@Json(name = "url") val url: String? = "" // https://myanimelist.net/manga/genre/41/Seinen
)