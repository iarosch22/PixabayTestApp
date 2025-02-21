package com.example.pixabaytestapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pixabaytestapp.databinding.FragmentVideosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment: Fragment() {

    private var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

}