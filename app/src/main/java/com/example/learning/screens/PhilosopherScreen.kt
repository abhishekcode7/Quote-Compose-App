package com.example.learning.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learning.R
import com.example.learning.viewmodels.PhilosopherViewModel

@Composable
fun PhilosopherScreen(modifier: Modifier = Modifier, onClick: (name: String) -> Unit) {

    val philosopherViewModel: PhilosopherViewModel = hiltViewModel()
    val philosophers = philosopherViewModel._philosophers.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(philosophers.value.distinct()) {
            PhilosopherItem(name = it, onClick)
        }
    }
}

@Composable
private fun PhilosopherItem(name: String, onClick: (name: String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp, 16.dp, 4.dp, 4.dp)
            .size(160.dp)
            .clickable {
                onClick(name)
            }
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painter = painterResource(R.drawable.wave_haikei),
                contentScale = ContentScale.Crop
            )
            .border(2.dp, Color.Gray),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = name,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}