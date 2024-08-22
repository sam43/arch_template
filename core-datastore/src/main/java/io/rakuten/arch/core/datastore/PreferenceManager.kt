package io.rakuten.arch.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.byteArrayPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Reading values from DataStore
fun DataStore<Preferences>.readIntValueOf(intKey: String): Flow<Int> = this.data.map { it[intPreferencesKey(intKey)] ?: 0 }
fun DataStore<Preferences>.readStringValueOf(stringKey: String): Flow<String> = this.data.map { it[stringPreferencesKey(stringKey)] ?: "" }
fun DataStore<Preferences>.readBooleanValueOf(boolKey: String): Flow<Boolean> = this.data.map { it[booleanPreferencesKey(boolKey)] ?: false }
fun DataStore<Preferences>.readFloatValueOf(floatKey: String): Flow<Float> = this.data.map { it[floatPreferencesKey(floatKey)] ?: 0f }
fun DataStore<Preferences>.readDoubleValueOf(doubleKey: String): Flow<Double> = this.data.map { it[doublePreferencesKey(doubleKey)] ?: 0.0 }
fun DataStore<Preferences>.readLongValueOf(longKey: String): Flow<Long> = this.data.map { it[longPreferencesKey(longKey)] ?: 0L }
fun DataStore<Preferences>.readStringSetValueOf(stringSetKey: String): Flow<Set<String>> = this.data.map { it[stringSetPreferencesKey(stringSetKey)] ?: setOf() }
fun DataStore<Preferences>.readByteArrayValueOf(byteArrKey: String): Flow<ByteArray> = this.data.map { it[byteArrayPreferencesKey(byteArrKey)] ?: byteArrayOf() }

// Setting values in DataStore
suspend fun DataStore<Preferences>.writeIntValueOf(intKey: String, intValue: Int) = this.edit { pref -> pref[intPreferencesKey(intKey)] = intValue }
suspend fun DataStore<Preferences>.writeStringValueOf(stringKey: String, stringValue: String) = this.edit { pref -> pref[stringPreferencesKey(stringKey)] = stringValue }
suspend fun DataStore<Preferences>.writeBooleanValueOf(boolKey: String, boolValue:  Boolean) = this.edit { pref -> pref[booleanPreferencesKey(boolKey)] = boolValue }
suspend fun DataStore<Preferences>.writeFloatValueOf(floatKey: String, floatValue: Float) = this.edit { pref -> pref[floatPreferencesKey(floatKey)] = floatValue }
suspend fun DataStore<Preferences>.writeDoubleValueOf(doubleKey: String, doubleValue: Double) = this.edit { pref -> pref[doublePreferencesKey(doubleKey)] = doubleValue }
suspend fun DataStore<Preferences>.writeLongValueOf(longKey: String, longValue: Long) = this.edit { pref -> pref[longPreferencesKey(longKey)] = longValue }
suspend fun DataStore<Preferences>.writeStringSetValueOf(stringSetKey: String, stringSetValue: Set<String>) = this.edit { pref -> pref[stringSetPreferencesKey(stringSetKey)] = stringSetValue }
suspend fun DataStore<Preferences>.writeByteArrayValueOf(byteArrKey: String, byteArrValue: ByteArray) = this.edit { pref -> pref[byteArrayPreferencesKey(byteArrKey)] = byteArrValue }