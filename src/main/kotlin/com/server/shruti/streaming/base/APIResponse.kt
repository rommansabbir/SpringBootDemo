package com.server.shruti.streaming.base


/**
 * This is representing API Response
 *
 * Note: This response model should be used for any API response across the application
 */
data class APIResponse<T>(
    val status: Boolean = true,
    val message: String,
    val data: T?,
    val error: MutableList<APIException> = mutableListOf()
)
