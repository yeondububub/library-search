package com.library.controller

import com.library.service.BookApplicationService
import com.library.service.BookQueryService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
class BookControllerTest {

    @Mock
    lateinit var bookQueryService: BookApplicationService

    lateinit var bookController: BookController
    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        bookController = BookController(bookQueryService)
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build()
    }

}