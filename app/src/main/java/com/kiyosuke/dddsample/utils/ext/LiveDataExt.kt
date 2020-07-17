package com.kiyosuke.dddsample.utils.ext

import androidx.lifecycle.LiveData

fun <T : Any> LiveData<T>.requireValue(): T {
    return requireNotNull(value) { "value is null" }
}