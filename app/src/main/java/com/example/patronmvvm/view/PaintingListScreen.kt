package com.example.patronmvvm.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.patronmvvm.model.Painting
import com.example.patronmvvm.view_model.PaintingViewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun PaintingListScreen(viewModel: PaintingViewModel) {
    val paintings by viewModel.paintings.collectAsState()
    val selectedPainting by viewModel.selectedPainting.collectAsState()

    Column {
        PaintingList(paintings, onItemClick = { viewModel.selectPainting(it) })
        selectedPainting?.let {

        }
    }
}
@Composable
fun PaintingList(paintings: List<Painting>, onItemClick: (Painting) -> Unit) {
    LazyColumn {
        items(paintings) { painting ->
            PaintingItem(painting, onClick = { onItemClick(painting) })
        }
    }
}


@Composable
fun PaintingItem(painting: Painting, onClick: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(painting.imageUrl),
            contentDescription = painting.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = painting.title, style = MaterialTheme.typography.titleMedium)
            Text(text = painting.artist, style = MaterialTheme.typography.bodyMedium)
        }
    }
}


