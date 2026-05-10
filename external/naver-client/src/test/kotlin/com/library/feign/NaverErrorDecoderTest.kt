package com.library.feign

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import tools.jackson.databind.ObjectMapper

@ExtendWith(MockitoExtension::class)
class NaverErrorDecoderTest {

    @Mock
    lateinit var objectMapper: ObjectMapper

    @InjectMocks
    lateinit var naverErrorDecoder: NaverErrorDecoder

}