package com.example.roomtesting.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.handleState.ConnectionError
import com.example.domain.handleState.ServerError

open class BaseViewModel : ViewModel() {
    private val _uiMessage = MutableLiveData<UIMessages>()
    val uiMessage: MutableLiveData<UIMessages> get() = _uiMessage

    fun handleError(message: String){
        _uiMessage.postValue(UIMessages(message))
    }

    fun handleError(throwable: Throwable){
        val errorMessage = when (throwable) {
            is ConnectionError-> "No internet connection"
            is ServerError -> "Server error"
            else -> throwable.message?: "Unknown error"
        }
        _uiMessage.postValue(UIMessages(errorMessage))
    }
}