package android.template.core.service.dto
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class BaseResponseDto<T>(
    @Json(name = "pagination") val pagination: Pagination? = Pagination(),
    @Json(name = "data") val data: List<T?>? = listOf()  // Use generics here
) {
    @JsonClass(generateAdapter = true)
    data class Pagination(
        @Json(name = "last_visible_page") val lastVisiblePage: Int? = 0, // 2880
        @Json(name = "has_next_page") val hasNextPage: Boolean? = false, // true
        @Json(name = "current_page") val currentPage: Int? = 0, // 1
        @Json(name = "items") val items: Items? = Items()
    ) {
        @JsonClass(generateAdapter = true)
        data class Items(
            @Json(name = "count") val count: Int? = 0, // 25
            @Json(name = "total") val total: Int? = 0, // 71998
            @Json(name = "per_page") val perPage: Int? = 0 // 25
        )
    }
}