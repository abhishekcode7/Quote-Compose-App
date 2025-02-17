package com.example.learning.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learning.models.QuoteData
import com.example.learning.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val quotes: StateFlow<List<QuoteData>>
        get() = repository.quotes

    init {
        viewModelScope.launch {
            val name = savedStateHandle.get<String>("name")
            repository.getQuotes(name ?: "Plato")
        }
    }
}