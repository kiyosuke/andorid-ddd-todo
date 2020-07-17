package com.kiyosuke.model

data class TodoId(val value: Long) {
    init {
        if (value < 0) {
            throw IllegalArgumentException("TodoIdは0以上を渡してください")
        }
    }

    val isNoId: Boolean get() = this == NO_ID

    companion object {
        val NO_ID = TodoId(0)
    }
}