package com.example.pixabaytestapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pixabaytestapp.R
import com.example.pixabaytestapp.databinding.FragmentVideosBinding
import com.example.pixabaytestapp.domain.models.VideoEntity
import com.example.pixabaytestapp.presentation.OnVideoClickListener
import com.example.pixabaytestapp.presentation.viewmodels.VideosState
import com.example.pixabaytestapp.presentation.viewmodels.VideosViewModel
import com.example.pixabaytestapp.utils.ErrorType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment: Fragment() {

    private var isClickAllowed = true

    private var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { VideosAdapter(createVideoListener()) }

    private val viewModel: VideosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvVideos.adapter = adapter

        binding.swipeRefresh.setOnRefreshListener {
                viewModel.getVideos()
        }

        viewModel.observeState().observe(viewLifecycleOwner) {
            when(it) {
                is VideosState.Content -> showContent(it.videos)
                is VideosState.Error -> showError(it.errorType)
                VideosState.Loading -> showLoading()
            }
        }
    }

    private fun showContent(foundedVideos: List<VideoEntity>) {
        binding.swipeRefresh.isRefreshing = false
        binding.progressBar.visibility = View.GONE
        binding.rvVideos.visibility = View.VISIBLE

        adapter.videos.clear()
        adapter.videos.addAll(foundedVideos)
        adapter.notifyDataSetChanged()
    }

    private fun showLoading() {
        if (!binding.swipeRefresh.isRefreshing) {
            binding.progressBar.visibility = View.VISIBLE
            binding.rvVideos.visibility = View.GONE
        }
    }

    private fun showError(errorType: ErrorType) {
        binding.swipeRefresh.isRefreshing = false
        when(errorType) {
            ErrorType.NETWORK_ERROR -> {
                binding.tvErrorMessage.text = getString(R.string.app_error_network)
            }
            ErrorType.DATABASE_ERROR -> {
                binding.tvErrorMessage.text = getString(R.string.app_error_database)
            }
            ErrorType.REQUEST_ERROR -> {
                binding.tvErrorMessage.text = getString(R.string.app_error_request)
            }
            ErrorType.UNKNOWN_ERROR -> {
                binding.tvErrorMessage.text = getString(R.string.app_error_unknown)
            }
        }

        binding.progressBar.visibility = View.GONE
        binding.rvVideos.visibility = View.GONE
        binding.tvErrorMessage.visibility = View.VISIBLE
    }

    private fun createVideoListener(): OnVideoClickListener {
        return  OnVideoClickListener { video: VideoEntity ->
            findNavController().navigate(
                R.id.action_videosFragment_to_playerFragment,
                PlayerFragment.createArgs(video)
            )
        }
    }

    companion object {
        private const val VIDEO = "VIDEO"
        private const val CLICK_DEBOUNCE_DELAY_MILLIS = 1000L
    }

}