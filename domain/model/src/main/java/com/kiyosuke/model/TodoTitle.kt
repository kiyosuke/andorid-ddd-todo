package com.kiyosuke.model

data class TodoTitle(val value: String) {
    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("タイトルに空文字は許可されていません")
        }
    }
}