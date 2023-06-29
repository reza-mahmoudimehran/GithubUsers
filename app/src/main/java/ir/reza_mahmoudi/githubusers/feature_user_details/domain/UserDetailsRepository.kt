package ir.reza_mahmoudi.githubusers.feature_user_details.domain

import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails
import retrofit2.Response

interface UserDetailsRepository {
    suspend fun getUserDetails(username: String): Response<UserDetails>
}