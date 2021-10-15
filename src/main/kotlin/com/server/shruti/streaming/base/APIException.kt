package com.server.shruti.streaming.base


/**
 * This is representing API exception
 */
data class APIException(val errorCode: Int, override val message: String) : Throwable()