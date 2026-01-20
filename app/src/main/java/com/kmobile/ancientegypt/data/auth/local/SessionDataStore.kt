package com.kmobile.ancientegypt.data.auth.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "session")

class SessionDataStore(private val context: Context) {

    private val KEY_TOKEN = stringPreferencesKey("token")

    val tokenFlow: Flow<String?> =
        context.dataStore.data.map { prefs -> prefs[KEY_TOKEN] }

    suspend fun saveToken(token: String) {
        context.dataStore.edit { it[KEY_TOKEN] = token }
    }

    suspend fun clear() {
        context.dataStore.edit { it.remove(KEY_TOKEN) }
    }
}