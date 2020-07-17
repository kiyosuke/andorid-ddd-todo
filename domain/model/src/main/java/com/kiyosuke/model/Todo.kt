package com.kiyosuke.model

class Todo(
    val id: TodoId,
    title: TodoTitle,
    content: String?,
    isDone: Boolean
) {
    var title: TodoTitle
        private set

    var content: String?
        private set

    var isDone: Boolean
        private set

    init {
        this.title = title
        this.content = content
        this.isDone = isDone
    }

    fun changeTitle(title: TodoTitle) {
        this.title = title
    }

    fun changeContent(content: String?) {
        this.content = content
    }

    fun done() {
        this.isDone = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Todo

        if (id != other.id) return false
        if (title != other.title) return false
        if (content != other.content) return false
        if (isDone != other.isDone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + (content?.hashCode() ?: 0)
        result = 31 * result + isDone.hashCode()
        return result
    }

    override fun toString(): String {
        return "Todo(id=$id, title='$title', content=$content, isDone=$isDone)"
    }
}