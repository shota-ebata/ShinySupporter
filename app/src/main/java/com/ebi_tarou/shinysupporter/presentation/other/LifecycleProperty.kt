package com.ebi_tarou.shinysupporter.presentation.other

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private object EMPTY

class LifecycleReadWriteProperty<T : LifecycleOwner, V> : ReadWriteProperty<T, V>, DefaultLifecycleObserver {
    private var value: Any? = EMPTY
    private var attachedToLifecycleOwner = false
    private var thisRef: T? = null

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        if (value == EMPTY) {
            throw UninitializedPropertyAccessException()
        }
        @Suppress("UNCHECKED_CAST")
        return value as V
    }

    private fun checkAddToLifecycleOwner(thisRef: T) {
        if (!attachedToLifecycleOwner) {
            this.thisRef = thisRef
            when (thisRef) {
                is Fragment -> thisRef.viewLifecycleOwner.lifecycle.addObserver(this)
                else -> thisRef.lifecycle.addObserver(this)
            }
            attachedToLifecycleOwner = true
        }
    }

    override fun setValue(thisRef: T, property: KProperty<*>, value: V) {
        checkAddToLifecycleOwner(thisRef)
        this.value = value
    }

    override fun onDestroy(owner: LifecycleOwner) {
        value = EMPTY
        when (val thisRef = this.thisRef) {
            is Fragment -> thisRef.viewLifecycleOwner.lifecycle.removeObserver(this)
            else -> thisRef?.lifecycle?.removeObserver(this)
        }
        attachedToLifecycleOwner = false
        this.thisRef = null
        super.onDestroy(owner)
    }
}

// 参考： https://gist.github.com/chrisbanes/fc4392dcbdc0aa5d99147dc551616676
class LifecycleReadOnlyProperty<T : LifecycleOwner, V>(
    private val initializer: (thisRef: T, property: KProperty<*>) -> V
) : ReadOnlyProperty<T, V>, DefaultLifecycleObserver {
    private var value: Any? = EMPTY
    private var attachedToLifecycleOwner = false
    private var thisRef: T? = null

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        this.thisRef = thisRef
        checkAddToLifecycleOwner(thisRef)
        if (value == EMPTY) {
            value = initializer(thisRef, property)
        }
        @Suppress("UNCHECKED_CAST")
        return value as V
    }

    private fun checkAddToLifecycleOwner(thisRef: T) {
        if (!attachedToLifecycleOwner) {
            when (thisRef) {
                is Fragment -> thisRef.viewLifecycleOwner.lifecycle.addObserver(this)
                else -> thisRef.lifecycle.addObserver(this)
            }
            attachedToLifecycleOwner = true
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        value = EMPTY
        when (owner) {
            is Fragment -> owner.viewLifecycleOwner.lifecycle.removeObserver(this)
            else -> owner.lifecycle.removeObserver(this)
        }
        attachedToLifecycleOwner = false
        super.onDestroy(owner)
    }
}

inline fun <reified T : Fragment, V> bindViewLifecycle() = LifecycleReadWriteProperty<T, V>()
inline fun <reified T : Fragment, V> bindViewLifecycleLazy(noinline initializer: (thisRef: T, property: KProperty<*>) -> V) = LifecycleReadOnlyProperty(initializer)
inline fun <reified T : AppCompatActivity, V> bindLifecycle() = LifecycleReadWriteProperty<T, V>()
inline fun <reified T : AppCompatActivity, V> bindLifecycleLazy(noinline initializer: (thisRef: T, property: KProperty<*>) -> V) = LifecycleReadOnlyProperty(initializer)
