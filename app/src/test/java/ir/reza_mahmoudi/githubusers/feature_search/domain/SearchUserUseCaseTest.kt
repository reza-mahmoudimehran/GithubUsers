package ir.reza_mahmoudi.githubusers.feature_search.domain

import com.google.common.truth.Truth.assertThat
import ir.reza_mahmoudi.githubusers.core.util.network.ApiResult
import ir.reza_mahmoudi.githubusers.core.util.network.data
import ir.reza_mahmoudi.githubusers.feature_search.domain.usecase.SearchUserUseCase
import ir.reza_mahmoudi.githubusers.feature_search.util.test_data.SEARCH_RESPONSE_FAKE_DATA
import ir.reza_mahmoudi.githubusers.feature_search.util.test_data.SEARCH_USER_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchUserUseCaseTest {

    private val testDispatcher: TestDispatcher by lazy { StandardTestDispatcher() }

    @Mock
    private lateinit var mockSearchRepository: SearchRepository

    private lateinit var searchUserUseCase: SearchUserUseCase


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        searchUserUseCase =
            SearchUserUseCase(mockSearchRepository, testDispatcher)
    }


    @After
    fun cleanup() {
        Dispatchers.resetMain()
    }


    @Test
    fun `when repository returns successful response, invoking the use case should return success result`() {
        runTest {

            val response = Response.success(SEARCH_RESPONSE_FAKE_DATA)
            Mockito.`when`(mockSearchRepository.searchUser(SEARCH_USER_NAME)).thenReturn(response)

            // Act
            val result = searchUserUseCase(SEARCH_USER_NAME)

            // Assert
            Assert.assertTrue(result is ApiResult.Success)
            assertThat(SEARCH_RESPONSE_FAKE_DATA).isEqualTo(result.data)
        }
    }


    @Test
    fun `when the repository throws runtime exception, then the use case should return ApiResult_Error with same exception`() {
        runTest {
            // Given
            given(mockSearchRepository.searchUser(SEARCH_USER_NAME)).willThrow(RuntimeException())

            // When
            val result = searchUserUseCase(SEARCH_USER_NAME)

            // Assert
            Assert.assertTrue(result is ApiResult.Error)
            assertThat((result as ApiResult.Error).exception).isInstanceOf(RuntimeException::class.java)
        }
    }
}