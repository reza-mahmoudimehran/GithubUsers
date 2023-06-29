package ir.reza_mahmoudi.githubusers.feature_user_details.data.remote

import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails
import retrofit2.Response

interface UserDetailsRemoteDataSource {
    suspend fun getUserDetails(username: String): Response<UserDetails>
}