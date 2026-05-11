package com.library.service

import com.library.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookQueryService(
    val bookRepository: BookRepository
) {
    fun search(query: String, page: Int, size: Int) = bookRepository.search(query, page, size)
}