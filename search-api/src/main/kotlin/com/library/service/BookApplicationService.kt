package com.library.service

import com.library.entity.DailyStat
import com.library.response.PageResult
import com.library.response.SearchResponse
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class BookApplicationService(
    private val bookQueryService: BookQueryService,
    private val dailyStatCommandService: DailyStatCommandService
) {

    fun search(query: String, page: Int, size: Int): PageResult<SearchResponse> {
        val response = bookQueryService.search(query, page, size)
        val dailyStat = DailyStat(query, LocalDateTime.now())
        dailyStatCommandService.save(dailyStat)
        return response
    }
}