package ir.reza_mahmoudi.githubusers.feature_search.util.test_data

import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.User

const val SEARCH_USER_NAME = "Reza"

val SEARCH_RESPONSE_FAKE_DATA = SearchResponse(
    listOf(
        User(
            id = 1,
            login = "Reza1"
        ),
        User(
            id = 2,
            login = "Reza2"
        ),
        User(
            id = 3,
            login = "Reza3"
        ),
    ),
    3
)