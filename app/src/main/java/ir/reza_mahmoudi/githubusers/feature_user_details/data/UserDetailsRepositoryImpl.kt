package ir.reza_mahmoudi.githubusers.feature_user_details.data

import ir.reza_mahmoudi.githubusers.feature_user_details.data.remote.UserDetailsRemoteDataSource
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.UserDetailsRepository
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails
import retrofit2.Response
import javax.inject.Inject

class UserDetailsRepositoryImpl @Inject constructor(
    private val userDetailsRemoteDataSource: UserDetailsRemoteDataSource
) : UserDetailsRepository {
    override suspend fun getUserDetails(username: String): Response<UserDetails> =
        userDetailsRemoteDataSource.getUserDetails(username = username)
}