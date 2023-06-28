package ir.reza_mahmoudi.githubusers.feature_search.domain.usecase

import ir.reza_mahmoudi.githubusers.core.di.qualifiers.IoDispatcher
import ir.reza_mahmoudi.githubusers.core.domain.usecase.ApiUseCase
import ir.reza_mahmoudi.githubusers.feature_search.domain.SearchRepository
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Response
import javax.inject.Inject

class SearchUserUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : ApiUseCase<String, SearchResponse>(ioDispatcher) {
    override suspend fun execute(parameters: String): Response<SearchResponse> =
        searchRepository.searchUser(parameters)
}