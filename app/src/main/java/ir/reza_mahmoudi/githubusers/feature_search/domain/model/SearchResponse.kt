package ir.reza_mahmoudi.githubusers.feature_search.domain.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("items")
    val users: List<User>,
    @SerializedName("total_count")
    val totalCount: Int? = null,
)