package com.example.pixabaytestapp.presentation.ui

import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.fragment.findNavController
import com.example.pixabaytestapp.databinding.FragmentPlayerBinding
import com.example.pixabaytestapp.domain.models.VideoEntity
import com.example.pixabaytestapp.presentation.viewmodels.PlayerViewModel
import dagger.hilt.android.AndroidEntryPoint

const val SDK_TIRAMISU = Build.VERSION_CODES.TIRAMISU

@AndroidEntryPoint
class PlayerFragment: Fragment() {

    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PlayerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val video = if (VERSION.SDK_INT >= SDK_TIRAMISU) {
            requireArguments().getParcelable(VIDEO, VideoEntity::class.java)
        } else {
            @Suppress("DEPRECATION")
            requireArguments().getParcelable(VIDEO)
        }

        if (video == null) {
            findNavController().popBackStack()
            return
        }

        binding.tvTags.text = video.tags


        binding.playerView.player = viewModel.getPlayer()

        viewModel.initPlayer(video.small.url)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.releasePlayer()
    }

    companion object {
        private const val VIDEO = "VIDEO"

        fun createArgs(video: VideoEntity): Bundle = bundleOf(VIDEO to video)
    }

}