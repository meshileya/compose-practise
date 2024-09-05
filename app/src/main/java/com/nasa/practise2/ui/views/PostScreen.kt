package com.nasa.practise2.ui.views

import android.util.Log
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.nasa.practise2.model.CountryItem
import com.nasa.practise2.ui.components.PostItem
import com.nasa.practise2.viewmodel.PostViewModel
import com.nasa.practise2.viewmodel.UiState

@Composable
fun PostScreen(navController: NavController, viewModel: PostViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading -> {
            CircularProgressIndicator(modifier = Modifier.wrapContentSize())
        }

        is UiState.Success -> {
            PostList((uiState as UiState.Success).posts) { post ->

                navController.navigate("post_detail/${post.name}")
            }
        }

        is UiState.Error -> {
//            ErrorScreen((uiState as UiState.Error).message) {
//                viewModel.getPosts() // Retry on error
//            }
        }
    }
}

@Composable
fun PostList(posts: List<CountryItem>, onPostClick: (CountryItem) -> Unit) {

    LazyColumn {
        items(items = posts) { post ->
            PostItem(post = post, onPostClick = onPostClick)
        }
    }
}