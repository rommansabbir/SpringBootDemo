package com.server.shruti.streaming.base

/**
 * This class is responsible to manage all error codes & message for [APIException].
 *
 * Note: Any [APIException] or list of [APIException] should be populated by using this class.
 */
object APIErrors {
    private const val GENERIC_ERROR_CODE = 9999
    private const val GENERIC_ERROR_MESSAGE = "Something went wrong."
    private const val DUMMY_ERROR_CODE = 1001
    private const val DUMMY_ERROR_MESSAGE = "This is just a dummy error message!!!"

    private const val USER_NOT_FOUND_CODE = 1002
    private const val USER_NOT_FOUND_MESSAGE = "User not found"

    val getDummyAPIException = APIException(DUMMY_ERROR_CODE, DUMMY_ERROR_MESSAGE)

    val getUserNotFoundException = APIException(USER_NOT_FOUND_CODE,USER_NOT_FOUND_MESSAGE)

    fun mapTopAPIException(e : Exception) = APIException(GENERIC_ERROR_CODE, e.message ?: GENERIC_ERROR_MESSAGE )
}

