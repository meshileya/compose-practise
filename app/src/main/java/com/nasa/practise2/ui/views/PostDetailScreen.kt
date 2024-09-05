package com.nasa.practise2.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nasa.practise2.model.CountryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDetailScreen(navController: NavController, countryName: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Post Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
                countryName?.let {
                    Text(
                        text = "Details for $countryName",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    )
}