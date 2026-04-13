package com.example.noticias_practica3.data.repository

import androidx.datastore.preferences.preferencesDataStore
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_interests")
class InterestsRepository(private val context: Context) {
    private val SELECTED_INTERESTS = stringSetPreferencesKey("selected_interests")

    val selectedInterestsFlow: Flow<Set<String>> = context.dataStore.data
        .map { preferences ->
            preferences[SELECTED_INTERESTS] ?: emptySet()
        }

    suspend fun toggleInterest(interestName: String, isSelected: Boolean) {
        context.dataStore.edit { preferences ->
            val currentSet = preferences[SELECTED_INTERESTS] ?: emptySet()
            val newSet = currentSet.toMutableSet()

            if (isSelected) newSet.add(interestName)
            else newSet.remove(interestName)

            preferences[SELECTED_INTERESTS] = newSet
        }
    }
    object InterestsDataSource {
        val availableInterests = listOf(
            "Compose",
            "Kotlin",
            "Jetpack",
            "Material",
            "Android"
        )
    }
}