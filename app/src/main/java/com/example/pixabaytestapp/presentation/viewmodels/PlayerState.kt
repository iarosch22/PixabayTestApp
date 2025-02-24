package com.example.pixabaytestapp.presentation.viewmodels

sealed class PlayerState {

    data object Playing : PlayerState()
    data object Paused : PlayerState()

}