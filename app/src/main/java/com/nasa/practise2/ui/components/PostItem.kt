package com.nasa.practise2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nasa.practise2.model.CountryItem

@Composable
fun PostItem(post: CountryItem, onPostClick: (CountryItem) -> Unit) {
    Column(modifier = Modifier
        .clickable { onPostClick(post) }
        .padding(16.dp)) {
        Text(text = post.name, style = MaterialTheme.typography.bodyMedium)
        Text(text = post.capital ?: "NA", style = MaterialTheme.typography.bodySmall)

    }
}