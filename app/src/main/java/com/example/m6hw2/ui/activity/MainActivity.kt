package com.example.m6hw2.ui.activity

import android.os.Bundle
import com.example.m6hw2.ui.screens.MainScreen
import com.example.m6hw2.ui.screens.Screens
import com.example.m6hw2.ui.screens.detail.DetailScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.m6hw2.ui.theme.M6HW2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }

    }

}

class CustomNavController {
    private val _backStack = mutableStateListOf<Screens>()
    val currentScreen: State<Screens?>
        get() = derivedStateOf { _backStack.lastOrNull() }

    fun navigate(screen: Screens) {
        _backStack.add(screen)
    }

    @RequiresApi(35)
    fun popBackStack() {
        if (_backStack.isNotEmpty()) {
            _backStack.removeLast()
        }
    }
}

@Composable
fun rememberCustomNavController(): CustomNavController {
    return remember { CustomNavController() }
}

@Composable
fun MyApp() {
    val navController = rememberCustomNavController()


    when (val screen = navController.currentScreen.value) {
        is Screens.Main -> MainScreen (navController)
        is Screens.Detail -> DetailScreen(navController, screen.book)
        null -> navController.navigate(Screens.Main)
    }
}