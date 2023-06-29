package ir.reza_mahmoudi.githubusers.feature_user_details.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ir.reza_mahmoudi.githubusers.core.util.network.ApiResult
import ir.reza_mahmoudi.githubusers.core.util.network.data
import ir.reza_mahmoudi.githubusers.core.util.view.hide
import ir.reza_mahmoudi.githubusers.core.util.view.show
import ir.reza_mahmoudi.githubusers.databinding.FragmentUserDetailsBinding
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.model.UserDetails
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserDetailsViewModel by viewModels()
    private val args: UserDetailsFragmentArgs by navArgs()

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
                        showLoading()
                    }
                    is ApiResult.Success -> {
                        showContent(it.data)
                    }
                    is ApiResult.ServerError -> {
                        showError(message = it.errorBody.message ?: "Unexpected Error Happened")
                    }
                    is ApiResult.Error -> {
                        showError(message = it.exception.message ?: "Unexpected Error Happened")
                    }
                    else -> {}
                }
            }
        }
    }

    private fun initViews() {
        args.username?.let {
            viewModel.getUserDetails(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun showLoading() {
        with(binding) {
            details.root.hide()
            txtErrorMessage.hide()
            prbLoading.show()
        }
    }

    private fun showError(message: String) {
        with(binding) {
            prbLoading.hide()
            details.root.hide()
            txtErrorMessage.show()
            txtErrorMessage.text = message
        }
    }

    private fun showContent(userDetails: UserDetails) {
        with(binding) {
            prbLoading.hide()
            txtErrorMessage.hide()
            details.root.show()
            details.userDetails= userDetails
        }
    }
}