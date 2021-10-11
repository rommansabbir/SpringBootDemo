package com.server.shruti.streaming.base

/**
 * This class is responsible to manage all error codes & message for [APIException].
 *
 * Note: Any [APIException] or list of [APIException] should be populated by using this class.
 */
object APIErrors {
    private const val DUMMY_ERROR_CODE = 1001
    private const val DUMMY_ERROR_MESSAGE = "This is just a dummy error message!!!"

    val getDummyAPIException = APIException(DUMMY_ERROR_CODE, DUMMY_ERROR_MESSAGE)
}