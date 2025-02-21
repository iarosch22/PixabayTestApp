package com.example.pixabaytestapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaytestapp.domain.PixabayInteractor
import com.example.pixabaytestapp.domain.models.VideoEntity
import com.example.pixabaytestapp.utils.ErrorType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(private val pixabayInteractor: PixabayInteractor): ViewModel() {

    private val stateLiveData = MutableLiveData<VideosState>(VideosState.Loading)
    fun observeState(): LiveData<VideosState> = stateLiveData

    init {
        getVideos()
    }

    private fun getVideos() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                pixabayInteractor
                    .getVideos(1, 15)
                    .collect{ searchResults ->
                        processResults(searchResults.videos, searchResults.errorType)
                    }
            } catch (e: Throwable) {
                processResults(null, ErrorType.UNKNOWN_ERROR)
            }
        }
    }

    private fun processResults(foundedVideos: List<VideoEntity>?, errorType: ErrorType?) {
        val videos = mutableListOf<VideoEntity>()

        if (foundedVideos != null) videos.addAll(foundedVideos)

        when {
            errorType != null -> renderState(VideosState.Error(errorType))
            else -> renderState(VideosState.Content(videos = videos))
        }
    }

    private fun renderState(state: VideosState) {
        stateLiveData.postValue(state)
    }

}