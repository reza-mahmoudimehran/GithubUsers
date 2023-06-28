package ir.reza_mahmoudi.githubusers.feature_search.data

import ir.reza_mahmoudi.githubusers.feature_search.data.remote.SearchRemoteDataSource
import ir.reza_mahmoudi.githubusers.feature_search.domain.SearchRepository
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import retrofit2.Response
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : SearchRepository {
    override suspend fun searchUser(username: String): Response<SearchResponse> =
        searchRemoteDataSource.searchUser(username = username)
}