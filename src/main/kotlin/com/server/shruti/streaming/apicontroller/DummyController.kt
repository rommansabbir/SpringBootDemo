package com.server.shruti.streaming.apicontroller

import com.server.shruti.streaming.base.APIErrors
import com.server.shruti.streaming.base.APIResponse
import com.server.shruti.streaming.services.DummyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/dummy") //Route for the controller
class DummyController(private val service: DummyService) {
    @GetMapping("success") //Return a dummy success response
    fun getDummySuccess() = APIResponse(message = "Success", data = service.getUserList())

    @GetMapping("error") //Return a dummy error response with list of exceptions
    fun getDummyError() = APIResponse<Any>(
        status = false, message = "Error", data = null, mutableListOf(
            APIErrors.getDummyAPIException
        )
    )
}

