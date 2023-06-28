package ir.reza_mahmoudi.githubusers.feature_search.data.remote

import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import retrofit2.Response

interface SearchRemoteDataSource {
    suspend fun searchUser(username: String): Response<SearchResponse>
}