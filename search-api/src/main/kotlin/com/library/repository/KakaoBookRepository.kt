package com.library.repository

import com.library.controller.response.PageResult
import com.library.controller.response.SearchResponse

class KakaoBookRepository: BookRepository {

    override fun search(
        query: String,
        page: Int,
        size: Int
    ): PageResult<SearchResponse> {
        TODO("Not yet implemented")
    }
}