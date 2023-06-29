package ir.reza_mahmoudi.githubusers.feature_user_details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import ir.reza_mahmoudi.githubusers.core.util.network.ApiResult
import ir.reza_mahmoudi.githubusers.databinding.FragmentUserDetailsBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserDetailsFragment : Fragment() {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        collectData()
    }

    private fun collectData() {
        lifecycleScope.launch {
            viewModel.userDetails.collectLatest {
                when (it) {
                    is ApiResult.Loading -> {
//                        showLoading()
                    }
                    is ApiResult.Success -> {
//                        showContent(it.data.users)
                    }
                    is ApiResult.ServerError -> {
//                        showError(message = it.errorBody.message ?: "Unexpected Error Happened")
                    }
                    is ApiResult.Error -> {
//                        showError(message = it.exception.message ?: "Unexpected Error Happened")
                    }
                    else -> {}
                }
            }
        }
    }

    private fun initViews() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}