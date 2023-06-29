package ir.reza_mahmoudi.githubusers.feature_user_details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.reza_mahmoudi.githubusers.core.util.network.ApiResult
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.usecase.GetUserDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase
) : ViewModel() {

    private val _userDetails = MutableStateFlow<ApiResult<UserDetails>>(ApiResult.Init)
    val userDetails: StateFlow<ApiResult<UserDetails>>
        get() = _userDetails

    fun getUserDetails(username: String) {
        _userDetails.value = ApiResult.Loading

        viewModelScope.launch {
            _userDetails.value = getUserDetailsUseCase(username)
        }
    }
}