package com.library.feign

import com.library.NaverErrorResponse
import feign.Response
import feign.codec.ErrorDecoder
import tools.jackson.databind.ObjectMapper
import java.io.IOException
import java.lang.Exception
import java.nio.charset.StandardCharsets

class NaverErrorDecoder(
    private val objectMapper: ObjectMapper
): ErrorDecoder {

    override fun decode(p0: String?, p1: Response?): Exception {
        try {
            val body = String(p1!!.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8)
            val errorResponse = objectMapper.readValue(body, NaverErrorResponse::class.java)
            throw RuntimeException(errorResponse.errorMessage)
        } catch(e: IOException) {
            throw RuntimeException(e)
        }
    }
}