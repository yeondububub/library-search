package com.library.controller

import com.library.response.PageResult
import com.library.response.SearchResponse
import com.library.service.BookQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/books")
class BookController(
    private val bookQueryService: BookQueryService
) {
    @GetMapping
    fun search(
        @RequestParam("query") query: String,
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int
    ): PageResult<SearchResponse> {
        return bookQueryService.search(query, page, size)
    }
}