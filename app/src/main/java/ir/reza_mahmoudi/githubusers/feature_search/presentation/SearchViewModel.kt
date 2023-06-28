package ir.reza_mahmoudi.githubusers.feature_search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.reza_mahmoudi.githubusers.core.util.network.ApiResult
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.SearchResponse
import ir.reza_mahmoudi.githubusers.feature_search.domain.usecase.SearchUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUserUseCase: SearchUserUseCase
) : ViewModel() {

    private val _searchResult = MutableStateFlow<ApiResult<SearchResponse>>(ApiResult.Init)
    val searchResult: StateFlow<ApiResult<SearchResponse>> = _searchResult

    fun searchUser(username: String) {
        _searchResult.value = ApiResult.Loading
        viewModelScope.launch {
            _searchResult.value = searchUserUseCase(username)
        }
    }
}