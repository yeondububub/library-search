package com.library

import org.springframework.http.HttpStatus

class ApiException(
    val errorMessage: String,
    val errorType: ErrorType,
    val httpStatus: HttpStatus
): RuntimeException(errorMessage)