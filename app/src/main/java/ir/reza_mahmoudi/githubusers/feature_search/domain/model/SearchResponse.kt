package ir.reza_mahmoudi.githubusers.feature_search.domain.model

import com.squareup.moshi.Json

data class SearchResponse(
    @Json(name = "items")
    val users: List<User>,
    @Json(name = "total_count")
    val totalCount: Int? = null,
)