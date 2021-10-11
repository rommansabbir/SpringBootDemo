package com.server.shruti.streaming.controller

import com.server.shruti.streaming.base.APIErrors
import com.server.shruti.streaming.base.APIResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/dummy") //Route for the controller
class DummyController {
    @GetMapping("success") //Return a dummy success response
    fun getDummySuccess() = APIResponse(message = "Success", data = "Hello")

    @GetMapping("error") //Return a dummy error response with list of exceptions
    fun getDummyError() = APIResponse<Any>(
        status = false, message = "Error", data = null, mutableListOf(
            APIErrors.getDummyAPIException
        )
    )
}

