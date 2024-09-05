package com.nasa.practise2.repository

import com.nasa.practise2.model.CountryItem
import com.nasa.practise2.network.ApiService

class PostRepository(private val apiService: ApiService) {
    suspend fun fetchPosts(): Result<List<CountryItem>> {
        return try {
            val response = apiService.getPosts()
            Result.success(response)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Result.failure(ex)
        }
    }
}