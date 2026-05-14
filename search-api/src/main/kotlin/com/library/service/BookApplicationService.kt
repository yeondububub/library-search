package com.library.service

import com.library.entity.DailyStat
import com.library.controller.response.PageResult
import com.library.controller.response.SearchResponse
import com.library.controller.response.StatResponse
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

    fun findTop5Query(): List<StatResponse> {
        return dailyStatsQueryService.findTop5Query()
    }
}