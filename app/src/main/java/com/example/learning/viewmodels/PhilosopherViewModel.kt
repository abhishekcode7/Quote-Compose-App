package com.example.learning.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learning.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhilosopherViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val _philosophers: StateFlow<List<String>>
        get() = repository.philosophers

    init {
        viewModelScope.launch {
            repository.getPhilosophers()
        }
    }
}