package com.example.cinematickets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cinematickets.composable.navigation.AppNavGraph
import com.example.cinematickets.composable.navigation.BottomNavScreen
import com.example.cinematickets.composable.navigation.BottomNavigationBar
import com.example.cinematickets.ui.theme.CinemaTicketsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaTicketsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val bottomBarState = checkBottomBarState(navController)
                    Scaffold(
                        Modifier.fillMaxHeight(),
                        bottomBar = {
                            BottomNavigationBar(navController, bottomBarState)
                        }
                    )
                    { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            AppNavGraph(navController)
                        }
                    }
                }
            }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
   // HomeScreen(NavHostController())
}

@Composable
private fun checkBottomBarState(navController: NavHostController): MutableState<Boolean> {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    val bottomBarScreens = listOf(
        BottomNavScreen.Home.route,
        BottomNavScreen.Search.route,
        BottomNavScreen.Tickets.route,
        BottomNavScreen.Profile.route
    )

    when (navBackStackEntry?.destination?.route) {
        in bottomBarScreens -> {
            // Show BottomBar
            bottomBarState.value = true
        }

        else -> {
            // Hide BottomBar
            bottomBarState.value = false
        }
    }
    return bottomBarState
}
