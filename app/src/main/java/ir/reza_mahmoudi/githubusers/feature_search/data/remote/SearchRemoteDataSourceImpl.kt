package ir.reza_mahmoudi.githubusers.feature_search.data.remote

import ir.reza_mahmoudi.githubusers.core.data.local.GithubApi
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import retrofit2.Response
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    private val githubApi: GithubApi
) : SearchRemoteDataSource {
    override suspend fun searchUser(username: String): Response<SearchResponse> =
        githubApi.searchUser(username = username)
}