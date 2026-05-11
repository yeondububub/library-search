package com.library.repository

import com.library.response.PageResult
import com.library.response.SearchResponse

interface BookRepository {

    fun search(query: String, page: Int, size: Int): PageResult<SearchResponse>
}