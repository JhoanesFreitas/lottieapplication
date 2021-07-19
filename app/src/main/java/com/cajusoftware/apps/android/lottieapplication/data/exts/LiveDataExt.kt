package com.cajusoftware.apps.android.lottieapplication.data.exts

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

@MainThread
fun <T> LiveData<T>.emit(value: T) {
    require(this is MutableLiveData) { "$this isn't a valid MutableLiveData instance" }

    try {
        this.value = value
    } catch (e: NullPointerException) {
    }
}

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { action(it) } })
}