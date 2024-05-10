package com.vk.presentation.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.vk.domain.models.DetailPokemon
import com.vk.presentation.R
import okhttp3.internal.format

@Composable
fun DetailScreen(vm: DetailViewModel, name: String) {

    LaunchedEffect(Unit) {
        vm.load(name)
    }

    val state = vm.state.collectAsState()

    when (val currentState = state.value) {
        is State.Loading -> DrawLoading()
        is State.Error -> DrawError { vm.load(name) }
        is State.Success<*> -> DrawDetailScreen(currentState.data as DetailPokemon)
        else -> {}
    }
}

@Composable
fun DrawDetailScreen(detailPokemon: DetailPokemon) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        with(detailPokemon) {
            TitleSection(title = name)
            ImageSection(image = imageUrl)
            TypeSection(type = types)
            ContentSection(
                height = height,
                weight = weight,
                baseExperience = baseExperience,
                abilities = abilities
            )
        }
    }
}

@Composable
fun TitleSection(title: String) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun TypeSection(type: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        type.forEach {
            Card(
                modifier = Modifier
                    .padding(5.dp),
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer)
            ) {
                Text(
                    text = it,
                    modifier = Modifier
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
fun ImageSection(image: String) {

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer)
    ) {
        SubcomposeAsyncImage(
            model = image,
            loading = { CircularProgressIndicator() },
            error = {
                Image(
                    painter = painterResource(id = R.drawable.no_image),
                    contentDescription = null
                )
            },
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ContentSection(height: Int, weight: Int, baseExperience: Int, abilities: List<String>) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(Modifier.padding(5.dp)) {
            Text(text = format("Base experience: %3d", baseExperience))
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = format("Height: %3d", height))
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = format("Weight: %3d", weight))
            Spacer(modifier = Modifier.size(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Abilities: ")
                Column {
                    abilities.forEach {
                        Text(text = it)
                    }
                }
            }
        }
    }
}

@Composable
fun DrawLoading() {
    Box(Modifier.padding(10.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun DrawError(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cannot loading data from network",
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.error),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onError
        )
        Button(onClick = onClick) {
            Text(text = "Try again")
        }
    }
}