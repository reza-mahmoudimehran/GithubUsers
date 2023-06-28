package ir.reza_mahmoudi.githubusers.core.domain.usecase

import ir.reza_mahmoudi.githubusers.core.util.network.ApiResult
import ir.reza_mahmoudi.githubusers.core.util.network.wrapToGeneralError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class ApiUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /** Executes the use case asynchronously and returns a [ApiResult].
     *
     * @return a [ApiResult].
     *
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): ApiResult<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    if (it.isSuccessful) {
                        ApiResult.Success(it.body()!!)
                    } else {
                        it.errorBody().use { responseBody ->
                            responseBody?.string().wrapToGeneralError()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            ApiResult.Error(e)
        }
    }

    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): Response<R>
}
