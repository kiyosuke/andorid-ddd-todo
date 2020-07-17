package com.kiyosuke.model

interface TodoFactory {

    fun create(title: String, content: String?): Todo
}