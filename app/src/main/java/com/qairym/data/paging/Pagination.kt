package com.qairym.data.paging

interface Pagination<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}