package com.nasa.practise2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nasa.practise2.model.CountryItem
import com.nasa.practise2.network.NetowrkUtil
import com.nasa.practise2.repository.PostRepository
import com.nasa.practise2.ui.theme.Practise2Theme
import com.nasa.practise2.ui.views.CountryDetailScreen
import com.nasa.practise2.ui.views.PostScreen
import com.nasa.practise2.viewmodel.PostViewModel

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel = PostViewModel(PostRepository(NetowrkUtil.create()))


            NavHost(navController = navController, startDestination = "posts") {
                composable("posts") {

                    PostScreen(
                        viewModel = viewModel,
                        navController = navController
                    )
                }

                composable(
                    "post_detail/{post}",
                    arguments = listOf(navArgument("post") { type = NavType.StringType })

                ) { backStackEntry ->
                    CountryDetailScreen(
                        countryName = backStackEntry.arguments?.getString("post"),
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practise2Theme {
        Greeting("Android")
    }
}