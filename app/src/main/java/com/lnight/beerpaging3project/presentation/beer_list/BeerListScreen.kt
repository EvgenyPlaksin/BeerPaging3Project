package com.lnight.beerpaging3project.presentation.beer_list

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.lnight.beerpaging3project.domain.Beer

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BeerListScreen(
    beers: LazyPagingItems<Beer>
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = beers.loadState) {
        if (beers.loadState.refresh is LoadState.Error) {
            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(title = {
            Text(
                text = "Beer Paging3 App ",
                style = MaterialTheme.typography.headlineSmall
            )
        })
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (beers.loadState.refresh is LoadState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(horizontal = 12.dp)
                ) {
                    items(
                        count = beers.itemCount,
                        key = beers.itemKey(),
                        contentType = beers.itemContentType(
                        )
                    ) { index ->
                        val beer = beers[index]
                        if (beer != null) {
                            BeerItem(
                                beer = beer,
                                Modifier.fillMaxWidth()
                            )
                        }
                    }
                    item {
                        if (beers.loadState.append is LoadState.Loading) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}