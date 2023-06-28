package ir.reza_mahmoudi.githubusers.feature_search.domain

import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import retrofit2.Response

interface SearchRepository {
    suspend fun searchUser(username: String): Response<SearchResponse>
}