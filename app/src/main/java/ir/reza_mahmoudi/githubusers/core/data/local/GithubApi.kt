package ir.reza_mahmoudi.githubusers.core.data.local

import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/users")
    suspend fun searchUser(@Query("q") username: String): Response<SearchResponse>

    @GET("/users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): Response<UserDetails>
}