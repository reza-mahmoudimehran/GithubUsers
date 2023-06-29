package ir.reza_mahmoudi.githubusers.feature_user_details.data.remote

import ir.reza_mahmoudi.githubusers.core.data.local.GithubApi
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails
import retrofit2.Response
import javax.inject.Inject

class UserDetailsRemoteDataSourceImpl @Inject constructor(
    private val githubApi: GithubApi
) : UserDetailsRemoteDataSource {
    override suspend fun getUserDetails(username: String): Response<UserDetails> =
        githubApi.getUserDetails(username = username)
}