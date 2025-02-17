package com.example.learning.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learning.viewmodels.QuotesViewModel

@Composable
fun QuoteScreen(modifier: Modifier = Modifier) {
    val quotesViewModel: QuotesViewModel = hiltViewModel()
    val quotes = quotesViewModel.quotes.collectAsState()
    LazyColumn {
        items(quotes.value) {
            QuoteItem(quote = it.quote)
        }
    }
}

@Composable
fun QuoteItem(quote: String, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        border = BorderStroke(1.dp, Color.Blue)
    ) {
        Text(
            text = quote,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}