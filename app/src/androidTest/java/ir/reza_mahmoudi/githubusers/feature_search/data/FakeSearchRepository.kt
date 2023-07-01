package ir.reza_mahmoudi.githubusers.feature_search.data

import ir.reza_mahmoudi.githubusers.feature_search.domain.SearchRepository
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import ir.reza_mahmoudi.githubusers.feature_search.util.test_data.SEARCH_RESPONSE_FAKE_DATA
import retrofit2.Response
import javax.inject.Inject

class FakeSearchRepository @Inject constructor() : SearchRepository {

    private val searchResponse = SEARCH_RESPONSE_FAKE_DATA

    override suspend fun searchUser(username: String): Response<SearchResponse> {
        val searchedResult = searchResponse.copy(
            users = searchResponse.users.filter { user -> user.login?.contains(username) ?: false }
        )
        return Response.success(searchedResult)
    }

}