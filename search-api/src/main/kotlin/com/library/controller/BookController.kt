package com.library.controller

import com.library.request.SearchRequest
import com.library.response.PageResult
import com.library.response.SearchResponse
import com.library.response.StatResponse
import com.library.service.BookApplicationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/v1/books")
class BookController(
    private val bookApplicationService: BookApplicationService
) {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun search(
        @Validated @ModelAttribute request: SearchRequest
    ): PageResult<SearchResponse> {
        log.info("search query={}, page={}, size={}", request.query, request.page, request.size)
        return bookApplicationService.search(request.query, request.page, request.size)
    }

    @GetMapping("/stats")
    fun findQueryStats(
        @RequestParam query: String,
        @RequestParam date: LocalDate
    ): StatResponse {
        log.info("find stats query={}, date={}", query, date)
        return bookApplicationService.findQueryCount(query, date)
    }
}