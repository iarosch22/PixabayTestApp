package com.example.pixabaytestapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pixabaytestapp.domain.PlayerInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(private val interactor: PlayerInteractor): ViewModel() {

    fun initPlayer(url: String) {
        interactor.initPlayer(url)
        interactor.play()
    }

    fun play() {
        interactor.play()
    }

    fun releasePlayer() {
        interactor.releasePlayer()
    }

    fun getPlayer() = interactor.getPlayer()
}
