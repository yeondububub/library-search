package com.library.service

import com.library.entity.DailyStat
import com.library.response.PageResult
import com.library.response.SearchResponse
import com.library.response.StatResponse
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class BookApplicationService(
    private val bookQueryService: BookQueryService,
    private val dailyStatCommandService: DailyStatCommandService,
    private val dailyStatsQueryService: DailyStatsQueryService
) {

    fun search(query: String, page: Int, size: Int): PageResult<SearchResponse> {
        val response = bookQueryService.search(query, page, size)
        val dailyStat = DailyStat(query, LocalDateTime.now())
        dailyStatCommandService.save(dailyStat)
        return response
    }

    fun findQueryCount(query: String, date: LocalDate): StatResponse {
        return dailyStatsQueryService.findQueryCount(query, date)
    }
}