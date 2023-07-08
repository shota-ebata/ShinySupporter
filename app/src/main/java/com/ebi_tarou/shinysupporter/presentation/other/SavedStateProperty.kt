package com.ebi_tarou.shinysupporter.presentation.other

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


/**
 * Int
 * Float
 * Long
 * Boolean
 * String
 * Parcelable
 * Serializable
 * Enum
 * Array
 */
class SavedStateProperty<T: ViewModel, V>(
    private val savedStateHandle: SavedStateHandle,
    private val key: String? = null
): ReadOnlyProperty<T, V> {

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        val key = key ?: property.name

        @Suppress("UNCHECKED_CAST")
        return savedStateHandle.get<V>(key) as V
    }
}