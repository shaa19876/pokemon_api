package com.vk.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import com.vk.domain.models.Pokemon
import com.vk.presentation.R

@Composable
fun MainScreen(vm: MainViewModel, navController: NavHostController) {

    val pokemons = vm.data.collectAsLazyPagingItems()

    LazyColumn(
        Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(pokemons.itemCount) { index ->
            pokemons[index]?.let { ProductItem(it, navController) }
        }
        item {
            when (pokemons.loadState.refresh) {
                is LoadState.Error -> DrawError { vm.load() }
                is LoadState.Loading -> DrawLoading()
                is LoadState.NotLoading -> {}
            }
        }
    }
}

@Composable
private fun DrawLoading() {
    Box(Modifier.padding(10.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun DrawError(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.error),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Cannot loading data from network",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onError
        )
    }
    Button(onClick = onClick) {
        Text(text = "Try again")
    }
}

@Composable
private fun ProductItem(pokemon: Pokemon, navController: NavHostController) {
    Card(
        onClick = { navController.navigate("detailScreen?name=${pokemon.name}") },
        Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row {
            Column(Modifier.padding(10.dp)) {
                SubcomposeAsyncImage(
                    model = pokemon.imageUrl,
                    loading = { CircularProgressIndicator() },
                    error = {
                        Image(
                            painter = painterResource(id = R.drawable.no_image),
                            contentDescription = null
                        )
                    },
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()) {
                Text(
                    text = pokemon.name.replaceFirstChar { it.uppercase() },
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = pokemon.id,
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
    }
}

