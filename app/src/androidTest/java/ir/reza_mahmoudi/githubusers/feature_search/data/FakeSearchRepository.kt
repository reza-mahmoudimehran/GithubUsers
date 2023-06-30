package ir.reza_mahmoudi.githubusers.feature_search.data

import ir.reza_mahmoudi.githubusers.feature_search.domain.SearchRepository
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import ir.reza_mahmoudi.githubusers.feature_search.util.test_data.SEARCH_RESPONSE_FAKE_DATA
import retrofit2.Response
import javax.inject.Inject

class FakeSearchRepository @Inject constructor(): SearchRepository {

    override suspend fun searchUser(username: String): Response<SearchResponse> =
        Response.success(SEARCH_RESPONSE_FAKE_DATA)

}