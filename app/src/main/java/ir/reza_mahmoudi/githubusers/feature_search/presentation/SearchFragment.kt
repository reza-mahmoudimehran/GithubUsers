package ir.reza_mahmoudi.githubusers.feature_search.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.reza_mahmoudi.githubusers.core.util.network.ApiResult
import ir.reza_mahmoudi.githubusers.core.util.network.data
import ir.reza_mahmoudi.githubusers.core.util.view.hide
import ir.reza_mahmoudi.githubusers.core.util.view.show
import ir.reza_mahmoudi.githubusers.databinding.FragmentSearchBinding
import ir.reza_mahmoudi.githubusers.feature_search.domain.model.User
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var usersAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        collectData()
    }

    private fun collectData() {
        lifecycleScope.launch {
            viewModel.searchResult.collectLatest {
                when (it) {
                    is ApiResult.Loading -> {
                        showLoading()
                    }
                    is ApiResult.Success -> {
                        showContent(it.data.users)
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
        binding.btnSearch.setOnClickListener {
            viewModel.searchUser(binding.edtSearch.text.toString())
        }

        usersAdapter = UserListAdapter {

        }

        binding.rcvUsersList.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            adapter = usersAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun showLoading() {
        with(binding) {
            rcvUsersList.hide()
            txtErrorMessage.hide()
            prbLoading.show()
        }
    }

    private fun showError(message: String) {
        with(binding) {
            prbLoading.hide()
            rcvUsersList.hide()
            txtErrorMessage.show()
            txtErrorMessage.text = message
        }
    }

    private fun showContent(moviesList: List<User>?) {
        with(binding) {
            if (moviesList.isNullOrEmpty()) {
                showError("Empty Result")
            } else {
                prbLoading.hide()
                txtErrorMessage.hide()
                rcvUsersList.show()
                usersAdapter.submitList(moviesList)
            }
        }
    }
}