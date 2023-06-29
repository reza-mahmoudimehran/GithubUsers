package ir.reza_mahmoudi.githubusers.feature_user_details.domain.usecase

import ir.reza_mahmoudi.githubusers.core.di.qualifiers.IoDispatcher
import ir.reza_mahmoudi.githubusers.core.domain.usecase.ApiUseCase
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.UserDetailsRepository
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Response
import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
    private val userDetailsRepository: UserDetailsRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : ApiUseCase<String, UserDetails>(ioDispatcher) {
    override suspend fun execute(parameters: String): Response<UserDetails> =
        userDetailsRepository.getUserDetails(parameters)
}