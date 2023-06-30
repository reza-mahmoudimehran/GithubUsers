package ir.reza_mahmoudi.githubusers.feature_search.util.test_data

import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.User

const val SEARCH_USER_NAME = "reza"

val SEARCH_RESPONSE_FAKE_DATA = SearchResponse(
    listOf(
        User(
            id = 507391,
            login = "reza",
            avatarUrl = "https://avatars.githubusercontent.com/u/507391?v=4",
        ),
        User(
            id = 555207,
            login = "rezaali",
            avatarUrl = "https://avatars.githubusercontent.com/u/555207?v=4",
        ),
        User(
            id = 5187816,
            login = "reshadman",
            avatarUrl = "https://avatars.githubusercontent.com/u/5187816?v=4",
        ),
    ),
    3
)