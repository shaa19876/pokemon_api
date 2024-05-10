package ru.shaa.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vk.presentation.detail.DetailScreen
import com.vk.presentation.detail.DetailViewModel
import com.vk.presentation.main.MainScreen
import com.vk.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import ru.shaa.pokemon.ui.theme.PokemonTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val mainViewModel: MainViewModel by viewModels()
  private val detailViewModel:DetailViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
      PokemonTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          NavHost(navController = navController, startDestination = "mainScreen") {
            composable("mainScreen") {
              MainScreen(mainViewModel, navController)
            }
            composable(
              route = "detailScreen?name={name}",
              arguments = listOf(
                navArgument("name") { type = NavType.StringType }
              )
            ) { navBackStackEntry ->
              val name = navBackStackEntry.arguments!!.getString("name")!!
              DetailScreen(detailViewModel, name = name)
            }
          }
        }
      }
    }
  }
}