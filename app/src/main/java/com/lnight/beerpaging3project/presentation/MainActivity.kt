package com.lnight.beerpaging3project.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lnight.beerpaging3project.presentation.beer_list.BeerListScreen
import com.lnight.beerpaging3project.presentation.beer_list.BeerListViewModel
import com.lnight.beerpaging3project.presentation.ui.theme.BeerPaging3ProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BeerPaging3ProjectTheme {
                val systemUiController = rememberSystemUiController()
                val darkColors = !isSystemInDarkTheme()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        Color.Transparent,
                        darkColors
                    )
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<BeerListViewModel>()
                    val beers = viewModel.beerPagingFlow.collectAsLazyPagingItems()

                    BeerListScreen(
                        beers = beers
                    )
                }
            }
        }
    }
}