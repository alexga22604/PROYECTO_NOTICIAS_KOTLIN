package com.example.noticias_practica3.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noticias_practica3.data.repository.InterestsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val TIMEOUT_MILLIS = 5000L

class InterestsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = InterestsRepository(application.applicationContext)
    val selectedInterests: StateFlow<Set<String>> = repository.selectedInterestsFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = emptySet()
        )

    fun toggleInterest(interest: String) {
        viewModelScope.launch {
            val isCurrentlySelected = selectedInterests.value.contains(interest)
            val newSelectionState = !isCurrentlySelected
            repository.toggleInterest(
                interest,
                isSelected = newSelectionState
            )
        }
    }
}