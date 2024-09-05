package com.nasa.practise2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasa.practise2.model.CountryItem
import com.nasa.practise2.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        getPosts()
    }

    fun getPosts() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = repository.fetchPosts()
            _uiState.value = if (result.isSuccess) {
                UiState.Success(result.getOrDefault(emptyList()))
            } else {
                UiState.Error(result.exceptionOrNull()?.localizedMessage ?: "Unknown error")
            }
        }
    }

}

sealed class UiState {
    object Loading : UiState()
    data class Success(val posts: List<CountryItem>) : UiState()
    data class Error(val message: String) : UiState()
}